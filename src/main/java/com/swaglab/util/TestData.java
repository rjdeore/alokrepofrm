package com.swaglab.util;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	public static FileInputStream ips;
	public static XSSFWorkbook xwb;
	public static Object[] udata;
	public static ArrayList<Object[]> pdata;
	public static Object[][] logindata;
	public static Object[][] placeData;
	public static Object[][] invaliddata;
	public static Object[][] lockeddata;
	public static ArrayList<Object[]> unamed;
	
	
	public static ArrayList usernameData(){
		String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
		unamed= new ArrayList<Object[]>();
		
		try{
		ips = new FileInputStream(path);
		}
		catch(FileNotFoundException fnfe){
		}
		
		
		try{
			xwb = new XSSFWorkbook(ips);
		}
		catch(IOException ioe){
		}
		
		XSSFSheet shtuname=xwb.getSheet("usernames");
		
		int lstRow =shtuname.getLastRowNum();
		
		
		for(int i=0;i<=lstRow;i++){
//			udata[i]=shtuname.getRow(i).getCell(0).toString();
			String un = shtuname.getRow(i).getCell(0).toString();
			Object obr[] ={un};
			unamed.add(obr);
			
		}
		
		
		return unamed;
		
//		return udata;
		
	}
	
	
	
	public static  ArrayList passwordData(){
        String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
		pdata =new ArrayList<Object[]>();
		
		try{
		ips = new FileInputStream(path);
		}
		catch(FileNotFoundException fnfe){
		}
		
		
		try{
			xwb = new XSSFWorkbook(ips);
		}
		catch(IOException ioe){
		}
		
		XSSFSheet sht=xwb.getSheet("passwords");
		
		int lstRow =sht.getLastRowNum();
		
		for(int i=0;i<=lstRow;i++){
			String pw=sht.getRow(i).getCell(0).toString();
			Object pwa[]={pw};
			pdata.add(pwa);
		}
		
		
		return pdata;
	}
	
	
	
	public static Object[][] loginUsers(){
	        String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
	        
			try{
			ips = new FileInputStream(path);
			}
			catch(FileNotFoundException fnfe){
			}
			
			
			try{
				xwb = new XSSFWorkbook(ips);
			}
			catch(IOException ioe){
			}
			
			XSSFSheet sht=xwb.getSheet("loginusers");
			
			int lstRow =sht.getLastRowNum();
			int lstcel =sht.getRow(0).getLastCellNum();
			
			
			logindata=new Object[lstRow+1][lstcel];
			
			for(int i=0;i<=lstRow;i++){
				
				
				for(int j=0;j<lstcel;j++){
					
				logindata[i][j]=sht.getRow(i).getCell(j).toString();
				
				}
			}
			
			
			return logindata;
	}
	
	
	public static Object[][] placehold(){
        String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
        
		try{
		ips = new FileInputStream(path);
		}
		catch(FileNotFoundException fnfe){
		}
		
		
		try{
			xwb = new XSSFWorkbook(ips);
		}
		catch(IOException ioe){
		}
		
		XSSFSheet sht=xwb.getSheet("placehold");
		
		int lstRow =sht.getLastRowNum();
		int lstcel =sht.getRow(0).getLastCellNum();
		
		placeData=new Object[lstRow+1][lstcel];
		
		for(int i=0;i<=lstRow;i++){
			for(int j=0;j<lstcel;j++){
			placeData[i][j]=sht.getRow(i).getCell(j).toString();
			
			}
		}
		
		
		return placeData;
}
	
	
	public static Object[][] invalidcom(){
		
		String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
		
		
		try{
		ips = new FileInputStream(path);
		}
		catch(FileNotFoundException fnfe){
		}
		
		
		try{
			xwb = new XSSFWorkbook(ips);
		}
		catch(IOException ioe){
		}
		
		XSSFSheet sht=xwb.getSheet("invalidcombo");
		
		int lstRow =sht.getLastRowNum();
		int lstcel =sht.getRow(0).getLastCellNum();
		
		invaliddata = new Object[lstRow+1][lstcel];
		
		for(int i=0;i<=lstRow;i++){
			for(int j=0;j<lstcel;j++){
			invaliddata[i][j]=sht.getRow(i).getCell(j).toString();
			}
		}
		
		
		return invaliddata;
	}
	
	public static Object[][] lockedusr(){
		String path= "C:\\Users\\alok\\eclipse-workspace\\Alokpswaglab\\src\\main\\java\\com\\swaglab\\data\\testdatasaucedemo.xlsx";
		
		
		try{
		ips = new FileInputStream(path);
		}
		catch(FileNotFoundException fnfe){
		}
		
		
		try{
			xwb = new XSSFWorkbook(ips);
		}
		catch(IOException ioe){
		}
		
		XSSFSheet sht=xwb.getSheet("lockeduser");
		
		int lstRow =sht.getLastRowNum();
		int lstcel =sht.getRow(0).getLastCellNum();
		lockeddata=new Object[lstRow+1][lstcel];
		
		for(int i=0;i<=lstRow;i++){
			for(int j=0;j<lstcel;j++){
			lockeddata[i][j]=sht.getRow(i).getCell(j).toString();
			}
		}
		
		
		return lockeddata;
	}
	
	

}
