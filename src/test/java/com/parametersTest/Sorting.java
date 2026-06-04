package com.parametersTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sorting {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.travolook.in/?utm_campaign=SK_Generic_12March2021_Exact&utm_medium=cpc&utm_source=google&gclid=Cj0KCQiA9OiPBhCOARIsAI0y71BjNnmDhGfvT-t-2WRrnkBirNv70WUqYEkcxk6KNU4on3ygUCncEuIaAiFhEALw_wcB");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		List<WebElement> beforeSort = driver.findElements(By.xpath("//*[@id=\"allcity-1\"]/div/ul/li[2]/span/b"));
	
		List<String> ad = new ArrayList<String>();

		Arrays.asList(beforeSort);
		for (WebElement ele : beforeSort) {
			String data = ele.getText();
			//System.out.println(data);
			System.out.print(Arrays.asList(data));
		//	ad.add(data);

		}

//		List<String> temp = new ArrayList<String>();
//		temp.addAll(ad);
//		Collections.sort(temp, Collections.reverseOrder());
//		System.out.println("After sorting " + temp);
//		String t = temp.get(0);
//		System.out.println(t);
//		String tq = temp.get(2);
//		System.out.println(tq);
//
//		if (t != null) {
//			driver.findElement(By.xpath("//*[@id=\"allcity-1\"]/div[8]/ul/li[3]/button")).click();
//			System.out.println("clicked");
//		} else {
//			System.out.println("not clicked");
//
//		}

//		Assert.assertTrue(beforeSort.equals(temp));

	}

}
