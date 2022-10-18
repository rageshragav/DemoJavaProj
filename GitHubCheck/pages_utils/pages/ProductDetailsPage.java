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

import utils.Log;

/**
 * @author ragesh
 *
 */
public class ProductDetailsPage {

	public WebDriver driver;
	public WebDriverWait wait;
	public String className = this.getClass().getSimpleName();

	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//span[@id='productTitle']")
	private WebElement searchProductTitle;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement addToCartButton;

	@FindBy(xpath = "//span[@class='a-button-inner']//following::span[text()='Proceed to checkout (1 item)']")
	private WebElement proceedToCheckout;

	public void addToCart() {

		wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();

	}

	public void addItemToCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(searchProductTitle));
			addToCartButton.click();
			Log.info("Adding the product to cart", className);

			wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
			driver.navigate().to("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
			Log.info("Navigating to cart", className);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while adding item to the cart " + e, className);
		}
	}
}
