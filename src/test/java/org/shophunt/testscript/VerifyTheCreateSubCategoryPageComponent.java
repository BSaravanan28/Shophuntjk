package org.shophunt.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.shophunt.genericutility.BaseClass;
import com.shophunt.genericutility.ExcelUtility;
import com.shophunt.genericutility.FileUtility;
import com.shophunt.genericutility.JavaUtility;
import com.shophunt.genericutility.WebDriverUtility;
import com.shophunt.pomrepository.AdminCreateSubCategory;
import com.shophunt.pomrepository.AdminHomePage;
import com.shophunt.pomrepository.Login;

public class VerifyTheCreateSubCategoryPageComponent extends BaseClass {
	
		@Test (groups= {"smoke"})
		public void CreateSubcategory() throws Throwable	
		{
		
				// *** Create an object for Utitily ***
				FileUtility fu=new FileUtility();
				ExcelUtility eu=new ExcelUtility();
				JavaUtility ju=new JavaUtility();
				WebDriverUtility wu=new WebDriverUtility();
				
				// *** read common data from property file ***
				String url=fu.getPropertyKeyValue("aurl");
				String un = fu.getPropertyKeyValue("ausername");
				String pwd = fu.getPropertyKeyValue("apassword");
				String browser = fu.getPropertyKeyValue("Browser");
				String cname = fu.getPropertyKeyValue("cname");
				String csname = fu.getPropertyKeyValue("csname");
				
				// *** read data from excel file ***
//				String cname=eu.getExcelData("Subcategory", 0, 1);
//				String csname=eu.getExcelData("Subcategory", 0, 2);
				
					
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
				
				//***Verification***
				
				String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//				if(actualresult.contains("SubCategory Created"))
//				{
//					System.out.println(actualresult);
//				}
				
				//***Assertion***
				String expectedresult="Well done! SubCategory Created !!";
				
				//***Assertion***
				//Assert.assertEquals(actualresult,expectedresult);
				Assert.assertTrue(actualresult.contains(expectedresult));
				
				//Create new Sub category
//				driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
//				WebElement w = driver.findElement(By.xpath("//select[@name='category']"));
//				Select s =new Select(w);
//				s.selectByVisibleText("Furniture");
//				driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Wooden Chair");
//				driver.findElement(By.xpath("//button[@name='submit']")).click();
				//fetching the conformation messgae
//				String conmsg= driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//				System.out.println(conmsg);
				
				//***Create new sub category using POM***
//				CreateSubCategory cs= new CreateSubCategory(driver);
//				cs.createNewSubCategory(cname, csname);
				
				
				
	}

}
