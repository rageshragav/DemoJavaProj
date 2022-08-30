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
	@FindBy (xpath = "//*[@id=\"message\"]")
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
	}
	public void enterCustomerName()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(customerName));
		 customerName.sendKeys("satish");
	   }
	public void selectGender()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(selectGender));
		 selectGender.click();
	   }
	public void selectDateOfBirth()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(dateOfBirthSelect));
		 dateOfBirthSelect.sendKeys("08101995");
	   }
	public void enterAddress()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(address));
		 address.sendKeys("satish");
	   }
	public void enterCity()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(city));
		 city.sendKeys("pune");
	   }
	public void enterState()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(state));
		 state.sendKeys("UP");
	   }
	public void enterpin()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(pin));
		 pin.sendKeys("451263");
	   }
	public void enterTelephonNumber()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(telephoneNumber));
		 telephoneNumber.sendKeys("071894452");
	   }
	public void enterEmail()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(email));
		 email.sendKeys("451263");
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
