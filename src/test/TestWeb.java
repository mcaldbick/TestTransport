package test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import model.User;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.events.KeyEvent;

import utils.ReadExcel;

public class TestWeb {

	@Test
	public static void testWeb(String IEDriver) throws InterruptedException {
		User transportUser = null;

		// Create a new instance of the IEDriver

		File file = new File(IEDriver);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("ignoreZoomSetting", true);
		caps.setCapability("nativeEvents", false);		
		WebDriver driver = new ChromeDriver(caps);
		driver.manage().window().maximize();

		// Get data from excel
		try {
			transportUser = ReadExcel.readData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fromLocation = transportUser.getFromLocation();
		String toLocation = transportUser.getToLocation();
		System.out.println(transportUser.getToLocation());
		// Launch the Online Store Website
		driver.get("https://transportnsw.info/");
		Thread.sleep(1000);
		// Print a Log In message to the screen
		System.out
				.println("Successfully opened the website https://transportnsw.info/");
		// WebElement locationFrom =
		// driver.findElement(By.name("search-input-From"));

		WebElement locationFrom = driver
				.findElement(By.id("search-input-From"));
		locationFrom.sendKeys(fromLocation);
		Thread.sleep(2000);
		locationFrom.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		Robot r1;
		try {
			r1 = new Robot();

			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
			// locationFrom.click();
			Thread.sleep(5000);

			WebElement locationTo = driver
					.findElement(By.id("search-input-To"));
			locationTo.sendKeys(toLocation);
			Thread.sleep(2000);
			locationTo.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(2000);

			r1.keyPress(KeyEvent.VK_ENTER);
			r1.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(1000);
		WebElement goButton = driver.findElement(By.id("search-button"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", goButton);
		
		// Wait for 5 Sec
		Thread.sleep(5000);

		// Close the driver
		driver.quit();
	}

}
