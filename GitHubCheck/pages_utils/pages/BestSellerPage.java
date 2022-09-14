package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestSellerPage {


	@FindBy (xpath = "//*[@id=\"nav-xshop\"]/a[5]")
	private WebElement bestSeller;
	
	@FindBy (xpath = "//a[text()='Hot New Releases']")
	private WebElement hotNewReleases;
	
	@FindBy (xpath = "(//a[text()='Books'])[2]")
	private WebElement books;
	
	@FindBy (xpath = "//a[text()='Action & Adventure']")
	private WebElement actionAndAdeventure;
	

	@FindBy (xpath = "//div[text()='War of Lanka (Ram Chandra Series Book 4)']")
	private WebElement warOfLanka;
	
	@FindBy (xpath = "//input[@id='add-to-wishlist-button-submit']")
	private WebElement addToWishListbtn;
	
	
	private WebDriver driver;
	private  WebDriverWait wait ;
	private Actions actions;
	
	public BestSellerPage(WebDriver driver)
	 {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void openbestSeller()
	   {
		bestSeller.click();
	   }
	public void openHotNewReleasesPage()
	   {
		hotNewReleases.click();
	   }
	 public String getTextOfHotNewReleasesElement()
	   {
		 String  text = hotNewReleases.getText();
		 return text;
	   }
	 public void clickOnBooks() {

		 books.click();
		}
	 public void clickOnactionAndAdeventure() {

		 actionAndAdeventure.click();
		}
	 public void clickOnwarOfLankaBook() {

		 warOfLanka.click();
		}
	 public void clickOnAddToWishListButton() {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(addToWishListbtn));
			addToWishListbtn.click();
			
		}

}
