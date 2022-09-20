package com.swaglab.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.swaglab.base.SwaglabBase;
import com.swglab.page.LoginPage;

public class BaseTest extends SwaglabBase{
	
	@BeforeSuite(groups = {"sanity"},enabled = true)
	public void bSuite(){
		System.out.println("bsuit");
		initialisation();
		loginPageObj= new LoginPage(swg);
//		allProductPageObj = loginPageObj.loginWithValid("standard_user","secret_sauce");
		
		
	}
	
	
	
	@AfterSuite(groups = {"sanity"},enabled = true)
    public void aSuite(){
		System.out.println("asuit");
		
		swg.quit();
		
	}
	
	
	
	
	

}
