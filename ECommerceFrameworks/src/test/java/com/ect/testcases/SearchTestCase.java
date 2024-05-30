package com.ect.testcases;

import org.testng.annotations.Test;

import com.ect.pages.BaseClass;
import com.ect.pages.LoginPages;
import com.ect.pages.SearchPages;

public class SearchTestCase extends BaseClass {
	@Test
	public void searchProduct() {
		
		lp=new LoginPages(driver);
		lp.portalLogin(username, password);
		
		SearchPages sp=new SearchPages(driver);
		sp.SearchProduct();
		
	}

}
