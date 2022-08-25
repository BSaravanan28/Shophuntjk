package com.shophunt.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {

	public Wishlist (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//i[@class='icon fa fa-sign-in']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//input[@class='search-field']")
	private WebElement searchfield;
	
	@FindBy(xpath="//button[@name='search']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::div[@class='product']/descendant::div[@class='product-image']")
	private WebElement productimg;
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	private WebElement addtowishlist;
	
	@FindBy(xpath="//a[text()='Apple iPhone 13 Pro Max (Sierra Blue-1TB)']/ancestor::tr/descendant::a[text()='Add to cart']")
	private WebElement addtocart;
	
	@FindBy(xpath="//i[@class='icon fa fa-shopping-cart']")
	private WebElement mycart;
	
	public WebElement getLoginBtn()
	{
		return loginbtn;	
	}
	
	public WebElement getSearchField()
	{
		return searchfield;	
	}
	
	public WebElement getSearchBtn()
	{
		return searchbtn;	
	}
	
	public WebElement getProductImg()
	{
		return productimg;	
	}
	
	public WebElement getAddToWishlist()
	{
		return addtowishlist;	
	}
	public WebElement getAddToCart()
	{
		return addtocart;	
	}
	public WebElement getMyCart()
	{
		return mycart;	
	}
	
	
	public void VerifyWishlist(String productname)
	{
		getSearchField().sendKeys(productname);
		getSearchBtn().click();
		getProductImg().click();
		getAddToWishlist().click();
		getAddToCart().click();
		getMyCart().click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
