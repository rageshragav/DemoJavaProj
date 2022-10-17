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

	import utils.Log;
	import utils.Utility;

	public class MensTshirtPage {
		
		@FindBy(xpath = "//span[@class='hm-icon-label' and text()='All']")
		private WebElement allBtn;

		@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a/div")
		private WebElement mensFashion;

		@FindBy(xpath = "//a[text()='T-shirts & Polos']")
		private WebElement tshirts;
		
		@FindBy(xpath = "//span[text()='T-Shirts']")
		private WebElement selectTshirtOpt;

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
		
		@FindBy(xpath = "//span[text()='XL']")
		private WebElement selectSize;
		
		@FindBy(xpath = "(//div[@class='colorsprite aok-float-left'])[13]")
		private WebElement selectColour;
		
		@FindBy(xpath = "//span[text()='Round Neck']")
		private WebElement selectNekline;
		
		@FindBy(xpath = "//span[text()='Short Sleeve']")
		private WebElement selectSleveLenght;
		
		@FindBy(xpath = "//span[text()='Solid']")
		private WebElement selectPattern;
		
		@FindBy(xpath = "//span[text()='Cotton']")
		private WebElement selectMaterial;
		
		@FindBy(xpath = "//div[@ class='a-section aok-relative s-image-tall-aspect']")
		private WebElement selectTshirt;
		
		@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
		private WebElement addToWishList;
		
		@FindBy(xpath = " //a[text()='View Your List']")
		private WebElement viewWishListBtn;
		
		@FindBy(xpath = "//a[@id='itemName_I2KBV8VWLDO0JU']")
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
		public MensTshirtPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}

		public void addMensTshirtToWishList() {
			
			allBtn.click();
			mensFashion.click();
			tshirts.click();
			selectTshirtOpt.click();
			selectTopBrandsOpt.click();
			selectCusReview.click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(lowPriceBox));
			lowPriceBox.sendKeys("1500");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(highPriceBox));
			highPriceBox.sendKeys("5000");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(goBtn));
			goBtn.click();
			selectSize.click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(selectColour));
			selectColour.click();
			/*wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(selectNekline));
			selectNekline.click();*/
			selectSleveLenght.click();
			selectPattern.click();
			selectMaterial.click();
			selectTshirt.click();
			Utility.switchToNewWindow(driver);
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
			public Boolean isWishListWithMensTshirtAdded() {
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


