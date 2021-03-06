package com.page;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;


public class AttachmentsPage {
	static WebDriver driver;

	@FindBy(id="email")
	private static WebElement ele1;

	@FindBy(id="password")
	private static WebElement ele2;

	@FindBy(xpath="//button[@type='submit']")
	private static WebElement ele3;

	@FindBy(xpath = "//*[contains(text(), 'Attachments')]")    
	private static WebElement attachments;


	@FindBy(className="card-body")
	private static List<WebElement> demoproject;




	@FindBy(xpath="//*[contains(text(), 'Upload')]")
	private static List<WebElement> upload;



	public AttachmentsPage(WebDriver driver2) {
		this.driver=driver2;

	}
	public void OpenURL(String url)
	{
		driver.manage().window().maximize();
		driver.get(url);
	}
	public static void login() throws InterruptedException
	{
		String file1="./TestData/userCredentials.csv";
		CSVReader reader1;
		try {
			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			ele1.sendKeys(r.get(1)[0].toString());
			ele2.sendKeys(r.get(1)[1].toString());
			Thread.sleep(2000);
			ele3.click();
			Thread.sleep(2000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static void openattAchmentpage()
	{
		demoproject.get(1).click();
		attachments.click();

	}
	public static void upload(String path,String filename, String autoIT) throws AWTException, IOException, InterruptedException {


		Thread.sleep(2000);
		upload.get(1).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(autoIT+" "+path);
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.xpath("/html/body/div[1]/div/div[10]/div[1]/div[5]/div/div/div"));
		if(e.getText().contains(filename))
		{
			System.out.println("File uploaded successfully");
		}
		else
		{
			System.out.println("File did not get uploaded");
		}
	}

}
