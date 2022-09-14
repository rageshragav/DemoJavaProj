package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewOrdersPage {

	@FindBy(xpath = "//*[@class='a-box-inner']//following::div/h2[contains(text(),'Your Orders')]")
	public WebElement orderBox;
	
	@FindBy(xpath = "(//span[contains(text(),'Orders')])[5]")
	public WebElement orders;
	
	@FindBy(xpath = "(//a[contains(text(),'Buy Again')])[2]")
	public WebElement buyAgain;
	
	@FindBy(xpath = "//a[contains(text(),'Not Yet Shipped')]")
	public WebElement notYetShipped;
	
	@FindBy(xpath = "//a[contains(text(),'Cancelled Orders')]")
	public WebElement cancelledOrders;
	
	private WebDriver driver;
	private  WebDriverWait wait ;
	private Actions actions;
	
	public ViewOrdersPage(WebDriver driver)
	 {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnOrderBox()
	   {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(orderBox));
		orderBox.click();
	   }
	public void clickOnorders() {

		orders.click();
	}
	public void clickOnbuyAgain() {

		buyAgain.click();
	}
	public void clickOnnotYetShipped() {

		notYetShipped.click();
	}
	public void clickOncancelledOrders() {

		cancelledOrders.click();
	}
}
