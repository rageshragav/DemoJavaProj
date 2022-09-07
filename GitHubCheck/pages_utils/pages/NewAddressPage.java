package pages;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAddressPage {
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	public WebElement customerProfile;

	@FindBy(xpath = "//*[@class='a-box-inner']//following::div/h2[contains(text(),'Your Addresses')]")
	public WebElement addressBox;

	@FindBy(xpath = "//h1[contains(text(),'Your Addresses')]//following::div//h2[contains(text(),'Add address')]")
	public WebElement addAddress;

	@FindBy(xpath = "//span[contains(text(),'Full name')]//following::input[1]")
	private WebElement customerName;

	@FindBy(xpath = "//span[contains(text(),'Mobile number')]//following::input[1]")
	private WebElement mobileNumber;

	@FindBy(xpath = "//span[contains(text(),'Pincode')]//following::input[1]")
	private WebElement pinCode;

	@FindBy(xpath = "//span[contains(text(),'Flat')]//following::input[1]")
	private WebElement flat;

	@FindBy(xpath = "//span[contains(text(),'Area')]//following::input[1]")
	private WebElement area;

	@FindBy(xpath = "//span[contains(text(),'Landmark')]//following::input[1]")
	private WebElement landmark;

	@FindBy(xpath = "//span[@id='address-ui-widgets-form-submit-button']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath = "//span[@id='a-autoid-2")
	private WebElement saveAddressBtn;


	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;

	public NewAddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnCustomerProfile() {

		customerProfile.click();
	}

	public void clickOnYourAddressBar() {

		addressBox.click();
	}

	public void clickOnAddAddress() {

		addAddress.click();
	}

	public void enterCustomerName(String NameOfCustomer) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(customerName));
		customerName.clear();
		customerName.sendKeys(NameOfCustomer);
	}

	public void fillMobileNumber(String mobileNum) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mobileNumber));
		mobileNumber.clear();
		mobileNumber.sendKeys(mobileNum);
	}

	public void fillPinCode(String pin) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(pinCode));
		pinCode.clear();
		pinCode.sendKeys(pin);
	}

	public void fillFlat(String flatName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(flat));
		flat.clear();
		flat.sendKeys(flatName);
	}

	public void fillArea(String areaName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(area));
		area.clear();
		area.sendKeys(areaName);
	}

	public void fillLandmark(String landmarkName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(landmark));
		landmark.clear();
		landmark.sendKeys(landmarkName);
	}

	public void clickOnAddAdressButton() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addAddressBtn));
		addAddressBtn.click();
		
	}
	
	public boolean saveAddressButtonVisiblity() {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(saveAddressBtn));
			return true;
		} catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			return false;
		}
	}

}
