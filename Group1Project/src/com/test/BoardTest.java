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
import com.page.BoardPage;
import com.page.ManageralReportPage;

public class BoardTest {
	static WebDriver driver;
	static String configFilename="C:\\Users\\HP\\Documents\\persi eltp\\ProjectG1\\Group1Project\\log4j.properties";
	private static Logger logger = Logger.getLogger(BoardTest.class.getName());
	@Parameters({ "boardurl" })
	@Test
	public void f(String boardurl) {
		logger.info("Board Test case");
		try {
			BoardPage p2=PageFactory.initElements(driver, BoardPage.class);
			AttachmentsPage p3=PageFactory.initElements(driver, AttachmentsPage.class);
			p2.OpenURL(boardurl);
			p3.login();
			logger.info("opening boards list");
			p3.OpenURL(boardurl);
			logger.info("adding board");
			Thread.sleep(4000);
			p2.addboard();

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
