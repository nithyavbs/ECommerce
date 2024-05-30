package com.ect.testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ect.pages.BaseClass;
import com.ect.pages.LoginPages;
import com.ect.utilities.ReadExcelFile;

public class LoginTest extends BaseClass {

	String fileName=System.getProperty("user.dir") +  "\\TestData\\ETestData.xlsx";

	//String fileName=System.getProperty("D:\\d content\\eclipse-workspace\\ECommerceFrameworks\\TestData\\ETestData.xlsx");
	@Test(dataProvider="logindataProvider")

	public void verify(String user_name, String pass) throws IOException {
		LoginPages lp= new LoginPages(driver);
		lp.portalLogin(user_name,pass);

		if(user_name.equals("ravi@dhiyotech.in")&&pass.equals("Demo")) {
			
			Assert.assertTrue(true);
			lp.logout();
		}else {
			
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
			
		}
	}

	@DataProvider
	public Object[][] logindataProvider() {
		try {
			int row=ReadExcelFile.getRowCount(fileName,"Login" );
			int col=ReadExcelFile.getColCount(fileName,"Login" );
			// Log the row and column counts for debugging
			System.out.println("Row count: " + row);
			System.out.println("Column count: " + col);

			// Check if the row count is valid
			if (row <= 1) {
				System.out.println("No data available or only header row present");
				return new Object[0][0]; // Return an empty data set
			}
			String [] [] data = new String[row-1][col];

			for(int i=1;i<row;i++) {

				for(int j=0;j<col;j++) {

					data[i-1][j]=ReadExcelFile.getCellValue(fileName, "Login",i , j);
				}
			} return data;
		}catch (Exception e) {
			e.printStackTrace(); // Consider logging this to a file or logging framework
			return new Object[0][0]; // Return an empty data set in case of error
		}
	}
}
