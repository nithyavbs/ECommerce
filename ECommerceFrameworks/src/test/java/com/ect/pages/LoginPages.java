package com.ect.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	public WebDriver driver;
	public LoginPages(WebDriver ldriver) {

		this.driver=ldriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//a[@class='btn ml-3']") WebElement logimage;
	@FindBy(id="email") WebElement email;
	@FindBy(id="password")  WebElement pwd;
	@FindBy(id="customerloginForm") WebElement loginbtn;
	@FindBy(xpath="(//button[@id='dropdownMenuButton'])[2]") WebElement logoutimg;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement logout;

	public void portalLogin(String username,String password) {

		logimage.click();
		email.sendKeys(username);
		pwd.sendKeys(password);
		loginbtn.click();
	}
	
	public void logout() {
		logoutimg.click();
		logout.click();
		
	}
}
