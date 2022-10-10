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

import utils.Log;

public class SmartPhonePage {
	@FindBy(xpath = "//span[@class='hm-icon-label' and text()='All']")
	private WebElement allBtn;

	@FindBy(xpath = "//a/div[text()='Mobiles, Computers']")
	private WebElement mobileComputers;

	@FindBy(xpath = "//a[text()='All Mobile Phones']")
	private WebElement allMobilePhones;

	@FindBy(xpath = "//span[@dir='auto' and text()='Smartphones & Basic Mobiles']")
	private WebElement smartphonesAndBasicMobiles;

	@FindBy(xpath = "//span[@dir='auto' and text()='Smartphones']")
	private WebElement Smartphones;

	@FindBy(xpath = "//span[@dir='auto' and text()='Top Brands']")
	private WebElement selectTopBrandsOpt;

	@FindBy(xpath = "//i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	private WebElement selectCusReview;
	
	@FindBy(xpath = "//span[text()='Over ₹20,000']")
	private WebElement selectPrice;
	
	@FindBy(xpath = "//input[@id='low-price']")
	private WebElement lowPriceBox;
	
	@FindBy(xpath = "//input[@id='high-price']")
	private WebElement highPriceBox;
	
	@FindBy(xpath = "(//input[@type='submit' ])[2]")
	private WebElement goBtn;
	
	@FindBy(xpath = "//span[text() ='Android']")
	private WebElement selectOperatingSystem;
	
	@FindBy(xpath = "//span[text() ='128 GB']")
	private WebElement selectIntenalMemory;
	
	@FindBy(xpath = "//span[text() ='8 GB & above']")
	private WebElement selectRam;
	
	@FindBy(xpath = "//span[text() ='Octa Core']")
	private WebElement selectCore;
	
	@FindBy(xpath = "//span[text() ='2.5 GHz & Above']")
	private WebElement selectProcessor;
	
	@FindBy(xpath = "//span[text() ='4000 mAh & More']")
	private WebElement selectBattery;
	
	@FindBy(xpath = "//span[text() ='AMOLED']")
	private WebElement selectDisplay;
	
	@FindBy(xpath = "//span[text() ='Fingerprint Recognition']")
	private WebElement selectBiomatricFeature;
	
	@FindBy(xpath = "//span[text() ='USB Type C']")
	private WebElement selectConnectorType;
	
	@FindBy(xpath = "//span[text() ='5G']")
	private WebElement selectTechnology;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div/div/div/div[2]/div[1]/h2/a/span")
	private WebElement selectSmartPhone;
	
	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishList;
	
	@FindBy(xpath = " //a[text()='View Your List']")
	private WebElement viewWishListBtn;
	
	@FindBy(xpath = "//*[@id=\"itemName_IZ608WYT8Q9KL\"]")
	private WebElement nameOfTheitemInWishList;
	
	@FindBy(xpath = "//a[contains(text(),'Add to Cart')]")
	private WebElement addToCartFromWishList;

	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOut;

	@FindBy(xpath = "//span[@class='a-declarative']//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//h1[contains(text(),'Your Amazon Cart is empty.')]")
	private WebElement emptyCartMessage;

	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	public String itemName;
	public String itemNameInWishList;
	public String className = this.getClass().getSimpleName();
	public SmartPhonePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void addSmartPhoneToWishList() {
		
		allBtn.click();
		mobileComputers.click();
		allMobilePhones.click();
		smartphonesAndBasicMobiles.click();
		Smartphones.click();
		selectTopBrandsOpt.click();
		selectCusReview.click();
		//selectPrice.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(lowPriceBox));
		lowPriceBox.sendKeys("15000");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(highPriceBox));
		highPriceBox.sendKeys("50000");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(goBtn));
		goBtn.click();
		selectOperatingSystem.click();
		selectDisplay.click();
		selectIntenalMemory.click();
		selectRam.click();
		selectCore.click();
		//selectProcessor.click();
		selectBattery.click();
		selectConnectorType.click();
		selectTechnology.click();
		selectSmartPhone.click();
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

	public String getItemNameFromWishList() {

		itemNameInWishList = wait.until(ExpectedConditions.visibilityOf(nameOfTheitemInWishList)).getText();
		return itemNameInWishList;
	}
	public Boolean isWishListWithSmartPhoneAdded() {
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

	
