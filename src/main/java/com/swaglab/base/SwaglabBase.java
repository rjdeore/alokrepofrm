package com.swaglab.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.swglab.page.AllProductPage;
import com.swglab.page.CartPage;
import com.swglab.page.LoginPage;

public class SwaglabBase {
	public static WebDriver swg;
	public static LoginPage loginPageObj;
	public static AllProductPage allProductPageObj;
	public static CartPage cartPageObj;
	
	
	
	
	public void initialisation(){
		System.setProperty("webdriver.chrome.driver","E:\\chromever\\chromedriver.exe");
		this.swg=new ChromeDriver();
		swg.manage().window().maximize();
		swg.manage().deleteAllCookies();
		swg.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		swg.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		swg.get("https://www.saucedemo.com/");
		
	}
	
	public SwaglabBase(){
		
	}
	
	

}
