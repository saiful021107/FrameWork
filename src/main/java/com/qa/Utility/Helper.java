package com.qa.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String screenShotPath = System.getProperty("user.dir") + "/ScreenShots/Suce_" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenShotPath));
			System.out.println("Screenshot is being taken.");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return screenShotPath;
	}

	public static String getCurrentDateTime() {
		DateFormat customeFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customeFormat.format(currentDate);
	}

	public static void highlightElement(WebDriver driver, WebElement element, String color) {

		try {

			if (driver instanceof JavascriptExecutor) {
				((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);",
						element, "border: 5px solid " + color + ";");
				Thread.sleep(1000);
			}
		} catch (Exception var4) {
			var4.printStackTrace();
		}
	}

}
