package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class HomePage {
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBar;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchIcon;

	@FindBy(xpath = "//span[contains(text(),'Apple iPhone 12 (128GB) - Green')]")
	private WebElement searchResult;

	@FindBy(xpath = "//span[text()='Account & Lists']")
	private WebElement accountAndList;

	@FindBy(xpath = "//a[text()='Edit Account']")
	private WebElement editAccount;

	@FindBy(xpath = "//a[text()='Delete Account']")
	private WebElement deleteAccount;

	@FindBy(xpath = "//a[text()='Mini Statement']")
	private WebElement miniStatement;

	@FindBy(xpath = "//a[text()='Customised Statement']")
	private WebElement customizeStatement;

	@FindBy(xpath = "//span[contains(text(),'Sign Out')]")
	private WebElement logout;

	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//a//div[contains(text(),'Mobiles, Computers')]")
	private WebElement computerMenuItem;

	@FindBy(xpath = "//a[contains(text(),'Laptops')]")
	private WebElement laptopMenuItem;

	@FindBy(xpath = "//a//div[contains(text(),'Echo & Alexa')]")
	private WebElement echoMenu;

	@FindBy(xpath = "//a[contains(text(),'All-new Echo Dot (4th Gen)')]")
	private WebElement echoDot4thGen;

	@FindBy(xpath = "//li//a//div[contains(text(),'Fire TV')]")
	private WebElement fireTv;

	@FindBy(xpath = "//a[contains(text(),'All-new Fire TV Stick (3rd Gen)')]")
	private WebElement fireTvNewGen;

	@FindBy(xpath = "//a//div[contains(text(),'see all')]")
	private WebElement seeAllLink;

	@FindBy(xpath = "//div[@id='hmenu-content']")
	public WebElement menuContent;

	@FindBy(xpath = "//div[contains(text(),\"Toys, Baby Products, Kids' Fashion\")]")
	public WebElement toysMenu;

	@FindBy(xpath = "//li//a[contains(text(),\"Toys & Games\")]")
	public WebElement toysGamesMenu;

	
	
	
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	public String className = this.getClass().getSimpleName();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
	}

	public void clickHamburgerMenuItem() {
		wait.until(ExpectedConditions.visibilityOf(hamburgerMenu)).click();
	}

	public void clickComputerMenuItem() {
		wait.until(ExpectedConditions.visibilityOf(computerMenuItem)).click();
	}

	public void clickLaptopMenuItem() {
		wait.until(ExpectedConditions.visibilityOf(laptopMenuItem)).click();
	}

	public void clickEchoMenuItem() {
		wait.until(ExpectedConditions.visibilityOf(echoMenu)).click();
	}
	
	public void clickEchoDotItem() {
		wait.until(ExpectedConditions.visibilityOf(echoDot4thGen)).click();
	}

	public void clickFireTvItem() {
		wait.until(ExpectedConditions.visibilityOf(fireTv)).click();
	}
	
	public void clickFireTvGen() {
		wait.until(ExpectedConditions.visibilityOf(fireTvNewGen)).click();
	}
	
	public void clickToysMenu() {
		wait.until(ExpectedConditions.visibilityOf(toysMenu)).click();
	}
	
	public void clickToysGamesMenu() {
		wait.until(ExpectedConditions.visibilityOf(toysGamesMenu)).click();
	}
	public void seeAllMenu() {
		wait.until(ExpectedConditions.visibilityOf(seeAllLink)).click();
	}
	public void searchItem(String itemToSearch) {
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.clear();
		searchBar.sendKeys(itemToSearch);
		Log.info("Searching for the item " + itemToSearch, className);
	}

	public void clickOnSearchIcon() {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchIcon));
			searchIcon.click();
			Log.info("Made a click on search icon", className);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while clicking on the search icon", className);
		}
	}

	public void clickOnSearchResult() {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchResult));
			searchResult.click();
			Log.info("Clickig on the required item from the search result", className);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while clicking on the search result " + e, className);
		}
	}

	public void openeditAccountPage() {
		wait.until(ExpectedConditions.visibilityOf(editAccount));
		actions.moveToElement(editAccount).build().perform();
	}

	public void opendeleteAccountPage() {
		wait.until(ExpectedConditions.visibilityOf(deleteAccount));
		actions.moveToElement(deleteAccount).build().perform();
	}

	public void openminiStatementPage() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(miniStatement));
		actions.moveToElement(miniStatement).build().perform();
	}

	public void opencustomizeStatementPage() {
		wait.until(ExpectedConditions.visibilityOf(customizeStatement));
		actions.moveToElement(customizeStatement).build().perform();
	}

	public void clickOnlogOutTab() {
		accountAndList.click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logout));
		logout.click();
	}
}