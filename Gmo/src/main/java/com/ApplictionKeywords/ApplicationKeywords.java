package com.ApplictionKeywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ApplicationKeywords extends Validations {

	public ApplicationKeywords() throws Exception {
		mainprop = new Properties();
		childProp = new Properties();
		p=new Properties();
			
		try 
		{
			fis = new FileInputStream(projectPath+"//src//test//resources//p.properties");
			p.load(fis);
			
			/* String e = mainprop.getProperty("env"); */
			
			
			/*
			 * fis = new
			 * FileInputStream(projectPath+"//src//test//resources//"+e+".properties");
			 * p.load(fis);
			 */
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	

}
