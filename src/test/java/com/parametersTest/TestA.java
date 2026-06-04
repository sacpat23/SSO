package com.parametersTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestA {

	@Test

	public void testA() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.travolook.in/?utm_campaign=SK_Generic_12March2021_Exact&utm_medium=cpc&utm_source=google&gclid=Cj0KCQiApL2QBhC8ARIsAGMm-KH5jB6DPANwSqKOIuKF-l6cCxkGEJGUKVy4qMnqTHk27k2Gq8b-8_saAuUfEALw_wcB");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"allcity-1\"]/div[4]/ul/li[2]/span/b"));
		System.out.println(list.size());

		List<WebElement> e = new ArrayList<>();

		for (WebElement f : list) {
			e.add(f);
		}

		Iterator<WebElement> iter = e.iterator();

		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");

		}
	}

}
