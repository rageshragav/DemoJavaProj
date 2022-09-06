package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement userId;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement passward;
	
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement login;
	
	@FindBy (xpath = "//a[contains(text(),'Log out')]")
	private WebElement logout;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		//this.driver = driver;
	}
    public void sendUserName(String userID)
   {
    	userId.sendKeys(userID);	
   }
   public void sendPassward(String pass)
   {
	  passward.sendKeys(pass);
   }
   public String getTextOfLoginButton()
   {
	 String  text = login.getText();
	 return text;
   }
   public void clickOnLogin()
   {
	  login.click();
   }
   public void clickOnLogout()
   {
	  logout.click();
   }
   
   public void loginToAmazon(String userName,String passWord) {
	   sendUserName(userName);
	   continueButton.click();
	   sendPassward(passWord);
	   login.click();
   }
}
