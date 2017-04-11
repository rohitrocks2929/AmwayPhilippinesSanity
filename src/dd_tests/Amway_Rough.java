package dd_tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amway_Rough {

public static Properties config = new Properties();
	
	//3rd step
	public static Properties object = new Properties();
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.mailinator.com/");
		driver.findElement(By.xpath("//*[@id='inboxfield']")).sendKeys("uat130");
		driver.findElement(By.xpath("html/body/section[1]/div/div[3]/div[2]/div[2]/div[1]/span/button")).click();	

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='innermail ng-binding'][@style='height:100%;']")).click();
		Thread.sleep(5000);
		driver.switchTo().frame("publicshowmaildivcontent");
		//driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td"));
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/b")).getText());
		String OTP = driver.findElement(By.xpath("html/body/table[3]/tbody/tr[3]/td/b")).getText();
	}

}
