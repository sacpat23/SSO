package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlightBooking {

	@Test

	public void flightBooking() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.happyeasygo.com/flight/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("D_date")).click();

		for (int i = 0; i < 12; i++) {
			String monthToBeSelected = "June 2022";
			String dateToBeSelected = "12";

			List<WebElement> month = driver.findElements(
					By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
			String firstIndexForMonth = month.get(0).getText();
			System.out.println("First " + firstIndexForMonth);
			String secondIndexForMonth = month.get(1).getText();
			System.out.println("Second " + secondIndexForMonth);

			if (monthToBeSelected.equalsIgnoreCase(firstIndexForMonth)) {
				List<WebElement> firstMonthTable = driver.findElements(
						By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
				List<WebElement> firstDateTable = firstMonthTable.get(0).findElements(By.xpath(
						"//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[1]/div[2]/div[2]/div/span"));
				for (WebElement e : firstDateTable) {
					System.out.println("============================");
					System.out.println(e.getText());
					e.getText().equalsIgnoreCase(dateToBeSelected);
					e.click();
					break;
				}

			} else if (monthToBeSelected.equalsIgnoreCase(secondIndexForMonth)) {
				List<WebElement> secondMonthTable = driver.findElements(
						By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div[1]/span"));
				List<WebElement> secondDateTable = secondMonthTable.get(1).findElements(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[2]/div[2]/div[2]/div/span"));

				for (WebElement e1 : secondDateTable) {
					System.out.println("============================");
					System.out.println(e1.getText());
					e1.getText().equalsIgnoreCase(dateToBeSelected);
					e1.click();
					break;
				}
			} else {
				driver.findElement(
						By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div[2]/div[1]/i"))
						.click();
			}

		}
	}

}
