package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchStrategy {

	public static WebDriver driver;

	@Test

	public void search() throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/flights/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("departureCalendar")).click();

		while (true) {
			String monthYearval = driver.findElement(By.xpath(
					"//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[2]/div/div[1]/div"))
					.getText();
			if (monthYearval.equals("May 2023")) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[1]/span[2]"))
						.click();
			}
		}
		driver.findElement(By.xpath("//*[@id=\"fare_20230518\"]")).click();

	}
}
