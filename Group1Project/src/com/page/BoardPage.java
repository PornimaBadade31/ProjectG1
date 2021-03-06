package com.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage {

	static WebDriver driver;
	@FindBy(xpath="//span[@class='d-in-flex']")
	private static WebElement  addboard;



	@FindBy(xpath="//button[@class='btn logo-green-bg']")
	private static WebElement  save;

	@FindBy(xpath="//div[@class='multiselect__tags']")
	private static List<WebElement> select_project;


	@FindBy(id="name")
	private static WebElement  name;


	@FindBy(xpath="//span[contains(text(), \"Demo\")]")
	private static WebElement  selectdemo;

	@FindBy(xpath="//span[contains(text(), \"Public\")]")
	private static WebElement  selectpublic;

	@FindBy(xpath="//li[@class='multiselect__element']")
	private static List<WebElement> selectlist;

	@FindBy(xpath="//div[@class='all-view-container']")
	private static WebElement  boardlist;

	public BoardPage(WebDriver driver2) {
		this.driver=driver2;

	}
	public void OpenURL(String url)
	{
		driver.manage().window().maximize();

		driver.get(url);
	}
	public void addboard()
	{

		try {
			addboard.click();
			select_project.get(0).click();
			Thread.sleep(2000);
			selectlist.get(0).click();
			Thread.sleep(2000);

			select_project.get(1).click();
			Thread.sleep(2000);
			selectlist.get(1).click();
			Thread.sleep(2000);

			name.click();
			name.sendKeys("Pornima Badade");
			Thread.sleep(2000);
			save.click();
			Thread.sleep(4000);
			if(boardlist.getText().equals("Pornima Badade"))
			{
				System.out.println("Successfully added board");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBoard()
	{

	}

}
