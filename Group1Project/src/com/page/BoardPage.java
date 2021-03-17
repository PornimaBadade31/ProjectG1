package com.page;

import java.util.List;

import org.openqa.selenium.Keys;
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

	@FindBy(xpath="//a[@title='Edit']")
	private static WebElement editBtn;
	

	@FindBy(xpath="//button[@class='btn logo-green-bg']")
	private static WebElement updatebtn;
	
	@FindBy(id="name")
	private static WebElement  name;

	@FindBy(xpath="//div[@class='board-card-body']")
	private static WebElement cardbodydiv;
	
	@FindBy(xpath="//input[@title='Board Name']")
	private static WebElement editName;

	
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	private static WebElement okbtn;

	@FindBy(xpath="//a[@title='Delete']")
	private static WebElement deletebtn;
	
	
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
	public void editBoard()
	{
		editBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editName.clear();
		editName.sendKeys("Pornima"+Keys.ENTER);
		updatebtn.click();
		if(cardbodydiv.getText().contains("Pornima"))
		{
			System.out.println("updated sucessfully");
		}
		else
		{
			System.out.println("Update unsuccessful");
		}
		
	}
	public void deleteBoard()
	{
		try {
			deletebtn.click();
			Thread.sleep(3000);
			okbtn.click();
			if(cardbodydiv.getText().contains("Pornima"))
			{
				System.out.println("delete unsuccessful");
			}
			else
			{
				System.out.println("delete successful");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
