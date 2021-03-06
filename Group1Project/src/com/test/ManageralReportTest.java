package com.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.page.AttachmentsPage;
import com.page.ManageralReportPage;

public class ManageralReportTest {
	static WebDriver driver;
	static String configFilename="C:\\Users\\HP\\Documents\\persi eltp\\ProjectG1\\Group1Project\\log4j.properties";
	private static Logger logger = Logger.getLogger(AttachmentsTest.class.getName());

	@Parameters({ "Reportsurl" })
	@Test
	public void TC5(String Reportsurl) {
		getlogger();
		logger.info("Test case 5");
		ManageralReportPage p2=PageFactory.initElements(driver, ManageralReportPage.class);
		AttachmentsPage p3=PageFactory.initElements(driver, AttachmentsPage.class);

		try {
			p2.OpenURL(Reportsurl);
			p3.login();
			Thread.sleep(2000);
			logger.info("adding user report");
			p2.addUserReport();
			Thread.sleep(4000);
			logger.info("user report successfully added");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@BeforeClass
	public static void getlogger()
	{
		PropertyConfigurator.configure(configFilename);

	}
	@Parameters({ "driver_path" })
	@BeforeSuite
	public void beforeSuite(String driver_path) {
		System.setProperty("webdriver.chrome.driver", driver_path);
		driver = new ChromeDriver();


	}

	@AfterSuite
	public void afterSuite() {
		driver.close();
	}
}
