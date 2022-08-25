package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	public AdminHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//*** Nav to Create Category***
	@FindBy(xpath="//a[text()=' Create Category ']")
	private WebElement navcreatecategory;
	
	//*** Nav to Create Sub Category***
	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement navcreatesubcategory;
	
	//*** Nav to Create Category***
	public WebElement getNavCreateCategory()
	{
		return navcreatecategory;	
	}
	
	//*** Nav to Create Sub Category***
	public WebElement getNavCreateSubCategory()
	{
		return navcreatesubcategory;	
	}
	
	//===Click on Create Category===
	public void NavCreateCategory()
	{
		getNavCreateCategory().click();
		
	}
	
	//====Click on Create Sub Category===
	public void NavCreateSubCategory()
	{
		getNavCreateSubCategory().click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
