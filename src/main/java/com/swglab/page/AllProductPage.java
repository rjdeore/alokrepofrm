package com.swglab.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglab.util.ElementChk;

public class AllProductPage {
	WebDriver swg;
	
	
	public AllProductPage(WebDriver swg2){
		this.swg=swg2;
		
		PageFactory.initElements(swg2,this);
		
	}
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menuBtn;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	List<WebElement> productList;
	
	@FindBy(xpath = "//div[@class='inventory_item']//a//img")
	List<WebElement> productImg;
	
	@FindBy(xpath = "//div[@class='bm-menu']//nav//a")
	List<WebElement> menuItems;
	
	@FindBy(xpath = "//button[@id='react-burger-cross-btn']")
	WebElement menuClosingBtn;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartBtn;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filteringBtn;
	
	@FindBy(xpath ="//select[@class='product_sort_container']//option" )
	List<WebElement> filteringOptions;
	
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> productNameBtn;
	
	
	
	
	
	
	public String getTitleofPage(){
		String titled =swg.getTitle();
		return titled;
		
	}
	
	public void logouofAllProductPage(){
		menuBtn.click();
		logoutBtn.click();
	}
	
	public int numberOfProducts(){
		int noOfProduct = productList.size();
		return noOfProduct;
	}
	
	public boolean imgOfProduct(){
		
		boolean ImgAvl = true;
		
		outer : for(WebElement proImg :productList){
			String ImgTag = proImg.getTagName();
			
//			System.out.println("line 82 " +ImgTag);
			
			if(ImgTag.equals("div") == false){
				ImgAvl=false;
				break outer;	
			}			
		}
		
		return ImgAvl;
	}
	
	
	
	public boolean checkMenuOptn(){
		String[] menuOption = {"ALL ITEMS","ABOUT","LOGOUT","RESET APP STATE"};
		
		boolean allItmAvl=false;
		boolean textofItem=false;	
		int numOfItm=0;
		String singleMenuItm="";
		
		menuBtn.click();
		ElementChk.ewait(500);
		
		ArrayList<String> menuOptionLst =new ArrayList<>();
		
		for(String a : menuOption){
			menuOptionLst.add(a);
		}
		
		numOfItm = menuItems.size();
		
		if(numOfItm == 4){
//			System.out.println(numOfItm);
			
			allItmAvl=true;
			
		}
		
		
		
		
		
		for(WebElement menuItm:menuItems ){
					
			singleMenuItm=menuItm.getText();
//			System.out.println(singleMenuItm);
			
		
					
		if(menuOptionLst.contains(singleMenuItm) == false){
			
//			System.out.println(singleMenuItm);
			
			textofItem = false;
			break;
			
		    }
		else{
			textofItem = true;
		    }
				
		}
		
		
		System.out.println(textofItem +" " +allItmAvl);
		
		menuClosingBtn.click();
		
		return (textofItem && allItmAvl);
		
		
		
	}
	
	
	
	public boolean closingOfMenu(){
		
		menuBtn.click();
		
		Boolean btnDis=menuClosingBtn.isDisplayed();
		
		menuClosingBtn.click();
		
		System.out.println("check closing");
		
		ElementChk.ewait(1000);
		
		boolean btnNotDis = !(ElementChk.isClickable(menuClosingBtn, swg));
		
		ElementChk.ewait(2000);
		
		
		
		System.out.println(btnDis + " " +btnNotDis);
		
		return (btnDis && btnNotDis);	
		
	}
	
	public CartPage navigatingToCartFromAllProdPage(){
		cartBtn.click();
		
		String titleOfSwaglabCart=swg.getTitle();
		
		return new CartPage(swg);
			
	}
	
	
	
	public boolean filterOptionDilpayed(){
		
		boolean filterBtnswn= filteringBtn.isDisplayed();
		
		ElementChk.ewait(1000);
		
		boolean clickable=false;
		
		
		
		
		for(WebElement filtOp:filteringOptions)
		{
			clickable=ElementChk.isClickable(filtOp, swg);
			
		
			
			if(clickable=false){
				
				break;
			}
			
			else{
				clickable=true;
			}
		}
		
		
		
		
		
	
		
		return (clickable && filterBtnswn);
				
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	

}
