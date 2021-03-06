package com.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.page.AttachmentsPage;

public class AttachmentsTest {
	static WebDriver driver;
	static String configFilename="C:\\Users\\HP\\Documents\\persi eltp\\ProjectG1\\Group1Project\\log4j.properties";
	private static Logger logger = Logger.getLogger(AttachmentsTest.class.getName());
	@Parameters({ "attachmeturl" ,"AutoIT"})
	@Test
	public void TC1(String attachmeturl, String AutoIT)
	{
		getlogger();
		logger.info("Test case 1");
		AttachmentsPage p1=PageFactory.initElements(driver, AttachmentsPage.class);

		p1.OpenURL(attachmeturl);
		String file1="./TestData/DocumentPath.csv";
		CSVReader reader1;
		try {
			p1.login();
			logger.info("Logging In");

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			logger.info("Reading document path from csv file");

			p1.upload(r.get(2)[0].toString(),r.get(2)[1].toString(),AutoIT);
			logger.info(".Docx file uploaded");

			Thread.sleep(2000);
			//p1.logout();

		} catch (IOException | AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters({ "attachmeturl" ,"AutoIT"})
	@Test
	public void TC2(String attachmeturl, String AutoIT)
	{
		logger.info("Test case 2");

		AttachmentsPage p2=PageFactory.initElements(driver, AttachmentsPage.class);

		p2.OpenURL(attachmeturl);
		String file1="./TestData/DocumentPath.csv";
		CSVReader reader1;

		try {
			logger.info("Read data from csv file");

			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			logger.info("uploading txt file");

			p2.upload(r.get(1)[0].toString(),r.get(1)[1].toString(),AutoIT);
			logger.info(".txt file uploaded");

			Thread.sleep(2000);

		} catch (IOException | AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters({ "attachmeturl" ,"AutoIT"})
	@Test
	public void TC3(String attachmeturl, String AutoIT)
	{
		logger.info("Test case 3");

		AttachmentsPage p3=PageFactory.initElements(driver, AttachmentsPage.class);

		p3.OpenURL(attachmeturl);
		String file1="./TestData/DocumentPath.csv";
		CSVReader reader1;

		try {
			logger.info("reading file path from csv file");

			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			logger.info("uploading file");

			p3.upload(r.get(3)[0].toString(),r.get(3)[1].toString(),AutoIT);
			logger.info(".ppt file uploaded");

			Thread.sleep(2000);

		} catch (IOException | AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters({ "attachmeturl" ,"AutoIT"})
	@Test
	public void TC4(String attachmeturl, String AutoIT)
	{
		logger.info("Test case 4");

		AttachmentsPage p4=PageFactory.initElements(driver, AttachmentsPage.class);

		p4.OpenURL(attachmeturl);
		String file1="./TestData/DocumentPath.csv";
		CSVReader reader1;

		try {
			logger.info("reading file path from csv file");

			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			logger.info("uploading file");

			p4.upload(r.get(4)[0].toString(),r.get(4)[1].toString(),AutoIT);
			logger.info(".png file uploaded ");

			Thread.sleep(2000);

		} catch (IOException | AWTException | InterruptedException e) {
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
