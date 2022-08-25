package com.shophunt.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.shophunt.pomrepository.Login;
import com.shophunt.pomrepository.Logout;
import com.shophunt.pomrepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	// *** Create an object for Utitily ***
	FileUtility fu=new FileUtility();
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	WebDriverUtility wu=new WebDriverUtility();
	
	@BeforeSuite (groups= {"smoke","Regression"})
	public void configBS()
	{
		System.out.println("Database Connected");
	}
	
	//@Parameters("browser")
	@BeforeClass (groups= {"smoke","Regression"})
	public void configBC() throws Throwable
	{
		
		String browser = fu.getPropertyKeyValue("Browser");
		System.out.println("Browser Launched");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		//Maximize the Browser 
		wu.waitForElementInDOM(driver);
		driver.manage().window().maximize();
		
	}
	
	/* @BeforeMethod
	public void configBM() throws Throwable
	{
		String url=fu.getPropertyKeyValue("uurl");
		String un = fu.getPropertyKeyValue("uusername");
		String pwd = fu.getPropertyKeyValue("upassword");
		
		driver.get(url);
		UserHomePage hp= new UserHomePage(driver);
		hp.ClickLoginBtn();
		Login l=new Login(driver);
		l.userLogin(un, pwd);
		System.out.println("Loggedin Successfully");
		
	}
	
	@AfterMethod
	public void configAM()
	{
		Logout lo=new Logout(driver);
		lo.userLogout();
		System.out.println("Logout Successfully");
		
	} */
	
	@AfterClass (groups= {"smoke","Regression"})
	public void configAC()
	{
		System.out.println("Closing the browser");
		driver.quit();
	}
	
	@AfterSuite (groups= {"smoke","Regression"})
	public void configAs()
	{
			
		System.out.println("Database Closed");
	}
	
	
	
	
}
