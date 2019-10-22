package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest()
	{
	 driver.get(baseurl);
	 logger.info("opened URL");
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.setUserName(username);
	 logger.info("entered username");
	 
	 lp.setPassword(password);
	 logger.info("entered password");
	 
	 lp.clickSubmit();
 

	if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	{
		Assert.assertTrue(true);
		logger.info("Login test passed");
	}
	else {    
		Assert.assertTrue(false);
		logger.info("Login test failed");
	}

}
	
}
