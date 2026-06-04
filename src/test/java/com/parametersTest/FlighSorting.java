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

public class FlighSorting {

	WebDriver driver;

	@Test

	public void flightSorting() {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		driver = new ChromeDriver();
		driver.get(
				"https://www.travolook.in/?utm_campaign=SK_Generic_12March2021_Exact&utm_medium=cpc&utm_source=google&gclid=Cj0KCQiAjJOQBhCkARIsAEKMtO120tflU-dxSUuhA7F68lCvuVdiz3DG5hizjWZCG7w4uvKzuk2FyisaAqM2EALw_wcB");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"allcity-1\"]/div/ul/li/span/b"));
		System.out.println(ele.size());

		List<Integer> l = new ArrayList<Integer>();

		for (WebElement e : ele) {
			l.add(Integer.parseInt(e.getText().replace("₹", "")));

		}

		Iterator<Integer> iter = l.iterator();

		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");

		}
		System.out.println("before sorting");

		Collections.sort(l);

		System.out.println("After sorting");
		System.out.println(l);

	}

}
