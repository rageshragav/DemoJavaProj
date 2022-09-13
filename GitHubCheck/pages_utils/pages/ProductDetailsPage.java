/**
 * 
 */
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ragesh
 *
 */
public class ProductDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public ProductDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	@FindBy (xpath = "//span[@id='productTitle']")
	private WebElement searchProductTitle;
	
	@FindBy (xpath = "//input[@id='add-to-cart-button']")
	private WebElement addToCartButton;
	
	@FindBy (xpath = "//span[@class='a-button-inner']//following::span[text()='Proceed to checkout (1 item)']")
	private WebElement proceedToCheckout;
	
	public void addItemToCart() {
		
		wait.until(ExpectedConditions.visibilityOf(searchProductTitle));
		addToCartButton.click();
		
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
	}
}
