package org.shophunt.testscript;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.shophunt.genericutility.BaseClass;
import com.shophunt.genericutility.ExcelUtility;
import com.shophunt.genericutility.FileUtility;
import com.shophunt.genericutility.WebDriverUtility;
import com.shophunt.pomrepository.AdminCreateCategory;
import com.shophunt.pomrepository.AdminCreateSubCategory;
import com.shophunt.pomrepository.AdminHomePage;
import com.shophunt.pomrepository.Login;
import com.shophunt.pomrepository.UserHomePage;
import com.shophunt.pomrepository.Wishlist;

public class ShophuntFinalScript extends BaseClass {
	
			// *** Create an object for Utitily ***
			FileUtility fu=new FileUtility();
			ExcelUtility eu=new ExcelUtility();
			WebDriverUtility wu=new WebDriverUtility();
			
			@Test(priority=1)
			public void CreateCategory() throws Throwable	
			{
				
				// *** Create an object for Utitily ***
				FileUtility fu=new FileUtility();
				ExcelUtility eu=new ExcelUtility();
				WebDriverUtility wu=new WebDriverUtility();	
				
				// *** read common data from property file ***
				String url=fu.getPropertyKeyValue("aurl");
				String un = fu.getPropertyKeyValue("ausername");
				String pwd = fu.getPropertyKeyValue("apassword");
				String browser = fu.getPropertyKeyValue("Browser");
				String cname1 = fu.getPropertyKeyValue("cname1");
				String cname2 = fu.getPropertyKeyValue("cname2");
				String cname3 = fu.getPropertyKeyValue("cname3");
				
				// *** read data from excel file ***
//				String cname1=eu.getExcelData("Category", 0, 1);
//				String cname2=eu.getExcelData("Category", 0, 2);
//				String cname3=eu.getExcelData("Category", 0, 3);
				
						
						// ***Login to application***
						wu.waitForElementInDOM(driver);
						driver.get(url);
						driver.manage().window().maximize();
						
						//***POM Login ******
						Login l=new Login(driver);
						l.adminLogin(un,pwd);
						
						//***Create new category using POM***
						
						AdminHomePage ah= new AdminHomePage(driver);
						ah.NavCreateCategory();
						
						AdminCreateCategory cc = new AdminCreateCategory(driver);
						cc.createNewCategoryTs(cname1, cname2, cname3);
						
						
			}
			
			@Test (priority=2)
			public void CreateSubcategory() throws Throwable	
			{
					
					// *** read common data from property file ***
					String url=fu.getPropertyKeyValue("aurl");
					String un = fu.getPropertyKeyValue("ausername");
					String pwd = fu.getPropertyKeyValue("apassword");
					String browser = fu.getPropertyKeyValue("Browser");
					String cname = fu.getPropertyKeyValue("cname");
					String csname = fu.getPropertyKeyValue("csname");
					
					// *** read data from excel file ***
//					String cname=eu.getExcelData("Subcategory", 0, 1);
//					String csname=eu.getExcelData("Subcategory", 0, 2);
					
						
					// ***Login to application***
					wu.waitForElementInDOM(driver);
					driver.get(url);
					driver.manage().window().maximize();
					
					//***POM***
					Login l=new Login(driver);
					l.adminLogin(un,pwd);
					
					//***Create new sub category using POM***
					
					AdminHomePage ah= new AdminHomePage(driver);
					ah.NavCreateSubCategory();
					
					AdminCreateSubCategory acs=new AdminCreateSubCategory(driver);
					acs.createNewSubCategory(cname, csname);				
					
		}
			
			@Test (priority=3)
			public void Wishlist() throws Throwable	
			{	
			
			// *** read common data from property file ***
			String url=fu.getPropertyKeyValue("uurl");
			String un = fu.getPropertyKeyValue("uusername");
			String pwd = fu.getPropertyKeyValue("upassword");
			String browser = fu.getPropertyKeyValue("Browser");
			String product = fu.getPropertyKeyValue("pname");
			
			// *** read data from excel file ***
			//String pname=eu.getExcelData("Category", 0, 4);

			
			// ***Login to application***
			
			wu.waitForElementInDOM(driver);
			driver.get(url);
			driver.manage().window().maximize();
			
			//***POM***	
			UserHomePage hp= new UserHomePage(driver);
			hp.ClickLoginBtn();
			
			
			//***POM***
			Login l=new Login(driver);
			l.userLogin(un, pwd);
			
			//***POM***
			Wishlist w= new Wishlist(driver);
			w.VerifyWishlist(product);

			TakesScreenshot ts =(TakesScreenshot)driver;
			//WebElement w = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 shopping-cart-table \"]"));
			File src=ts.getScreenshotAs(OutputType.FILE);
			File des=new File(".\\screenshot\\productaddedtoaddtocard1.jpg");
			FileUtils.copyFile(src,des);
				
		}


}
