package dd_core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.SendMailUsingAuthentication;





import dd_xlreader.Xls_Reader;

public class testCore {

/*
 * init methods will be responsible for Initilizing the Selenium server, Load properties, logs 
 * and other files
 * 
 */
	
	
	//1st step
	
	//2nd step
	public static Properties config = new Properties();
	
	//3rd step
	public static Properties object = new Properties();
	
	//4th step
	public static Xls_Reader excel = null; 
	
	//5th step
	public static Logger app_logs = Logger.getLogger("devpinoyLogger");
	
	//Selenium server
	//public static SeleniumServer server = null;
	public static WebDriver driver = null;

	//public static Object selenium;

	
	@BeforeSuite
	public static void init() throws IOException{
		
		
		//1st step
		if(driver == null){
			
			//Start Selenium server through Code
			//SeleniumServer server = new SeleniumServer();
			//server.boot();
			//server.start();
			
			
			//driver = new FirefoxDriver();
			
			//2nd step - Load config.properties
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//dd_properties//config.properties");
			config.load(fis);
			app_logs.debug("Loading config aagagagaga file");
			//3rd step - Load Object.properties
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//dd_properties//objects.properties");
			object.load(fis);
			
			
			//4th Step - load excel file
			excel = new Xls_Reader(System.getProperty("user.dir")+"//src//dd_properties//testData.xlsx");
			
			if(config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
			}else if(config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}else if(config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			//Implicit Wait
			driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
			
			driver.get(config.getProperty("testsite"));
			 driver.manage().window().maximize();
			
			
			
		}
		
		
		
		
		
		
	}
	
	@AfterSuite
	
	
//	use this method after finishing the test execution
	public static void QuitDriver(){
//		
//		//sending mail
//		System.out.println("Sending mail");
//		SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
//		mail.postMail(SendMailUsingAuthentication.emailList, SendMailUsingAuthentication.emailSubjectTxt, SendMailUsingAuthentication.emailMsgTxt, SendMailUsingAuthentication.emailFromAddress);
//		
//		
//	System.out.println("Stopping Selenium server");
		driver.close();
		//server.stop();
		
	}

}

