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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author ragesh
 *
 */
public class ToysGamesPage {

	private WebDriver driver;
	private WebDriverWait wait;
	public String className = this.getClass().getSimpleName();

	public ToysGamesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}

	@FindBy(xpath = "//span[contains(text(),'Age')]//following::li//span//span[text()='3 - 4 years']")
	private WebElement ageGroup;
	
	@FindBy(xpath = "//span[contains(text(),'Delivery Day')]//following::li//span//span[text()='Get It by Tomorrow']")
	private WebElement deliveryDay;
	
	@FindBy(xpath = "//span[contains(text(),'Character')]//following::li//span//span[text()='Teddy']")
	private WebElement toyCharacter;
	
	@FindBy(xpath = "//div//span[text()='RESULTS']//following::div//h2//span[contains(text(),'Amazon Brand - Jam & Honey Pink Teddy 33 cm')]")
	private WebElement toyTeddy;
	
	
	
	public void filterAgeGroup() {
		wait.until(ExpectedConditions.visibilityOf(ageGroup)).click();
	}
	
	public void filterDeliveryDay() {
		wait.until(ExpectedConditions.visibilityOf(deliveryDay)).click();
	}

	public void filterTiyCharacter() {
		wait.until(ExpectedConditions.visibilityOf(toyCharacter)).click();
	}
	
	public void clickToyTeddy() {
		wait.until(ExpectedConditions.visibilityOf(toyTeddy)).click();
	}



}
