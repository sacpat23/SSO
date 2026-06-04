package com.parametersTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sort2 {

	@Test
	public void sort2() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		List<WebElement> beforeFilterlist = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));

		List<String> beforeFilterPrice = new ArrayList<>();

		for (WebElement e : beforeFilterlist) {
			beforeFilterPrice.add(e.getText());
		}
		Collections.sort(beforeFilterPrice);

		driver.findElement(By.xpath("//*[@id=\"main\"]/button")).click();

		List<WebElement> afterFilterlist = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));
		System.out.println(afterFilterlist);

		List<String> afterFilterPrice = new ArrayList<>();

		for (WebElement e : afterFilterlist) {
			afterFilterPrice.add(e.getText());

		}

		Assert.assertEquals(beforeFilterPrice, afterFilterPrice);

	}

}
