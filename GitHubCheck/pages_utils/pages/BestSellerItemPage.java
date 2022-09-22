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
import org.testng.Assert;


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
	
	@FindBy(xpath = "(//div[@class='a-row']//following::div//h2//a)[1]")
	private WebElement nameOfTheitemInWishList;


	@FindBy(xpath = " //input[@name='submit.deleteItem']")
	private WebElement deleteItemfromWishList;

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	public String itemName;
	public String itemNameInWishList;

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