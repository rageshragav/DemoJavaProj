package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage 
{
	@FindBy (xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBar;
	
	@FindBy (xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchIcon;
	
	@FindBy (xpath = "//span[contains(text(),'Apple iPhone 12 (64GB) - Blue')]")
	private WebElement searchResult;
	
	@FindBy (xpath = "//a[text()='New Account']")
	private WebElement newAccount;
	
	@FindBy (xpath = "//a[text()='Edit Account']")
	private WebElement editAccount;
	
	@FindBy (xpath = "//a[text()='Delete Account']")
	private WebElement deleteAccount;
	
	@FindBy (xpath = "//a[text()='Mini Statement']")
	private WebElement miniStatement;
	
	@FindBy (xpath = "//a[text()='Customised Statement']")
	private WebElement customizeStatement;

	@FindBy (xpath = "//a[text()='Log out']")
	private WebElement logOut;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	//	new WebDriverWait(driver,Duration.ofSeconds(10));
		 actions = new Actions(driver);
	}
	public void searchItem(String itemToSearch)
	   {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(searchBar));
		 searchBar.clear();
		 searchBar.sendKeys(itemToSearch);
	   }
	public void clickOnSearchIcon()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(searchIcon));
		 searchIcon.click();
	   }
	public void clickOnSearchResult()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(searchResult));
		 searchResult.click();
	   }
	public void opennewAccountPage()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(newAccount));
		 actions.moveToElement(newAccount).build().perform();
	   }
	public void openeditAccountPage()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(editAccount));
		 actions.moveToElement(editAccount).build().perform();
	   }
	public void opendeleteAccountPage()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(deleteAccount));
		 actions.moveToElement(deleteAccount).build().perform();
	   }
	public void openminiStatementPage()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(miniStatement));
		 actions.moveToElement(miniStatement).build().perform();
	   }
	public void opencustomizeStatementPage()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(customizeStatement));
		 actions.moveToElement(customizeStatement).build().perform();
	   }
	public void clickOnlogOutTab()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   wait.until(ExpectedConditions.visibilityOf(logOut));
		   logOut.click();
	   }
}