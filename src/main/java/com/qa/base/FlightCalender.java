package com.qa.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightCalender {

	@Test

	public void flightCalender() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://paytm.com/flights");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"datePickerOnward\"]/div/div/input")).click();

		for (int i = 0; i < 12; i++) {

			List<WebElement> monthHeaders = driver
					.findElements(By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div/p"));
			String firstIndex = monthHeaders.get(0).getText();
			System.out.println(firstIndex);
			String secondIndex = monthHeaders.get(1).getText();
			System.out.println(secondIndex);

			String month = "May '22";
			String date = "12";

			if (month.equalsIgnoreCase(firstIndex)) {
				List<WebElement> m = driver.findElements(By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div/p"));
				List<WebElement> d = m.get(0).findElements(
						By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div[3]/table/tbody/tr/td/div/div"));

				for (WebElement e : d) {
					String p = e.getText();
					if (e.getText().equalsIgnoreCase(date)) {
						e.click();
						break;
					}
				}

			} else if ((month.equalsIgnoreCase(secondIndex))) {
				List<WebElement> m1 = driver.findElements(By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div/p"));
				List<WebElement> d1 = m1.get(1).findElements(
						By.xpath("//*[@id=\"datePickerOnward\"]/div[2]/div/div[4]/table/tbody/tr/td/div/div/div"));

				for (WebElement e1 : d1) {
					String p1 = e1.getText();
					if (e1.getText().equalsIgnoreCase(date)) {
						e1.click();
						break;
					}
				}

			} else {
				driver.findElement(By.id("moveToNext")).click();
			}

		}
		List<WebElement> cards = driver.findElements(By.xpath(
				"//*[@id=\"app\"]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div[1]/ul/li/div/div/p/span"));
		for (WebElement f : cards) {
			String h = f.getText();
			System.out.println(h);
		}
		//driver.findElement(By.xpath("")).click();

	}

}
