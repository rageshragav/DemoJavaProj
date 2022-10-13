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
public class ElectronicsPage {
	public WebDriver driver;
	public WebDriverWait wait;
	public String className = this.getClass().getSimpleName();
	public ElectronicsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//span[contains(text(),'Display Type')]//following::li//span//span[text()='OLED']")
	private WebElement screenType;
	
	@FindBy(xpath = "//span[contains(text(),'Brands')]//following::li//span//span[text()='HP']")
	private WebElement brand;
	
	@FindBy(xpath = "//span[contains(text(),'Laptop Weight')]//following::li//span//span[text()='1.0 to 1.4 kg']")
	private WebElement laptopWeight;
	
	
	@FindBy(xpath = "//span[contains(text(),'CPU Type')]//following::li//span//span[text()='Intel Core i9']")
	private WebElement laptopCPUType;
	
	@FindBy(xpath = "//span[contains(text(),'RAM Size')]//following::li//span//span[text()='16 GB']")
	private WebElement laptopRAMType;
	
	@FindBy(xpath = "//h2//a")
	private WebElement selectLaptop;
	
	
	
	public void selectScreenType() {
		wait.until(ExpectedConditions.visibilityOf(screenType)).click();
	}

	public void selectLaptopBrand() {
		wait.until(ExpectedConditions.visibilityOf(brand)).click();
	}
	
	public void selectLaptopWeight() {
		wait.until(ExpectedConditions.visibilityOf(laptopWeight)).click();
	}
	
	public void selectLaptopCPU() {
		wait.until(ExpectedConditions.visibilityOf(laptopCPUType)).click();
	}
	
	public void selectLaptopRAM() {
		wait.until(ExpectedConditions.visibilityOf(laptopRAMType)).click();
	}
	
	public void selectLaptop() {
		wait.until(ExpectedConditions.visibilityOf(selectLaptop)).click();
	}
	
}
