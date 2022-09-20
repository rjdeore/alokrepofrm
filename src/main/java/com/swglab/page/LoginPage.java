package com.swglab.page;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.util.ElementChk;


public class LoginPage{
	
	WebDriver swg;
	
	public LoginPage(WebDriver swg1){
		this.swg= swg1;
		PageFactory.initElements(swg1,this);
	}
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement usernametx;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordtx;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='error-message-container error']")
	WebElement errorContainer;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement logo;
	
	
	public boolean unamePwdEnb(){
		boolean usernameEdit =usernametx.isEnabled();
		boolean passwordEdit=passwordtx.isEnabled();
		if(usernameEdit==true && passwordEdit ==true){
			return true;
			
		}
		else 
			return false;	
	}
	
	
	public boolean loginBtnEnb(){
		
		loginBtn.click();
		
		boolean loginBtnClick= loginBtn.isEnabled();
		
		return loginBtnClick;
	}
	
	public boolean logoChk(){
		boolean logoAvl=logo.isDisplayed();
		return logoAvl;
	}
	
	public boolean placeholders(String un,String pw){
		String usernamePlaceholder=usernametx.getAttribute("placeholder");
		String passwordPlaceholder=passwordtx.getAttribute("placeholder");
		
		if(usernamePlaceholder.equals(un) && passwordPlaceholder.equals(pw)){
			return true;
		}
		else
			return false;
	}
	
	public  AllProductPage loginWithUserOnly(String usernamed){
		passwordtx.clear();
		
		usernametx.sendKeys(usernamed);
		
		
		 
		loginBtn.click();
		usernametx.clear();
		return new AllProductPage(swg);
	}
	
	public  AllProductPage loginWithPswOnly(String psw){
	   
		passwordtx.sendKeys(psw);
		loginBtn.click();
		 passwordtx.clear();
		 
	
		return new AllProductPage(swg);
	}
	
	public  AllProductPage loginWithInvalid(String unm,String psw){
		
		usernametx.sendKeys(unm);
		passwordtx.sendKeys(psw);
		loginBtn.click();
		
		usernametx.clear();
		passwordtx.clear();
		
		
		
		
		return new AllProductPage(swg);
	}
	
	public  AllProductPage loginWithValid(String unm,String psw){
		
		usernametx.sendKeys(unm);
		passwordtx.clear();
		passwordtx.sendKeys(psw);
		loginBtn.click();
		String loginpwchk=swg.getCurrentUrl();
		
		return new AllProductPage(swg);
	}
	
	public String pswIsHdn(){
		String pswType=passwordtx.getAttribute("type");
		return pswType;
	}
	
	public String LockUserErorChk(String unm,String psw){
		
		swg.manage().deleteAllCookies();
		usernametx.clear();
		passwordtx.clear();
		
		ElementChk.ewait(500);
		
		
		
		
		usernametx.sendKeys(unm);
		
		passwordtx.clear();
		
		
		passwordtx.sendKeys(psw);
		
		
		
		
		loginBtn.click();
		
		String erMsg =errorContainer.getText();
		
		ElementChk.ewait(2000);

		
		
		usernametx.clear();
		passwordtx.clear();
		
	
		
		
		
		return erMsg;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
