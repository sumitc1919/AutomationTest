package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WindowsSwitchExample 
{
	WebDriver driver;

	@Test
	public void switchWindowsHelp() 
	{
		driver.get("http://cookbook.seleniumacademy.com/Config.html");

		String mainWondowHandle=driver.getWindowHandle(); //It Will Point to Main Window of Site.

		driver.findElement(By.id("helpbutton")).click();

		try
		{
			driver.switchTo().window("HelpWindow");
			String title=driver.getTitle();
			System.out.println(title);
			assertEquals(title,"Help");
			driver.close();
		}
		catch(NoSuchWindowException e)
		{
			fail("No Such Window Found");
			e.printStackTrace();
		}

		driver.switchTo().window(mainWondowHandle);

		driver.findElement(By.id("chatbutton")).click();

		Set<String> allOpenWindowsByThisDriver=driver.getWindowHandles();

		for(String oneWindowHnadle:allOpenWindowsByThisDriver)
		{
			if(!mainWondowHandle.equals(oneWindowHnadle))
			{
				driver.switchTo().window(oneWindowHnadle);
				System.out.println(driver.getCurrentUrl());
				driver.findElement(By.id("closebutton")).click();
			}
			else
			{
				driver.switchTo().window(oneWindowHnadle);
				driver.findElement(By.xpath("//div[@class='demo']"));
				String title=driver.getTitle();
				System.out.println(title);
				assertEquals(title,"Build my Car - Configuration");
				//driver.close();
			}
			driver.switchTo().window(mainWondowHandle);
			driver.findElement(By.id("helpbutton")).click();
		}
	}



	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver=new ChromeDriver();
	}

	@AfterMethod
	public void afterMethod() 
	{
	}

}
