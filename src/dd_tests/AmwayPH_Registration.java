package dd_tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;















import dd_core.testCore;
import dd_util.TestUtil;


public class AmwayPH_Registration extends testCore {
	
	
	
	
	
	@BeforeTest
	public void isSkip(){
		if(! TestUtil.isExecutable("AmwayPH_Registration")){
			throw new SkipException("Skipping test as runmode set to No");
		}
	}
	@Test(dataProvider="getData")
	public static void Register(String MiddleName, String LastName, String Gender,
			String ValidId, String Signature, String Email, String AddressLine1, String AddressLine2,
			String AddressLine3, String ZipCode, String City, String CardholderName, String CreditCardNumber,
			String CVVnumber, String ExpMonth, String ExpYear, String IssuingBank, String Password, String ConfirmPassword)throws Throwable{
		try{
			
			driver.manage().deleteAllCookies();
			driver.get(config.getProperty("testsite"));
			Thread.sleep(2000);
			
			driver.findElement(By.linkText("Register")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("RadioButtonOne"))).click();
			
			driver.findElement(By.xpath(object.getProperty("RadioButtonTwo"))).click();
			
			driver.findElement(By.xpath(object.getProperty("RadioButtonThree"))).click();
			
			driver.findElement(By.xpath(object.getProperty("RadioButtonFour"))).click();
			
			driver.findElement(By.xpath(object.getProperty("ConfirmButton"))).click();
			MyStringRandomGen msr = new MyStringRandomGen();
					
			String FirstName=msr.generateRandomString();
			driver.findElement(By.xpath(object.getProperty("FirstName"))).sendKeys(FirstName);
			
			driver.findElement(By.xpath(object.getProperty("MiddleName"))).sendKeys(MiddleName);
			
			driver.findElement(By.xpath(object.getProperty("LastName"))).sendKeys(LastName);
			
			driver.findElement(By.xpath(object.getProperty("Gender"))).sendKeys(Gender);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("ValidId"))).click();
			Thread.sleep(2000);
			StringSelection ss = new StringSelection(ValidId);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Thread.sleep(2000);
			Robot robot=new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_V);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			driver.findElement(By.xpath(object.getProperty("Signature"))).click();
			Thread.sleep(2000);
			StringSelection ss1 = new StringSelection(Signature);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
			Thread.sleep(2000);
			Robot robot1=new Robot();
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
			robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
			robot.keyPress(java.awt.event.KeyEvent.VK_V);
			robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
			driver.findElement(By.xpath(object.getProperty("Email"))).sendKeys(FirstName+Email);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("EmailRadioButton"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("EmailRadioButton"))).click();
			
			driver.findElement(By.xpath(object.getProperty("AddressLine1"))).sendKeys(AddressLine1);
			
			driver.findElement(By.xpath(object.getProperty("AddressLine2"))).sendKeys(AddressLine2);
			
			driver.findElement(By.xpath(object.getProperty("AddressLine3"))).sendKeys(AddressLine3);
			
			driver.findElement(By.xpath(object.getProperty("ZipCode"))).sendKeys(ZipCode);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("City"))).sendKeys(City);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("City"))).sendKeys(City);
			
			driver.findElement(By.xpath(object.getProperty("SubmitPage2Button"))).click();
			Thread.sleep(10000);
			
			Robot robot2 = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
			
			Set<String> winids = driver.getWindowHandles();
			Iterator<String> iterate = winids.iterator();
			System.out.println(iterate.next()); //main window id
			
			
			System.out.println("---------After the new tab is opened----");
			
			winids = driver.getWindowHandles();
			iterate = winids.iterator();
			String firstwindow=iterate.next();
		    String tabwindow=iterate.next();
		    
		    //main window
		    System.out.println(firstwindow);
		    
		    //tab window
		    System.out.println(tabwindow);
		    
		    //switch to tab window
		    driver.switchTo().window(tabwindow);
			 driver.navigate().to("https://www.mailinator.com/");
			
			driver.findElement(By.xpath(object.getProperty("MailinatorEmailId"))).sendKeys(FirstName);
			driver.findElement(By.xpath(object.getProperty("MailinatorG0"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("MailinatorEmail"))).click();
			Thread.sleep(2000);
			driver.switchTo().frame("publicshowmaildivcontent");
			System.out.println(driver.findElement(By.xpath(object.getProperty("MailinatorOTP"))).getText());
			
			
			String OTP=driver.findElement(By.xpath(object.getProperty("MailinatorOTP"))).getText();
			
			//driver.switchTo().defaultContent();
			driver.close();
			
			driver.switchTo().window(firstwindow);
			
			driver.findElement(By.xpath(object.getProperty("OTPinputBox"))).sendKeys(OTP);
			
			driver.findElement(By.xpath(object.getProperty("OTPvalidate"))).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(object.getProperty("TermsConditionCheckBox"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("PayNowButton"))).click();
			
			driver.findElement(By.xpath(object.getProperty("CardholderName"))).sendKeys(CardholderName);
			
			driver.findElement(By.xpath(object.getProperty("CreditCardNumber"))).sendKeys(CreditCardNumber);
			
			driver.findElement(By.xpath(object.getProperty("CVVnumber"))).sendKeys(CVVnumber);
			
			driver.findElement(By.xpath(object.getProperty("ExpMonth"))).sendKeys(ExpMonth);
			
			driver.findElement(By.xpath(object.getProperty("ExpYear"))).sendKeys(ExpYear);
			
			driver.findElement(By.xpath(object.getProperty("IssuingBank"))).sendKeys(IssuingBank);
			
			driver.findElement(By.xpath(object.getProperty("PaymentCheckBox"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("Proceed"))).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath(object.getProperty("ABOid"))).getText());
			
			String Expected_Message = driver.findElement(By.xpath(object.getProperty("ABOid"))).getText();
			String Expected_ABO = Expected_Message.substring(19);
			System.out.println(Expected_ABO);
			driver.findElement(By.xpath(object.getProperty("Password"))).sendKeys(Password);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("ConfirmPassword"))).sendKeys(ConfirmPassword);
			Thread.sleep(2000);
			driver.findElement(By.xpath(object.getProperty("SubmitpasswordButton"))).click();
			Thread.sleep(5000);
			
			System.out.println(driver.findElement(By.xpath(object.getProperty("SuccessfulRegistration"))).getText());
			String Actual_Message = driver.findElement(By.xpath(object.getProperty("SuccessfulRegistration"))).getText();
			
			Assert.assertEquals(Expected_ABO, Actual_Message);
			
//			System.out.println(strng);
//			Assert.assertEquals("Thank you for registering.", strng);

			
	//	selenium.click("//*[@id='header']/div[1]/div[2]/div[1]/a[1]");
		/*
		selenium.type(object.getProperty("username"), username);
		selenium.type(object.getProperty("password"), password);
		selenium.click(object.getProperty("signin_button"));
		*/
		//APPLICATION_LOGS.debug("User Successfully logged in:"+username);
		
		Thread.sleep(5000);
		
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
		
	
	@DataProvider
	public Object [][] getData(){
		//return test data from the sheetname provided
		return TestUtil.getData("AmwayPH_Registration");
	}
}
