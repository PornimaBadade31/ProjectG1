package com.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.DataInput;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;

public class ManageralReportPage {
	static WebDriver driver;
	@FindBy(id="add_report")
	private static WebElement add_report_Btn;

	@FindBy(xpath="//input[@class='default'][@value='Select User(s)']")
	private static List<WebElement>  adduser;

	@FindBy(xpath="//input[@class='default'][@value='Select User(s)']")
	private static List<WebElement>  addproject;

	@FindBy(name="daterangepicker-time")
	private static WebElement dateinput;

	@FindBy(name="daterangepicker_start")
	private static WebElement dateinputstart;

	@FindBy(name="daterangepicker_end")
	private static WebElement dateinputend;

	@FindBy(id="report_title")
	private static WebElement reportTitle;


	@FindBy(id="report_type")
	private static WebElement reportType;

	@FindBy(id="report_sub_type_2")
	private static WebElement reportSubType;


	@FindBy(id="report_save")
	private static WebElement reportSave;


	@FindBy(xpath="//div[@class='tl-item float-right']  ")
	private static WebElement  reportlist;




	@FindBy(id="projects_chosen")
	private static WebElement chooseProject;

	@FindBy(xpath = "//button[@class='applyBtn btn btn-small btn-sm btn-success']")    
	private static WebElement applybtn;


	@FindBy(id="major_type_2")
	private static WebElement projectradiobtn;

	public ManageralReportPage(WebDriver driver2) {
		this.driver=driver2;

	}
	public void OpenURL(String url)
	{
		driver.manage().window().maximize();

		driver.get(url);
	}
	public void addUserReport()
	{
		add_report_Btn.click();
		try {
			String file1="./TestData/UserReportData.csv";
			CSVReader reader1;
			
			reader1 = new CSVReader(new FileReader(file1));
			List<String[]> r = reader1.readAll();
			Thread.sleep(2000);
			
			adduser.get(1).click();
			Thread.sleep(2000);

			adduser.get(1).sendKeys(r.get(1)[1].toString()+Keys.ENTER);
			Thread.sleep(2000);

			Thread.sleep(2000);

			dateinput.click();
			dateinputstart.clear();
			dateinputstart.sendKeys(r.get(1)[2].toString());
			dateinputend.clear();
			dateinputend.sendKeys(r.get(1)[3].toString());
			applybtn.click();

			reportTitle.click();
			reportTitle.sendKeys(r.get(1)[4].toString());

			Select s1=new Select(reportType);
			s1.selectByIndex(2);
			Thread.sleep(2000);

			Select s2=new Select(reportType);
			s1.selectByIndex(1);
			Thread.sleep(2000);

			reportSave.click();
			Thread.sleep(5000);
			System.out.println(reportlist.getText());
			if(reportlist.getText()!=null)
			{
				System.out.println("Report added successfully");
			}
			else
			{
				System.out.println("Report is not added in the list");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
