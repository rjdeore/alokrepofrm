package com.swglab.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver swg;
	
	public CartPage(WebDriver swg2){
		this.swg=swg2;
		
		PageFactory.initElements(swg2,this);
		
	}
	
	@FindBy(xpath = "//button[@class='btn btn_secondary back btn_medium']")
	WebElement continueShopBtn;
	
	
	public void navigateToAllProductPage(){
		continueShopBtn.click();
	}
	
	public String checkTitle(){
       String titleOfSwaglabCart=swg.getTitle();
		
		return titleOfSwaglabCart;
	}
	

}
