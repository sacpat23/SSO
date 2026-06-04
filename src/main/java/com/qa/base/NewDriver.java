package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewDriver {

	static final String ZAP_PROXY_ADDRESS = "localhost";
	static final int ZAP_PROXY_PORT = 8080;
	static final String ZAP_API_KEY = "lt8q5piebl83vpp801ioljudrc";

	private WebDriver driver;
	private ClientApi api;

	@BeforeMethod

	public void SecurityTest() {

		String proxyServerUrl = ZAP_PROXY_ADDRESS + ":" + ZAP_PROXY_PORT;
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(proxyServerUrl);
		proxy.setSslProxy(proxyServerUrl);

		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		co.setProxy(proxy);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		api = new ClientApi(ZAP_PROXY_ADDRESS, ZAP_PROXY_PORT, ZAP_API_KEY);

	}

	@Test

	public void securityatest() throws Exception {
		driver.get("https://blog.quantinsti.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@class='btn btn-primary landing-sign-in'][contains(.,'Log In')]"))
//				.click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sachin.p+prosanity@quantinsti.com");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("sachintest");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//span[@class='default-slot'][contains(.,'Login')]")).click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/machine-learning-classification-strategy-python/']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='#a-brief-on-machine-learning']")).click();

	}

	@AfterMethod

	public void tearDown() {
		if (api != null) {
			String titile = "Blueshift ZAP security";
			String template = "traditional-html";
			String descripton = "Blueshift security";
			String reportfilename = "Blueshift-zap-report.html";
			String targetfolder = System.getProperty("user.dir");

			ApiResponse response;
			try {
				response = api.reports.generate(titile, template, null, descripton, null, null, null, null, null,
						reportfilename, null, targetfolder, null);
				System.out.println(response.toString());
			} catch (ClientApiException e) {

				e.printStackTrace();
			}

		}
		driver.quit();
	}
}