package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCategory {

	public CreateCategory (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[text()=' Create Category ']")
	private WebElement navcreatecategory;
	
	@FindBy(xpath="//input[@name='category']")
	private WebElement categoryname;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement categorydes;
	
	@FindBy(xpath="//button[text()='Create']")
	private WebElement categorybtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement ccconmag;
	
	
	public WebElement getNavCreateCategory()
	{
		return navcreatecategory;	
	}
	
	public WebElement getCategoryName()
	{
		return categoryname;	
	}
	
	public WebElement getCategoryDes()
	{
		return categorydes;	
	}
	
	public WebElement getCategorybtn()
	{
		return categorybtn;	
	}
	
	public WebElement getConmag()
	{
		return ccconmag;	
	}
	
	
	public void createNewCategory(String categoryname1,String categoryname2, String categoryname3)
	{
		
		getNavCreateCategory().click();
		getCategoryName().sendKeys(categoryname1);
		getCategoryName().clear();
		getCategoryName().sendKeys(categoryname2);
		getCategoryName().clear();
		getCategoryName().sendKeys(categoryname3);
		getCategoryDes().sendKeys(" ");
		getCategorybtn().click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}


