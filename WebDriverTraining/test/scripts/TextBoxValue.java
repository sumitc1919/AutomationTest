package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TextBoxValue 
{
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void textBoxValuePrint()
	{
		driver.get("http://selenium-examples.nichethyself.com");
		
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		
		System.out.println("TextBox Value Is:-"+driver.findElement(By.id("loginname")).getAttribute("value"));
		//It will return a textbox value which enter by user in textbox.
	}

	@AfterMethod
	public void afterMethod() 
	{
	}

}
