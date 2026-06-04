package com.qa.base;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeBrowser {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://backlinko.com/hub/seo/duplicate-content");
		driver.manage().window().maximize();
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println(links.size());
//
//		Set s = new HashSet();
//
//		for (WebElement element : links) {
//
//			s.add(element);
//
//		}
//		System.out.println("After removing " + s.size());
		//List<WebElement> content = driver.findElements(By.tagName("a"));
		List<WebElement> content = driver.findElements(By.xpath("//*[contains(text(), 'Duplicate')]"));
		System.out.println("before " + content.size());

		Set set = new HashSet();

		set.addAll(content);
//		for (WebElement ele : content) {
//			set.add(ele);
//			
//		}
		System.out.println("after removing " + set.size());
	}

}
