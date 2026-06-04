package com.parametersTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CricSort {

	@Test

	public void cricSort() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/38592/ind-vs-wi-1st-odi-west-indies-tour-of-india-2022");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"innings_1\"]/div[1]/div/div[1]"));
		for (int i = 0; i < ele.size(); i++) {
			String g = ele.get(i).getText();
			System.out.println(g);

		}
		List<String> s = new ArrayList<>();
		for (WebElement e : ele) {
			s.add(e.getText());
		}
		Collections.sort(s);

		System.out.println("***************");

		Iterator<String> it = s.iterator();
		while (it.hasNext())
		System.out.println(it.next());

	}

}
