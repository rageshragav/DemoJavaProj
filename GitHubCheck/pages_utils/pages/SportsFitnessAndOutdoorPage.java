package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SportsFitnessAndOutdoorPage {
	
	@FindBy(xpath = " //a[text()='Sports, Fitness & Outdoors']")
	private WebElement sportsFitneesOutdoors;

	@FindBy(xpath = " //span[@dir='auto' and text()='Cricket']")
	private WebElement cricket;

	@FindBy(xpath = " //span[@dir='auto' and text()='Bats']")
	private WebElement bats;

	@FindBy(xpath = " //span[@dir='auto' and text()='English Willow']")
	private WebElement EnglishWillow;

	@FindBy(xpath = " //span[@dir='auto' and text()='Top Brands']")
	private WebElement topBrands;

	@FindBy(xpath = " //i[@class='a-icon a-icon-star-medium a-star-medium-4']")
	private WebElement selectReview;

	@FindBy(xpath = "//span[@class='a-size-base a-color-base' and text()='₹5,000 - ₹10,000']")
	private WebElement selectPrice;

	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span")
	private WebElement Bat;
	
	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishListbtn;

	@FindBy(xpath = " //*[@id=\"a-autoid-23\"]/span/input")
	private WebElement createListBtn;

	@FindBy(xpath = " //a[text()='View Your List']")
	private WebElement viewWishListBtn;
	
	@FindBy(xpath = "//*[@id=\"itemName_I3H8RUPC2T2EYS\"]")
	private WebElement nameOfTheitemInWishList;


	@FindBy(xpath = " //input[@name='submit.deleteItem']")
	private WebElement deleteItemfromWishList;

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	public String itemName;
	public String itemNameInWishList;

	public SportsFitnessAndOutdoorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void addSportsItemToWishList() throws InterruptedException {
		
		sportsFitneesOutdoors.click();
		cricket.click();
		bats.click();
		EnglishWillow.click();
		topBrands.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectReview));
		selectReview.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectPrice));
		selectPrice.click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Bat));
		// driver.navigate().to("https://www.amazon.in/dp/B00IDALQRU/ref=sbl_dpx_in-sports-cricket-bats_B08J7FRFY8_0?th=1&psc=1");
		Bat.click();
		Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<>(windowHandles);
		 
		 driver.switchTo().window(windowHandlesList.get(1));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(addToWishListbtn)).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewWishListBtn));
		viewWishListBtn.click();
        deleteItemfromWishList.click();
	}
	

	public String getItemNameFromWishList() {

		itemNameInWishList = wait.until(ExpectedConditions.visibilityOf(nameOfTheitemInWishList)).getText();
		return itemNameInWishList;
	}
	public Boolean isWishListWithSportsItemAdded() {
		try {
			Assert.assertEquals(itemName, itemNameInWishList);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
}
}