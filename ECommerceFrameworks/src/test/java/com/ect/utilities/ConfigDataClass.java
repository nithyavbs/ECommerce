package com.ect.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataClass {

	Properties pro;
	public ConfigDataClass() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
}
