package com.swaglab.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {
	
	@BeforeClass
	public void setupCartPage(){
		System.out.println("Cart page class");
		allProductPageObj = loginPageObj.loginWithValid("standard_user","secret_sauce");
		cartPageObj=allProductPageObj.navigatingToCartFromAllProdPage();
		
	}
	
	@Test
	public void verifyTitleOfPage(){
		
		String cartTitle=cartPageObj.checkTitle();
		Assert.assertEquals(cartTitle,"Swag Labs");
	}
	
	
	@AfterClass
	public void endCartPage(){
		System.out.println("Cartpage after class");
		
		cartPageObj.navigateToAllProductPage();
		allProductPageObj.logouofAllProductPage();
		
		
	}

}
