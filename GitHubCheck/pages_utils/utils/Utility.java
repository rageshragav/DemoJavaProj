package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;

public class Utility {

	public static String mwh;

	public static String getDataFromExcel(String SheetName, String filePath)
			throws EncryptedDocumentException, IOException {
		// excel sheet code
		String data = "";
		String path = "./resources/demobank.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(SheetName);
		Row rows = sheet.getRow(1);
		Cell cells = rows.getCell(0);
		try {
			data = cells.getStringCellValue();
		} catch (InvalidElementStateException e) {
			double value = cells.getNumericCellValue();
			data = Double.toString(value);
		} catch (NullPointerException e) {
			System.out.println("cell is blank");
		}
		return data;

	}

	public static void getScreenshot(WebDriver driver, int testID) throws IOException {
		// Screenshot code

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH mm ss");
		Date date = new Date();
		String stamp = formatter.format(date);
		// File dest = new File("E:\\selenium\\New folder\\test-"+testID+stamp+".jpg");
		File dest = new File("\selenium\\\\New folder\\\\test-\"+testID+stamp+\".jpg");

		FileHandler.copy(src, dest);

	}

	public static Media captureScreenShot(WebDriver driver) {
		String ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return MediaEntityBuilder.createScreenCaptureFromBase64String(ss).build();

	}

	public static void javaScriptExecuterScrollDownPage(WebDriver driver, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}
	
	public static void javaScriptExecuterScrollDownInMenu(WebDriver driver, int pixel,String path) {
		WebElement element = driver.findElement(By.xpath(path));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");

	}

	
	public static void javaScriptExecuterClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}



	public static void switchToNewWindow(WebDriver driver) {
		mwh = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles(); // this method will gives you the handles of all opened windows

		Iterator<String> ite = s.iterator();

		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mwh)) {
				driver.switchTo().window(popupHandle);

				// driver.switchTo().window(mwh);
			}
		}
	}

}
