package com.parametersTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableCount {

	@Test

	public void webTableCount() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		String startxpath = "//*[@id=\"myTable\"]/tbody";
		String endxpath = "/tr";

		int row = 0;
		for (int i = 1; i <= 9; i++) {
			String x = driver.findElement(By.xpath(startxpath + i + endxpath)).getText();
			row++;
			System.out.println(x);
		}
		

	}

}
