package com.swaglab.test;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.swaglab.util.TestData;
import com.swglab.page.LoginPage;

public class LoginPageTest extends BaseTest {
//	public static LoginPage loginPageObj;
//	public static AllProductPage allProductPageObj;
	
	
	
	@BeforeMethod(enabled = false)
	public void start(){
		initialisation();
		System.out.println("login method");
		loginPageObj= new LoginPage(swg);
//		loginPageObj= new LoginPage();
	}
	
	@DataProvider
	public Iterator<Object[]> dt1(){
		ArrayList<Object[]> unamedt1 = TestData.usernameData();
		Iterator<Object[]> itr = unamedt1.iterator();
		return itr;	
	}
	
	@DataProvider
	public Iterator<Object[]> datapsw(){
		ArrayList<Object[]> pdw = TestData.passwordData();
		Iterator<Object[]> itr=pdw.iterator();
		return itr;
	}
	
	@DataProvider
	public Object[][] invalData(){
		Object[][] iva = TestData.invalidcom();
		return iva;
	}
	
	@DataProvider
	public Object[][] validData(){
		Object[][] ob =TestData.loginUsers();
		return ob;
	}
	
	@DataProvider
	public Object[][] placehold(){
		Object[][] placed= TestData.placehold();
		return placed;
		}
	
	@DataProvider
	public Object[][] lockedus(){
		Object[][] lck =TestData.lockedusr();
		return lck;
		
	}
	
	@Test(dataProvider = "dt1",priority = 2)
	public void loginWithOnlyUsernameTest(String uname1){
		
		loginPageObj.loginWithUserOnly(uname1);
		String loginchk=swg.getCurrentUrl();
		Assert.assertNotEquals(loginchk,"https://www.saucedemo.com/inventory.html");
		
	}
	
	@Test(dataProvider = "datapsw",priority = 4)
	public void loginWithOnlyPswTest(String pswd){
		
		loginPageObj.loginWithPswOnly(pswd);
		String loginpwchk=swg.getCurrentUrl();
		
		Assert.assertNotEquals(loginpwchk,"https://www.saucedemo.com/inventory.html");
	}
	
	
	
	@Test(dataProvider = "validData", groups = "sanity",priority = 3)
	public void loginValidTest(String unmm,String pww){
		allProductPageObj=loginPageObj.loginWithValid(unmm,pww);
        String loginpwchk=swg.getCurrentUrl();
        
		
		Assert.assertEquals(loginpwchk,"https://www.saucedemo.com/inventory.html");
		
		allProductPageObj.logouofAllProductPage();
		
	}
	
	@Test(dataProvider = "invalData",priority = 7)
	public void loginWithInvalid(String unm,String pwsd){
		loginPageObj.loginWithInvalid(unm,pwsd);
		String loginpwchk=swg.getCurrentUrl();
		Assert.assertNotEquals(loginpwchk,"https://www.saucedemo.com/inventory.html");
	}
	
	@Test(dataProvider = "placehold",priority = -1, groups = "sanity")
	public void placeHolder(String unph,String psph){
		boolean placeHolderCheck=loginPageObj.placeholders(unph, psph);
		Assert.assertTrue(placeHolderCheck);
	}
	
	@Test()
	public void logoCheckTest(){
		boolean logoAv=loginPageObj.logoChk();
		Assert.assertTrue(logoAv);
	}
	
	@Test
	public void loginBtnTest(){
		boolean loginBtnAvl=loginPageObj.loginBtnEnb();
		Assert.assertTrue(loginBtnAvl);
	}
	
	@Test
	public void textFieldEnbTest(){
		boolean txtenb=loginPageObj.unamePwdEnb();
	    Assert.assertTrue(txtenb);
	}
	
	@Test
	public void passwordHiddenTest(){
		String pshdchk=loginPageObj.pswIsHdn();
		Assert.assertEquals(pshdchk,"password");
	}
	
	
	@Test(dataProvider = "lockedus",priority = 5)
	public void lockedUserErCheck(String unm1,String psw1){
		String erMsgChk=loginPageObj.LockUserErorChk(unm1,psw1);
		
		Assert.assertEquals(erMsgChk,"Epic sadface: Sorry, this user has been locked out.");
		
	}
	
	
	
	
	@AfterMethod(enabled = false)
	public void quit(){
		swg.quit();
	}
	
	

}
