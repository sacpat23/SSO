package com.parametersTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {

	@Test

	public void practice1() throws Exception {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> beforeFilterlist = driver
				.findElements(By.xpath("//*[@id=\"inventory_container\"]/div/div/div[2]/div[2]/div"));

		List<Double> beforeFilterPrice = new ArrayList<>();

		for (WebElement e : beforeFilterlist) {
			beforeFilterPrice.add(Double.valueOf(e.getText().replace("$", "")));
		}
		Collections.sort(beforeFilterPrice);

		Select s = new Select(driver.findElement(By.className("product_sort_container")));
		Thread.sleep(3000);
		s.selectByIndex(2);

		List<WebElement> afterFilterlist = driver
				.findElements(By.xpath("//*[@id=\"inventory_container\"]/div/div/div[2]/div[2]/div"));
		System.out.println(afterFilterlist);

		List<Double> afterFilterPrice = new ArrayList<>();

		for (WebElement e : afterFilterlist) {
			afterFilterPrice.add(Double.valueOf(e.getText().replace("$", "")));

		}

		Assert.assertEquals(beforeFilterPrice, afterFilterPrice);

	}

}
