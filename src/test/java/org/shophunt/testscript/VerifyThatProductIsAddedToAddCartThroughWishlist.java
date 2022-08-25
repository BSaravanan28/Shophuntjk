package org.shophunt.testscript;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.shophunt.genericutility.BaseClass;
import com.shophunt.genericutility.ExcelUtility;
import com.shophunt.genericutility.FileUtility;
import com.shophunt.genericutility.JavaUtility;
import com.shophunt.genericutility.WebDriverUtility;
import com.shophunt.pomrepository.Login;
import com.shophunt.pomrepository.UserHomePage;
import com.shophunt.pomrepository.Wishlist;

public class VerifyThatProductIsAddedToAddCartThroughWishlist extends BaseClass {

	@Test (groups= {"smoke"})
	public void Wishlist() throws Throwable	
	{	
		
		
		// *** Create an object for Utitily ***
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();
		
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

	
		
		String actualresult=driver.findElement(By.xpath("//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::tbody/descendant::h4[@class='cart-product-description']")).getText();
		System.out.println(actualresult);
//		if(actualresult.contains("APPLE IPHONE 13 PRO MAX"))
//		{
//			System.out.println("Product is successfully added to addtocart through wishlist");
//		}
		
		//***Assertion***
		String expectedresult="APPLE IPHONE 13 PRO MAX";
		//Assert.assertEquals(actualresult,expectedresult);
		Assert.assertTrue(actualresult.contains(expectedresult));
		
				
					
//				driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("iphone");	
//				driver.findElement(By.xpath("//button[@name='search']")).click();
//				driver.findElement(By.xpath("//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::div[@class='product']/descendant::div[@class='product-image']")).click();				
//				driver.findElement(By.xpath("//i[@class='fa fa-heart']")).click();				
//				driver.findElement(By.xpath("//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::tr/descendant::a[text()='Add to cart']")).click();
//				driver.findElement(By.xpath("//i[@class='icon fa fa-shopping-cart']")).click();
//		TakesScreenshot ts =(TakesScreenshot)driver;
//		WebElement w = driver.findElement(By.xpath("//div[@class=\"col-md-12 col-sm-12 shopping-cart-table \"]"));
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File des=new File(".\\screenshot\\productaddedtoaddtocard1.jpg");
//		FileUtils.copyFile(src,des);
				
				
	}

}
