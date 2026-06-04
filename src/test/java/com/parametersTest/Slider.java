package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Slider {

	WebDriver driver;

	@Test
	public void slider() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://quantra.quantinsti.com/courses");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 350)");

		String j = driver.findElement(By.xpath("//*[@id=\"glide__id-70065004\"]/ul/li[5]/div/a/div[1]"))
				.getText();
		System.out.println(j);
		
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0, 350)");

		while (true) {

			List<WebElement> e = driver
					.findElements(By.xpath("//*[@id=\"glide__id-70065004\"]/ul/li/div/a/div[1]"));

			System.out.println(e.size());

			for (WebElement r : e) {
				if (r.getText().equals("Sentiment Analysis in Trading")) {
					r.click();
					break;
				} else {
					driver.findElement(By.xpath(
							"/html/body/div[4]/div[2]/div[1]/main/div/section[2]/div[1]/div/section/div/div[1]/div/div[2]/button[2]"))
							.click();
				}
			}

		}
	}
}
