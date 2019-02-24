package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class LogInTestNG 
{
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass()
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
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
