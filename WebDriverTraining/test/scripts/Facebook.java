package scripts;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Map;

import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class Facebook 
{
	WebDriver driver;

	@BeforeClass
	public void beforeClass() 
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		//driver=new ChromeDriver();
	}

	@Test
	public void login() 
	{

		driver.get("https://en-gb.facebook.com/login/");
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS); 

		driver.findElement(By.id("email")).sendKeys("sanketchandale.sc@gmail.com");

		driver.findElement(By.id("pass")).sendKeys("maharana@@4422");

		driver.findElement(By.id("loginbutton")).click();
		
		
		
	//	driver.manage().
		
		driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
		try 
		{
			Thread.sleep(6000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		 
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		
		
		
		//driver.findElement(By.xpath("//span[contains(text(),’Log Out’)]")).click();
		//action="https://www.facebook.com/login/device-based/regular/logout/?button_name=logout&button_location=settings"
	}


	@AfterClass
	public void afterClass()
	{
		//driver.quit();
	}

}
