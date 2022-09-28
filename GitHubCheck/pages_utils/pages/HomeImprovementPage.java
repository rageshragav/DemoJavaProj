/**
 * 
 */
package pages;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log;
import utils.Utility;

/**
 * @author ragesh
 *
 */
public class HomeImprovementPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public String itemName;
	public String itemNameInWishList;
	public String className = this.getClass().getSimpleName();
	public HomeImprovementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//a[contains(text(),'Home Improvement')]")
	private WebElement homeImprovementMenu;

	@FindBy(xpath = "//body/div[@id='a-page']//div[2]//li[2]//span[1]//following::a//span[1][text()='Cleaning Supplies']")
	private WebElement cleaningSuppliesDepartment;

	@FindBy(xpath = "//ul//li//span//div//following::span//div//span[text()='Brooms']")
	private WebElement broomsMenuItem;

	@FindBy(xpath = "//div//span[text()='Brand']//following::ul//i//following::span[text()='Scotch-Brite']")
	private WebElement brandScotchBrite;

	// @FindBy(xpath = "//span[text()='RESULTS']//following::div[4]//div[2]//h2")
	// private WebElement firstItemFromResult;

	@FindBy(xpath = "//div[3]//div//div[@class='aok-relative']")
	private WebElement firstItemFromResult;

	@FindBy(xpath = "//div[3]//div//div[@class='aok-relative']//following::h2[1]")
	private WebElement firstItemNameFromResult;

	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishListbtn;

	@FindBy(xpath = "//a[contains(text(),'View Your List')]")
	private WebElement viewWishList;

	@FindBy(xpath = "//div[@class='a-row']//following::div//h2//a")
	private WebElement nameOfTheitemInWishList;

	@FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
	private WebElement addToCartFromWishList;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;

	@FindBy(xpath = "//span[@class='a-declarative']//input[@value='Delete']")
	private WebElement deleteButton;

	@FindBy(xpath = "//h1[contains(text(),'Your Amazon Cart is empty.')]")
	private WebElement emptyCartMessage;

	public WebElement itemInCart() {
		return driver.findElement(By.xpath("//span[@class='a-list-item']//a//span[1]//span[1][contains(text(),'"+itemName+"'"));
	}
	public void selectHomeImprovementItem() {
		if (isHomeImprovemntsVisisble()) {
			wait.until(ExpectedConditions.visibilityOf(homeImprovementMenu)).click();
			Log.info("Made a click in home improvements in home page container",className);
		} else {
			driver.get("https://www.amazon.in/gp/browse.html?node=3704992031&ref_=nav_cs_hi");
			Log.info("Since home improvements menu item not visible, navigating to home improvements page",className);
		}
		wait.until(ExpectedConditions.visibilityOf(cleaningSuppliesDepartment)).click();
		Log.info("Made a click in side menu cleaning supplies",className);
		wait.until(ExpectedConditions.visibilityOf(broomsMenuItem)).click();
		Log.info("Made a click in Brooms categories in home improvements ",className);
		wait.until(ExpectedConditions.visibilityOf(brandScotchBrite)).click();
		Log.info("Filtered brand as scotch-brite",className);
		getItemNameFromResult();
		Log.info("Getting the name of the item selecting from the search result",className);
		wait.until(ExpectedConditions.visibilityOf(firstItemFromResult)).click();
		Log.info("Clicking on item from the result",className);
		Utility.switchToNewWindow(driver);
		// wait.until(ExpectedConditions.visibilityOf(addToWishListbtn)).click();
		// wait.until(ExpectedConditions.visibilityOf(viewWishList)).click();
		// wait.until(ExpectedConditions.visibilityOf(addToCartFromWishList)).click();
		// wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut)).click();
	}

	public String getItemNameFromResult() {
		itemName = wait.until(ExpectedConditions.visibilityOf(firstItemNameFromResult)).getText();
		return itemName;
	}

	public String getItemNameFromWishList() {

		itemNameInWishList = wait.until(ExpectedConditions.visibilityOf(nameOfTheitemInWishList)).getText();
		return itemNameInWishList;
	}

	public void addBroomToWishList() {
		wait.until(ExpectedConditions.visibilityOf(addToWishListbtn)).click();
		Log.info("Moving the selected item to wishlist",className);
	}

	public void viewWishList() {

		wait.until(ExpectedConditions.visibilityOf(viewWishList)).click();
		Log.info("Viewing the selected item in wishlist page",className);
		getItemNameFromWishList();
	}

	public void addToCartViaWishList() {
		wait.until(ExpectedConditions.visibilityOf(addToCartFromWishList)).click();
		Log.info("Moving the item from wishlist to cart",className);
	}

	public void proceedToCheckoutFromWishList() {
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut)).click();
		Log.info("proceeding to checkout the item from cart",className);
	}

	public void deleteItemFromCart() {
		driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
		wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();
		Log.info("Deleting item from the cart",className);
	}

	public Boolean isHomeImprovemntsVisisble() {

		try {
			wait.until(ExpectedConditions.visibilityOf(homeImprovementMenu));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public Boolean isWishListWithBroomAdded() {
		try {
			Assert.assertEquals(itemName, itemNameInWishList);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public Boolean isItemDeleted() {
		try {
			wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
			return true;
		} catch (Exception e) {
			// TODO: handle exception

			return false;
		}
	}
}
