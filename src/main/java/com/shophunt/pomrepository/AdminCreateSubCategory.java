package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.shophunt.genericutility.WebDriverUtility;

public class AdminCreateSubCategory {

	public AdminCreateSubCategory(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//***Select Category DropDown***
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	//*** SubCategory name ***
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subcategoryname;
	
	//*** SubCategory button***
	@FindBy(xpath="//button[@name='submit']")
	private WebElement subcategorybtn;
	
	//*** Conformation msg***
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement scconmag;
	
	//***Select Category DropDown***
	public WebElement getCategoryDropDown()
	{
		return categorydropdown;	
	}
	
	//*** Sub Category name ***
	public WebElement getSubCategoryName()
	{
		return subcategoryname;	
	}
	
	//*** SubCategory button***
	public WebElement getSubCategoryBtn()
	{
		return subcategorybtn;	
	}
	
	//*** Conformation msg***
	public WebElement getScConmsg()
	{
		return scconmag;	
	}
	
	
	//=== Create New Sub Category===
	public void createNewSubCategory(String categoryname,String subcategoryname)
	{
		WebDriverUtility wu = new WebDriverUtility();
		wu.select(categorydropdown, categoryname);
		getSubCategoryName().sendKeys(subcategoryname);
		getSubCategoryBtn().click();
//		String conmsg= scconmag.getText();
//		System.out.println(conmsg);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
