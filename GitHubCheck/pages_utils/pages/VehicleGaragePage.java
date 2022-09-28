/**
 * 
 */
package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log;

/**
 * @author ragesh
 *
 */
public class VehicleGaragePage {

	public WebDriver driver;
	public WebDriverWait wait;
	public String className = this.getClass().getSimpleName();

	public String carBrand = "Hyundai";
	public String carType = "Car";
	public String carModel = "Elite i20";
	public String carVariant = "Asta 1.4 CRDi";

	public VehicleGaragePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(xpath = "//button[@id='vehicle-add-button-announce']")
	public WebElement addYourVehicleButton;

	@FindBy(id = "vehicle-select-chooser-native-support_type")
	public WebElement vehicleTypeSelector;

	@FindBy(id = "vehicle-select-chooser-native-brand")
	public WebElement vehicleBrand;

	@FindBy(id = "vehicle-select-chooser-native-model_name")
	public WebElement vehicleModel;

	@FindBy(id = "vehicle-select-chooser-native-model_number")
	public WebElement vehicleVariant;

	@FindBy(xpath = "//h4[@id='a-popover-header-1']")
	public static WebElement vehicleInfo;

	@FindBy(xpath = "//button[@id='vehicle-select-save-button-announce']")
	public  WebElement saveButton;

	@FindBy(xpath = "//h1[@id='primary-vehicle-title']")
	public WebElement primaryVehicleTitle;
	@FindBy(xpath = "//h1[@id='secondary-vehicle-title']")
	public WebElement secondaryVehicleTitle;

	@FindBy(xpath = "//button[@id='delete-vehicle-button-announce']")
	public WebElement removeVehicle;
	
	
	@FindBy(xpath = "//div[@id='delete-vehicle-modal-footer']//following::input[@aria-labelledby='delete-vehicle-confirm-button-announce']")
	public WebElement deleteConfirmationYes;
	
	@FindBy(xpath = "//h1[contains(text(),'Your Garage')]")
	public WebElement mainPageTitle;
	
	
	
	public void addFirstVehicle() {
		try {
		addYourVehicleButton.click();
		Log.info("Clicking on add your vehicle button",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while Clicking on add your vehicle button " +e,className);
		}
	}

	public void selectVehicleType() {
		try {
		selectValueFromDropDown(vehicleTypeSelector, carType);
		Log.info("Selecting vehicle type from the dropdown",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while Selecting vehicle type from the dropdown "+e,className);
		}
	}

	public void selectVehicleBrand() {
		selectValueFromDropDown(vehicleBrand, carBrand);
		Log.info("Selecting vehicle brand from the dropdown",className);
	}

	public void selectVehicleModel() {
		try {
		selectValueFromDropDown(vehicleModel, carModel);
		Log.info("Selecting vehicle model from the dropdown",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while Selecting vehicle model from the dropdown "+e,className);
		}
	}

	public void selectVehicleVariant() {
		try {
		selectValueFromDropDown(vehicleVariant, carVariant);
		Log.info("Selecting vehicle type from the dropdown",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while Selecting vehicle type from the dropdown "+e,className);
		}
	}

	public void saveNewVehicle() {
		try {
		saveButton.click();
		Log.info("Clicking on save button after selections in dropdown",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while Clicking on save button after selections in dropdown" +e,className);
		}
	}
	public void removeVehicle() throws InterruptedException {
		try {
		removeVehicle.click();
		Log.info("Clicking on remove vehicle menu option",className);
		
		deleteConfirmationYes.click();
		Log.info("Clicking on YES in remove confirmation popup window",className);}
		catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while trying to remove the vehicle "+e,className);
		}
	}
	
	public Boolean getMainPageTitle() {
		
		try {
			mainPageTitle.isDisplayed();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public Boolean getVehicleTitle() {
		String priTitle = primaryVehicleTitle.getText();
		String secTitle = secondaryVehicleTitle.getText();

		try {
			Assert.assertEquals(carBrand, secTitle);
			Assert.assertEquals(carModel, priTitle);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static void selectValueFromDropDown(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Error while selecting values from dropdown "+e, VehicleGaragePage.class.getName());
		}
		
	}

}
