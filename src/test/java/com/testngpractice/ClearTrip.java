package com.testngpractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClearTrip {

	WebDriver driver;

	@Test

	public void clearTrip() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get(
				"https://www.happyeasygo.com/flights/DEL-BOM/2022-02-18?tripType=0&adults=1&childs=0&baby=0&cabinClass=Economy&airline=&carrier=");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"searchForm\"]/div[2]/div[1]")).click();

//		String month = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/div/div/div/div/div/div/div/span"))
//				.getText();
//		System.out.println(month);

	
		while (true) {
			String o = "May 2022";
			try {
				driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div/div/div/div/div/div/div/div/span")).getText()
						.contains(o);
				// driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/table/tbody/tr/td/a")).click();
			} catch (Exception e) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a/span")).click();
			}
		}
	}
}