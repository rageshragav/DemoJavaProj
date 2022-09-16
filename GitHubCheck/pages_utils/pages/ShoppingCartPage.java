/**
 * 
 */
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ragesh
 *
 */
public class ShoppingCartPage {

	public WebDriver driver;
	public WebDriverWait wait;

	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]//following::li//span[text()='Apple iPhone 12 (64GB) - Blue']")
	private WebElement productInCart;

	public boolean isProductInCart() {

		try {

			wait.until(ExpectedConditions.visibilityOf(productInCart));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
}
