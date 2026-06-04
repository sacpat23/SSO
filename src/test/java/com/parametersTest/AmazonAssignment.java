package com.parametersTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonAssignment {

	WebDriver driver;

	@Test

	public void amazonAssignment() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Links on amazon page are " + links.size());

		List<String> l = new ArrayList<>();

		for (WebElement e : links) {
			String t = e.getText();
			System.out.println(t);
			if (!t.isBlank()) {
				l.add(t);
			}
			Iterator<String> k = l.iterator();
			while (k.hasNext()) {
				System.out.println(k.next() + " ");

			}
		}
		System.out.println("After printing");
		new HashSet<String>(l);
		List<String> afterRemovingDuplcate = new ArrayList<>(new HashSet<String>(l));
		Collections.sort(afterRemovingDuplcate);

		for (int i = 0; i < afterRemovingDuplcate.size(); i++) {
			if (afterRemovingDuplcate.get(i).startsWith("C") || afterRemovingDuplcate.get(i).startsWith("D")) {
				System.out.println(afterRemovingDuplcate.get(i));
		}
		}

	}

}
