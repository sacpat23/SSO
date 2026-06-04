package com.parametersTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonAssignment2 {

	WebDriver driver;

	@Test

	public void amazonAssignment() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//		driver.findElements(By.tagName("a")).stream().map(e -> e.getText()).distinct().sorted()
//				.filter(s -> s.startsWith("C") || s.startsWith("D")).forEach(System.out::println);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");
		
		WebElement element =driver.findElement(By.xpath("//*[@id=\"ecn9w2rdUw1x41TwSRe_EQ\"]/div[2]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		
		
		System.out.println("q");
		while (true) {
			
			if (driver.findElement(By.xpath(
					"//*[@id=\"ecn9w2rdUw1x41TwSRe_EQ\"]/div[2]/div/ul/li[16]/span/a/div[2]/div/span[1]/span[2]/span[2]/text()"))
					.equals("328")) {
				driver.findElement(By.xpath("//*[@id=\"ecn9w2rdUw1x41TwSRe_EQ\"]/div[2]/div/ul/li/span/a/div/div/img"))
						.click();
			}
			break;

		}

	}

}
