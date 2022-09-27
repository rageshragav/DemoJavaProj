package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BabyProductPage {
	@FindBy(xpath = "//a[text()='Baby']")
	private WebElement babyProducts;

	@FindBy(xpath = "//span[text()='Baby Care']")
	private WebElement babyCare;

	@FindBy(xpath = "//span[@dir='auto' and text()='Skin Care']")
	private WebElement skinCare;

	@FindBy(xpath = "//span[@dir='auto' and text()='Oils']")
	private WebElement Oils;

	@FindBy(xpath = "//span[@dir='auto' and text()='Top Brands']")
	private WebElement topBrands;

	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	private WebElement selectCusReview;

	@FindBy(xpath = "//span[@class='a-size-base a-color-base' and text()='All']")
	private WebElement selectSkinType;

	@FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal' and contains(text(),'Maate Baby Massage Oil | Enhances Bone Mineralization')])[1]")
	private WebElement selectproduct;
	
	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishList;
	
	@FindBy(xpath = " //a[text()='View Your List']")
	private WebElement viewWishListBtn;
	
	@FindBy(xpath = "//*[@id=\"itemName_I17T99ICZEX29N\"]")
	private WebElement nameOfTheitemInWishList;

	@FindBy(xpath = "//*[@id=\"pab-I17T99ICZEX29N\"]/span/a")
	private WebElement addToCart;


	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	public String itemName;
	public String itemNameInWishList;

	public BabyProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void addBabyProductToWishList() {
		
		babyProducts.click();
		babyCare.click();
		skinCare.click();
		Oils.click();
		topBrands.click();
		selectCusReview.click();
		selectSkinType.click();
		selectproduct.click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addToWishList));
		addToWishList.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewWishListBtn));
		viewWishListBtn.click();
       
	}
	public String getItemNameFromWishList() {

		itemNameInWishList = wait.until(ExpectedConditions.visibilityOf(nameOfTheitemInWishList)).getText();
		return itemNameInWishList;
	}
	public Boolean isWishListWithwarOfLankaAdded() {
		try {
			Assert.assertEquals(itemName, itemNameInWishList);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
}
}
