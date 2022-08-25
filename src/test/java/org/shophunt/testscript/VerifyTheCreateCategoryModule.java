package org.shophunt.testscript;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.shophunt.genericutility.BaseClass;
import com.shophunt.genericutility.ExcelUtility;
import com.shophunt.genericutility.FileUtility;
import com.shophunt.genericutility.WebDriverUtility;
import com.shophunt.pomrepository.AdminCreateCategory;
import com.shophunt.pomrepository.AdminHomePage;
import com.shophunt.pomrepository.Login;


public class VerifyTheCreateCategoryModule extends BaseClass {

	@Test (groups= {"smoke"})
	public void CreateCategory() throws Throwable	
	{
		
		// *** Create an object for Utitily ***
		FileUtility fu=new FileUtility();
		WebDriverUtility wu=new WebDriverUtility();	
		ExcelUtility eu=new ExcelUtility();

		// *** read common data from property file ***
		String url=fu.getPropertyKeyValue("aurl");
		String un = fu.getPropertyKeyValue("ausername");
		String pwd = fu.getPropertyKeyValue("apassword");
		String browser = fu.getPropertyKeyValue("Browser");
		String cname1 = fu.getPropertyKeyValue("cname1");
		String cname2 = fu.getPropertyKeyValue("cname2");
		String cname3 = fu.getPropertyKeyValue("cname3");
		
		// *** read data from excel file ***
		/*String cname1=eu.getExcelData("Category", 0, 1);
		String cname2=eu.getExcelData("Category", 0, 2);
		String cname3=eu.getExcelData("Category", 0, 3);*/
		
				
				// ***Login to application***
				wu.waitForElementInDOM(driver);
				driver.get(url);
				driver.manage().window().maximize();
				
				//***POM Login ***
				Login l=new Login(driver);
				l.adminLogin(un,pwd);
				
				//***Create new category using POM***
				
				AdminHomePage ah= new AdminHomePage(driver);
				ah.NavCreateCategory();
				
				
				AdminCreateCategory cc = new AdminCreateCategory(driver);
				cc.createNewCategoryTs(cname1,cname2,cname3);
				
				//***Verification*** 
				String actualresult = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//				if(msg.contains("Category Created"))
//				{
//					System.out.println(actualresult);
//				}
			String expectedresult="Well done! Category Created !!";
				
				//***Assertion***
				Assert.assertTrue(actualresult.contains(expectedresult));
				
				//Create new category
//				driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
//				WebElement cname=driver.findElement(By.xpath("//input[@name=\"category\"]"));
//				cname.sendKeys("cname1");
//				cname.clear();
//				cname.sendKeys("cname2");
//				cname.clear();
//				cname.sendKeys("cname3");
//				driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("     ");
//				driver.findElement(By.xpath("//button[text()='Create']")).click();
				
	}

}
