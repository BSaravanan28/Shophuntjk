package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="inputEmail")
	private WebElement adminusernameloc;
	
	@FindBy(id="inputPassword")
	private WebElement adminpasswordloc;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement usernameloc;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordloc;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement adminloginbuttonloc;
	
	public WebElement getAdminUserNameLoc()
	{
		return adminusernameloc;	
	}
	public WebElement getAdminPasswordLoc()
	{
		return adminpasswordloc;	
	}
	
	public WebElement getUserNameLoc()
	{
		return usernameloc;	
	}
	public WebElement getPasswordLoc()
	{
		return passwordloc;	
	}
	public WebElement getLoginButtonLoc()
	{
		return adminloginbuttonloc;	
	}
	
	public void adminLogin(String adminusername,String adminpassword)
	{
		
		getAdminUserNameLoc().sendKeys(adminusername);
		getAdminPasswordLoc().sendKeys(adminpassword);
		getLoginButtonLoc().click();
	}
	
	public void userLogin(String adminusername,String adminpassword)
	{
		
		getUserNameLoc().sendKeys(adminusername);
		getPasswordLoc().sendKeys(adminpassword);
		getLoginButtonLoc().click();
	}
}
