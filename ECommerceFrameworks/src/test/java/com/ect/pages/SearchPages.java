package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPages {
	
	public WebDriver driver;
	public SearchPages(WebDriver ldriver) {

		this.driver=ldriver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Home") WebElement homeTxt;
	@FindBy(name="frm_search") WebElement searchbar;
	@FindBy(id="frm_search") WebElement searchbtn;
	@FindBy(xpath="//h3[normalize-space()='Iphone Products']") WebElement productClk;
	@FindBy(xpath="(//button[normalize-space()='Add to cart'])[1]") WebElement addCart;
	@FindBy(xpath="//a[@class='btn menu-btn']") WebElement cartClk;
	@FindBy(xpath="(//a[normalize-space()='Checkout'])[1]") WebElement checkout;
	
	public void SearchProduct() {
		homeTxt.click();
		searchbar.sendKeys("iphone");
		searchbtn.click();
		productClk.click();
		addCart.click();
		cartClk.click();
		checkout.click();
		
	}

}
