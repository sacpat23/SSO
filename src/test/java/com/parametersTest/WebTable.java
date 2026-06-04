package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTable {

	@Test

	public void webTable() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr"));
		System.out.println(row.size());
		for (WebElement r : row) {
			System.out.println(r.getText());
		}
		System.out.println("************");

		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr[2]/td"));
		System.out.println(col.size());
		for (WebElement c : col) {
			System.out.println(c.getText());
		}
	}

}
