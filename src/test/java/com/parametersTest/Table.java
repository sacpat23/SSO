package com.parametersTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Table {

	@Test
	public void table() {
		System.setProperty("webdriver.chrome.driver", "//Users//sachin//Documents//ChromeDriver//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);

//		List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/td[1]"));
//		System.out.println("Total number of rows " + row.size());
//		for (int i = 1; i < row.size(); i++) {
//			String v = row.get(i).getText();
//			System.out.println("Cell name " + v);
//
//		}
//		System.out.println("************************");
//
//		List<WebElement> col = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tbody/tr/th"));
//		System.out.println("Total number of column " + col.size());
//		for (int i = 0; i < col.size(); i++) {
//			String c = col.get(i).getText();
//			System.out.println("Column name " + c);
//
//		}

		System.out.println("************************");

		String startxpath = "//*[@id=\"myTable\"]/tbody/tr[";
		String endxpath = "]/td";

		for (int i = 2; i <= 8; i++) {
			String t = driver.findElement(By.xpath(startxpath + i + endxpath)).getText();
			System.out.println(t);
			if (t.equals("Island Trading")) {
				System.out.println("element found");

			} else {
				System.out.println("element not found");
			}
		}

	}

}
