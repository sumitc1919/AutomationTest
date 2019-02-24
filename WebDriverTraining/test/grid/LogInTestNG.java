package grid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class LogInTestNG 
{
	RemoteWebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		//driver=new ChromeDriver();
		
		DesiredCapabilities cap=new DesiredCapabilities();

		//cap.setBrowserName("firefox");
		cap.setBrowserName("chrome");
		
		try 
		{
			driver=new RemoteWebDriver(new URL("http://192.168.43.204:4444/wd/hub"),cap);
		} 
		catch (MalformedURLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void loginTest() 
	{
		driver.get("http://selenium-examples.nichethyself.com/");

		driver.findElement(By.id("loginname")).sendKeys("stc123");

		driver.findElement(By.id("loginpassword")).sendKeys("12345");

		driver.findElement(By.id("loginbutton")).click();
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
}
