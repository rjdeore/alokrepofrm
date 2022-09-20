package com.swaglab.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementChk {
	
	public static boolean isClickable(WebElement wbe,WebDriver wbd ){
		try{
			
			WebDriverWait wbw = new WebDriverWait(wbd,3);
			
			wbw.until(ExpectedConditions.elementToBeClickable(wbe));
			
			return true;
		}
		catch(Exception e){
			return false;
			
		}
		
		
	}
	
	
	
	public static void ewait(long time){
		
		
		try{
			Thread.sleep(time);
		}
		catch(InterruptedException a){
			
		}
		
	}

}
