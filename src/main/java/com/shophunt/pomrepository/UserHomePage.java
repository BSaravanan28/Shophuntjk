package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {

	public UserHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	//*** Login Button***
	
	@FindBy(xpath="//i[@class='icon fa fa-sign-in']")
	private WebElement loginbtn;
	
	//*** MyCart Button***
	
	@FindBy(xpath="//i[@class='icon fa fa-shopping-cart']")
	private WebElement mycart;
	
	//*** Login Button***
	
	public WebElement getLoginBtn()
	{
		return loginbtn;	
	}
	
	//*** MyCart Button***
	
	public WebElement getMyCart()
	{
		return mycart;	
	}
	
	
	//=== Click on login Button===
	public void ClickLoginBtn()
	{
		getLoginBtn().click();
		
	}
	
	//===Click on My cart Button===
	public void ClickMyCart()
	{
		getMyCart().click();
		
	}
	
	
}








