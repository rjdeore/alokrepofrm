package com.swaglab.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.swaglab.base.SwaglabBase;

public class ScreenSht extends SwaglabBase{
	public static void ss(){
	
	ElementChk.ewait(100);
	TakesScreenshot obj1 = (TakesScreenshot) swg;
	long tm = System.currentTimeMillis();
	File source = obj1.getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\alok\\Desktop\\New folder\\sauce\\invld\\"+tm+".png");
	
	
	
	try {
		FileHandler.copy(source, dest);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
}
