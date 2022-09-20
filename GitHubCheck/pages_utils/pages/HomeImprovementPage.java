/**
 * 
 */
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.beust.jcommander.internal.Console;

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

	public void selectHomeImprovementItem() {
		if (isHomeImprovemntsVisisble()) {
			wait.until(ExpectedConditions.visibilityOf(homeImprovementMenu)).click();
		} else {
			driver.get("https://www.amazon.in/gp/browse.html?node=3704992031&ref_=nav_cs_hi");
		}
		wait.until(ExpectedConditions.visibilityOf(cleaningSuppliesDepartment)).click();
		wait.until(ExpectedConditions.visibilityOf(broomsMenuItem)).click();
		wait.until(ExpectedConditions.visibilityOf(brandScotchBrite)).click();
		getItemNameFromResult();
		wait.until(ExpectedConditions.visibilityOf(firstItemFromResult)).click();
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
	}

	public void viewWishList() {

		wait.until(ExpectedConditions.visibilityOf(viewWishList)).click();
		getItemNameFromWishList();
	}

	public void addToCartViaWishList() {
		wait.until(ExpectedConditions.visibilityOf(addToCartFromWishList)).click();
	}

	public void proceedToCheckoutFromWishList() {
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut)).click();
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
}
