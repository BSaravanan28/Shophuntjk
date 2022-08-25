package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCreateCategory {

	public AdminCreateCategory (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//*** Category name ***
	@FindBy(xpath="//input[@name='category']")
	private WebElement categoryname;
	
	//*** Category Description***
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement categorydes;
	
	//*** Category button***
	@FindBy(xpath="//button[text()='Create']")
	private WebElement categorybtn;
	
	//*** Conformation msg***
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ccconmag;
	
	//*** Category name ***
	public WebElement getCategoryName()
	{
		return categoryname;	
	}
	
	//*** Category Description***
	public WebElement getCategoryDes()
	{
		return categorydes;	
	}
	
	//*** Category button***
	public WebElement getCategorybtn()
	{
		return categorybtn;	
	}
	
	//*** Conformation msg***
	public WebElement getConmag()
	{
		return ccconmag;	
	}
	
	//===Create New Category===
	public void createNewCategory(String categoryname,String categorydes)
	{
		
		getCategoryName().sendKeys(categoryname);
		getCategoryDes().sendKeys(categorydes);
		getCategorybtn().click();
		
	}
	
	//=== Create New Category According to Test Script===
	public void createNewCategoryTs(String categoryname1,String categoryname2, String categoryname3) throws InterruptedException 	{
		
		categoryname.sendKeys(categoryname1);
		Thread.sleep(20);
		categoryname.clear();
		Thread.sleep(20);
		categoryname.sendKeys(categoryname2);
		categoryname.clear();
		categoryname.sendKeys(categoryname3);
		categorydes.sendKeys("     ");
		categorybtn.click();
//		String msg= getConmag().getText();
//		System.out.println(msg);
	}
	
	
}
