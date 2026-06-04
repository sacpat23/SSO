package com.testngpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google {

	WebDriver driver;

	@BeforeSuite

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(invocationCount = 2)

	public void googleTest() {
		String titile = driver.getTitle();
		System.out.println(titile);
	

	}

	@Test(dependsOnMethods = "googleTest")

	public void searchText() {
		driver.findElement(By.name("q")).sendKeys("selenium");
	}

	@AfterSuite

	public void tearDown() {
		driver.quit();
	}

}
