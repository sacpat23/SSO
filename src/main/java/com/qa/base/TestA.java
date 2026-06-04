package com.qa.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestA {

	@Test

	public void carWale() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://44.200.202.5/live/inspiring-swanson?tab=Alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> e = driver.findElements(By.xpath("(//button[@type='button'])"));
		System.out.println(e.size());

		for (int i = 0; i < e.size(); i++) {
			System.out.println(e.get(i).getText());
			e.get(i).click();

		}

	}
}
