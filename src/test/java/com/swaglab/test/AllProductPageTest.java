package com.swaglab.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.swglab.page.LoginPage;


public class AllProductPageTest extends BaseTest {
	
	
	@BeforeClass(groups = {"sanity"},enabled = true)
	public void setupForPage(){
		
		System.out.println("all product class");
		
		allProductPageObj = loginPageObj.loginWithValid("standard_user","secret_sauce");  
	}
	
	@BeforeMethod(enabled = false)
	public void startAllProductPage(){
		System.out.println("all product method");
		initialisation();
		loginPageObj= new LoginPage(swg);
		allProductPageObj = loginPageObj.loginWithValid("standard_user","secret_sauce");
	}
	
	
	
	@Test(groups = {"sanity"})
	public void verifyTitleofpage(){
		String title =allProductPageObj.getTitleofPage();
		Assert.assertEquals(title,"Swag Labs");
	}
	
	
	@Test
	public void verifynumberOfProducts(){
		int pronum=allProductPageObj.numberOfProducts();
		
		Assert.assertEquals(pronum,6);
	}
	
	@Test
	public void verifyimgOfProduct(){
		boolean imgAvl=allProductPageObj.imgOfProduct();
		
		Assert.assertTrue(imgAvl);
		
		
	}
	
	@Test(priority = -1)
	public void verifycheckMenuOptn(){
		boolean menuOpn=allProductPageObj.checkMenuOptn();
		
		Assert.assertTrue(menuOpn);
	}
	
	@Test
	public void verifyclosingOfMenu(){
		boolean menuClose=allProductPageObj.closingOfMenu();
		
		Assert.assertTrue(menuClose);
	}
	
	@Test(priority = 5)
	public void verifynavigatingToCartFromAllProdPage(){
		allProductPageObj.navigatingToCartFromAllProdPage();
		String navToCart=swg.getTitle();
		
		Assert.assertEquals(navToCart,"Swag Labs");
		cartPageObj.navigateToAllProductPage();
	}
	
	@Test
	public void verifyfilterOptionDilpayed(){
		boolean FiltOpAv=allProductPageObj.filterOptionDilpayed();
		
		Assert.assertTrue(FiltOpAv);
	}
	
	
	
	
	
	
	
	
	
	
	@AfterMethod(enabled = false)
	public void endAllProductPage(){
		swg.close();
		
	}
	
	@AfterClass(groups = {"sanity"},enabled = true)
	public void closingTest(){
		allProductPageObj.logouofAllProductPage();
//		swg.close();
		
	}

}
