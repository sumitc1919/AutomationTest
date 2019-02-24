package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class CheckBoxTestNG 
{
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testForCheckBox() throws InterruptedException 
	{
		driver.get("http://selenium-examples.nichethyself.com");
		
		driver.findElement(By.linkText("Customized tours")).click();
		
		WebElement englandCheck=driver.findElement(By.xpath("//label[contains(text(),'England')]/input[@type='checkbox']"));
		
		
		if(!englandCheck.isSelected())
			englandCheck.click();
		
		Thread.sleep(5000);
		
		if(englandCheck.isSelected())
			englandCheck.click();
		
		
	}

	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
