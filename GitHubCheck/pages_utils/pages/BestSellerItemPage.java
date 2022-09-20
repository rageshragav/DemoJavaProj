package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestSellerItemPage {

	@FindBy(xpath = "(//a[text()='Best Sellers'])[1]")
	private WebElement bestSeller;

	@FindBy(xpath = "//a[text()='Hot New Releases']")
	private WebElement hotNewReleases;

	@FindBy(xpath = "(//a[text()='Books'])[2]")
	private WebElement books;

	@FindBy(xpath = "//a[text()='Action & Adventure']")
	private WebElement actionAndAdeventure;

	@FindBy(xpath = "//div[text()='War of Lanka (Ram Chandra Series Book 4)']")
	private WebElement warOfLanka;

	@FindBy(xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishListbtn;

	@FindBy(xpath = " //*[@id=\"a-autoid-23\"]/span/input")
	private WebElement createListBtn;

	@FindBy(xpath = " //*[@id=\"huc-view-your-list-button\"]/span/a")
	private WebElement viewWishListBtn;

	@FindBy(xpath = " //input[@name='submit.deleteItem']")
	private WebElement deleteItemfromWishList;

	@FindBy(xpath = " (//a[text()='Sports, Fitness & Outdoors'])[2]")
	private WebElement sportsFitneesOutdoors;

	@FindBy(xpath = " //a[text()='Cricket']")
	private WebElement cricket;

	@FindBy(xpath = " //a[text()='Bats']")
	private WebElement bats;

	@FindBy(xpath = " //a[text()='Kashmir Willow']")
	private WebElement kashmirWillow;

	@FindBy(xpath = " //div[contains(text(),'DSC Belter Wood Kashmir Willow Cricket Bat Short Handle Mens (Multicolour)')]")
	private WebElement dscbat;

	@FindBy(xpath = " //span[text()=' Price ']")
	private WebElement pricebtn;

	@FindBy(xpath = "//span[@class='refinement-row sbl-refinement-option-button sbl-refinement-price-3']/span")
	private WebElement selectPrice;

	@FindBy(xpath = " //span[text()=' Review ']")
	private WebElement reviewbtn;

	@FindBy(xpath = " (//span[@class='sbl-review-item'and text()=' & Up '])[1]")
	private WebElement selectReview;

	@FindBy(xpath = " //span[text()=' Cricket Bat Size ']")
	private WebElement batSizebtn;

	@FindBy(xpath = " //span[@class='shopbylook-btf-clickable'and text()='5']")
	private WebElement selectBatSize;

	@FindBy(xpath = " //span[ text()=' Brand ']")
	private WebElement brandbtn;

	@FindBy(xpath = " //span[ @class='shopbylook-btf-clickable'and text()='SG']")
	private WebElement selectBrand;

	@FindBy(xpath = "//div[contains(@class,'a-image-container a-dynamic-image-container shopbylook-btf-image-container')]")
	private WebElement sgBat;

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	public BestSellerItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void addBestSellerBookToWishList() {
		
		bestSeller.click();
		hotNewReleases.click();
		books.click();
		actionAndAdeventure.click();
		warOfLanka.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addToWishListbtn));
		addToWishListbtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewWishListBtn));
		viewWishListBtn.click();
        deleteItemfromWishList.click();
	}

	public void addBestSellerBatToWishList() throws InterruptedException {
		bestSeller.click();
		sportsFitneesOutdoors.click();
		cricket.click();
		bats.click();
		kashmirWillow.click();
		dscbat.click();
		pricebtn.click();
		selectPrice.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(reviewbtn));
		reviewbtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectReview));
		selectReview.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(batSizebtn));
		batSizebtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectBatSize));
		selectBatSize.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(brandbtn));
		brandbtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(selectBrand));
		selectBrand.click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(sgBat));
		// driver.navigate().to("https://www.amazon.in/dp/B00IDALQRU/ref=sbl_dpx_in-sports-cricket-bats_B08J7FRFY8_0?th=1&psc=1");
		sgBat.click();
		addToWishListbtn.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(viewWishListBtn));
		viewWishListBtn.click();
        deleteItemfromWishList.click();
	}
}
