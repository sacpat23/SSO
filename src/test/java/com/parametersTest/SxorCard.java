package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SxorCard {

	@Test

	public void score() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/38592/ind-vs-wi-1st-odi-west-indies-tour-of-india-2022");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

		List<WebElement> e = driver.findElements(By.xpath("//*[@id=\"innings_1\"]/div[1]/div/div"));
		for (int i = 0; i < e.size(); i++) {
			String g = e.get(i).getText();
			System.out.println(g);

		}
		System.out.println("***************");
		String ele = "DM Bravo";

		String startxpath = "//*[@id=\"innings_1\"]/div[1]/div[";
		String endxpath = "]/div";

		for (int i = 3; i <= 13; i++) {
			String t = driver.findElement(By.xpath(startxpath + i + endxpath)).getText();
			System.out.println(t);

			if (t.contains(ele)) {
				System.out.println("player found");
				driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[" + i + "]/div[1]/a")).click();
				break;
				
			}
		}
	}

}
