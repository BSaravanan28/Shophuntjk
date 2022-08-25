package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateSubCategory {
	
	
	
	public CreateSubCategory(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


	@FindBy(xpath="//a[text()='Sub Category ']")
	private WebElement navcreatesubcategory;
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subcategoryname;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement subcategorybtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement scconmag;
	
	
	public WebElement getNavCreateSubCategory()
	{
		return navcreatesubcategory;	
	}
	
	public WebElement getCategoryDropDown()
	{
		return categorydropdown;	
	}
	
	public WebElement getSubCategoryName()
	{
		return subcategoryname;	
	}
	
	public WebElement getSubCategoryBtn()
	{
		return subcategorybtn;	
	}
	
	public WebElement getScConmsg()
	{
		return scconmag;	
	}
	
	
	public void createNewSubCategory(String categoryname,String subcategoryname)
	{
		getNavCreateSubCategory().click();
		Select s =new Select(categorydropdown);
		s.selectByVisibleText(categoryname);
		getSubCategoryName().sendKeys(subcategoryname);
		getSubCategoryBtn().click();
		String conmsg= scconmag.getText();
		System.out.println(conmsg);
		
	}
	
}







