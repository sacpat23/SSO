package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBooking2 {

	@Test

	public void flightBooking() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.happyeasygo.com/flight/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("D_date")).click();

		while (true) {
			String calMonth = "June 2022";
			String date = "23";

			List<WebElement> month = driver.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
			String first = month.get(0).getText();
			System.out.println(first);
			String second = month.get(1).getText();
			System.out.println(second);

			if (calMonth.equalsIgnoreCase(first)) {
				List<WebElement> firstmonth = driver.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
				List<WebElement> firstDate = firstmonth.get(0)
						.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/span"));

				for (WebElement t : firstDate) {
//					String g = t.getText();
//					System.out.println(g);
					if (t.getText().equalsIgnoreCase(date)) {
						t.click();
						break;
					}
				}

			} else if (calMonth.equalsIgnoreCase(second)) {
				List<WebElement> secondmonth = driver.findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
				List<WebElement> secondDate = secondmonth.get(1).findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/span"));

				for (WebElement t1 : secondDate) {
					String g = t1.getText();
					System.out.println(g);
					if (t1.getText().equalsIgnoreCase(date)) {
						t1.click();
						break;
					}
				}

			} else {
				driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/i")).click();
			}

		}

	}
}