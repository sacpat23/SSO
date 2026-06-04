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

public class SortTest {

	@Test

	public void sortTest() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		List<WebElement> beforeList = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));
		System.out.println("Before " + beforeList.size());

		List<String> before = new ArrayList<>();

		for (WebElement r : beforeList) {
			before.add(r.getText());

		}
		Collections.sort(before);

		driver.findElement(By.xpath("//*[@id=\"main\"]/button")).click();

		List<WebElement> afterList = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));
		System.out.println(afterList.size());

		List<String> after = new ArrayList<>();
		for (WebElement ele : afterList) {
			after.add(ele.getText());

		}

		Assert.assertEquals(before, after);

	}

}
