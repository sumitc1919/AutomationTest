package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class AlertHandleTestNG 
{
	WebDriver driver;

	// @Test
	public void testAlertOnPage() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();

		Alert alert;
		try
		{
			alert=driver.switchTo().alert();
			String alertText=alert.getText();
			assertEquals(alertText,"I am a JS Alert","Message Match");
			Thread.sleep(3000);
			alert.accept(); 						//accept() click on Ok which present in alert box.

			String msgColor=driver.findElement(By.id("result")).getCssValue("color"); //rgba(0, 128, 0, 1) [#008002]
			assertEquals(msgColor,"rgba(0, 128, 0, 1)","Color Matched");

		}
		catch(NoAlertPresentException e)
		{
			fail("Alert should have been there. So failing the test.");
			e.printStackTrace();
		}
	}

//	@Test
	public void testAlertConfirm() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		
		Alert alert;
		try
		{
			alert=driver.switchTo().alert();
			String alertText=alert.getText();
			assertEquals(alertText,"I am a JS Confirm","Text Match");
			Thread.sleep(3000);
			alert.dismiss(); 		//dismiss() click on Cancel which present in alert box.
			
			String msg=driver.findElement(By.id("result")).getText();
			assertEquals(msg,"You clicked: Cancel","Message Match");
			
			String msgColor=driver.findElement(By.id("result")).getCssValue("color"); //rgba(0, 128, 0, 1) [#008002]
			assertEquals(msgColor,"rgba(0, 128, 0, 1)","Color Matched");
		}
		catch(NoAlertPresentException e)
		{
			fail("Alert should have been there. So failing the test.");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAlertPrompt() throws InterruptedException
	{
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		
		Alert alert;
		try
		{
			alert=driver.switchTo().alert();
			Thread.sleep(3000);
			//String alertMsg=alert.getText();
			alert.sendKeys("Sumit");
			Thread.sleep(3000);
			alert.accept();
			
		}
		catch(NoAlertPresentException e)
		{
			fail("Alert should have been there. So failing the test.");
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver","test//resources//chromedriver.exe");
		driver=new ChromeDriver();
	}


	@AfterMethod
	public void afterMethod()
	{

	}

}
