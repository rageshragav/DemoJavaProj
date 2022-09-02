package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCustomerPage 
{
	@FindBy (xpath = "//a[contains(text(),'New Customer')]")
	public WebElement newCustomerMenuItem;
	
	
	@FindBy (xpath = "//*[contains(text(),'Customer Name')]//following::input[1]")
	private WebElement customerName;
	
	@FindBy (xpath = "(//input[@type='radio'])[1]")
	private WebElement selectGender;
	
	@FindBy (xpath = "//*[@id=\"dob\"]")
	private WebElement dateOfBirthSelect;
	
	@FindBy (xpath = "//textarea[@name='addr']")
	private WebElement address;
	
	@FindBy (xpath = "//input[@name='city']")
	private WebElement city;
	
	@FindBy (xpath = "//input[@name='state']")
	private WebElement state;
	
	@FindBy (xpath = "//input[@name='pinno']")
	private WebElement pin;
	
	@FindBy (xpath = "//input[@name='telephoneno']")
	private WebElement telephoneNumber;
	
	@FindBy (xpath = "//input[@name='emailid']")
	private WebElement email;
	
	@FindBy (xpath = "//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy (xpath = "//input[@type='reset']")
	private WebElement resetButton;
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	
	public NewCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void clickOnNewCustomerMenuItem()
	   {
		
		 newCustomerMenuItem.click();
	   }
	
	public void enterCustomerName(String NameOfCustomer)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(customerName));
		 customerName.sendKeys(NameOfCustomer);
	   }
	public void selectGender()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(selectGender));
		 selectGender.click();
	   }
	public void selectDateOfBirth(String DOB)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(dateOfBirthSelect));
		 dateOfBirthSelect.sendKeys(DOB);
	   }
	public void enterAddress(String addresName)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(address));
		 address.sendKeys(addresName);
	   }
	public void enterCity(String cityName)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(city));
		 city.sendKeys(cityName);
	   }
	public void enterState(String stateName)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(state));
		 state.sendKeys(stateName);
	   }
	public void enterpin(String pinNo)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(pin));
		 pin.sendKeys(pinNo);
	   }
	public void enterTelephonNumber(String phoneNo)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(telephoneNumber));
		 telephoneNumber.sendKeys(phoneNo);
	   }
	public void enterEmail(String emailId)
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(email));
		 email.sendKeys(emailId);
	   }
	public void clickOnSubmitButton()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(submitButton));
		 submitButton.click();
	   }
	public void clickOnresetButton()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(resetButton));
		 resetButton.click();
	   }
}
