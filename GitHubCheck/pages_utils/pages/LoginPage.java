package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy (xpath = "//input[@name='uid']")
	private WebElement userId;
	
	@FindBy (xpath = "//input[@name='password']")
	private WebElement passward;
	
	@FindBy (xpath = "//input[@name='btnLogin']")
	private WebElement login;
	
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
   
   public void loginToDemoBank(String userName,String passWord) {
	   sendUserName(userName);
	   sendPassward(passWord);
	   login.click();
   }
}
