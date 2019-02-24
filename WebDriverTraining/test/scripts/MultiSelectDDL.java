package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class MultiSelectDDL
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testForMultiSelectDDL() throws InterruptedException
	{
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		
		WebElement multSelect=driver.findElement(By.name("color"));
		
		Select color=new Select(multSelect);
		
		assertTrue(color.isMultiple()); //It return true if ddl is multiple.
		
		color.selectByIndex(1);
		Thread.sleep(3000);
		color.selectByValue("sl");
		Thread.sleep(3000);
		color.selectByVisibleText("Red");
		Thread.sleep(3000);
		
		
		assertEquals(color.getAllSelectedOptions().size(),3); //It will check the DDL size is equal to provided value 3
		
		color.deselectByValue("sl");
		
		Thread.sleep(3000);

		color.deselectAll();
		
	}



	@AfterMethod
	public void afterMethod()
	{
	}

}
