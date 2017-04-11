package dd_tests;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;







import dd_core.testCore;
import dd_util.TestUtil;


public class AmwayPH_login extends testCore {
	
	
	@BeforeTest
	public void isSkip(){
		if(! TestUtil.isExecutable("AmwayPH_login")){
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test(dataProvider="getData")
	public static void Login(String username, String Password)throws Throwable{
		try{
			
			driver.manage().deleteAllCookies();
			driver.get(config.getProperty("testsite"));
			
			driver.findElement(By.xpath(object.getProperty("username"))).sendKeys(username);
			driver.findElement(By.xpath(object.getProperty("Password"))).sendKeys(Password);
			driver.findElement(By.xpath(object.getProperty("SubmitButton"))).click();
			
			assertEquals("Homepage | Amway Philippines Site" , driver.getTitle());
	//	selenium.click("//*[@id='header']/div[1]/div[2]/div[1]/a[1]");
		/*
		selenium.type(object.getProperty("username"), username);
		selenium.type(object.getProperty("password"), password);
		selenium.click(object.getProperty("signin_button"));
		*/
		//app_logs.debug("User Successfully Registered");
		
		//Thread.sleep(5000);
		
        //driver.close();
		//Check Text Present
		
		//TestUtil.checkText("Password1", "Text not present");
		
		//Check Element Present from Xpath.properties file
		
	    //TestUtil.checkElement(XPATH_MAP.getProperty("username"), "Error");
		
	     
	     //APPLICATION_LOGS.debug(TestUtil.checkElement("//input[@id='username']", "Error"));
		}catch(Throwable t){
			TestUtil.captureScreenshot();
			throw(t); 
		}
	    
	}
		
	
	private static void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
	@DataProvider
	public Object [][] getData(){
		//return test data from the sheetname provided
		return TestUtil.getData("AmwayPH_login");
	}
}
