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

public class CarWale {

	@Test

	public void carWale() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/new-cars/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@aria-label='View More Brands']")).click();

		Thread.sleep(2000);

		List<WebElement> e = driver
				.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/section[1]/div/div/div[1]/div/ul/li/a"));
		System.out.println(e.size());

		for (WebElement g : e) {
			String t = g.getText();
			System.out.println(t);

			if (t.equalsIgnoreCase("Hyundai")) {
				g.click();
				break;
			}

		}

		List<WebElement> carList = driver
				.findElements(By.xpath("//*[@id=\"root\"]/div[2]/div/div[3]/div[1]/ul/li/div/div/div/div[2]/span[1]"));
		System.out.println(carList.size());

		for (WebElement u : carList) {
			String o = u.getText();
			System.out.println(o);

		}

		List<String> l = new ArrayList<>();
		for (WebElement g : carList) {
			l.add(g.getText().replaceFirst("₹ ", ""));

		}

		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next() + " ");
		}
		System.out.println("======");
		Collections.sort(l);
		System.out.println(l);

		driver.findElements(By.tagName("a")).forEach(e1 -> System.out.println(e1.getText()));

		Map<String, String> s = new HashMap<>();
		s.put("one", "admin");
		s.put("two", "sales");
		s.put("three", "technology");
		s.put("one", "services");
		s.forEach((k,v)->{
			System.out.println("Key is "+ k);
		});
	}

}
