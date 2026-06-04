package com.parametersTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {
	@Test

	public void windowHandle() throws Exception {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.findElement(By.id("tabButton")).click();
		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();
		Iterator<String> t = s.iterator();
		String p = t.next();
		System.out.println(p);
		String c = t.next();
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		System.out.println(c);

//		while (t.hasNext()) {
//			String child = t.next();
//			if (!parent.equals(child)) {
//				driver.switchTo().window(child);
//				Thread.sleep(3000);
//				System.out.println(driver.findElement(By.id("sampleHeading")).getText());
//				Thread.sleep(3000);
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parent);
//		System.out.println(driver.getTitle());
	}

}
