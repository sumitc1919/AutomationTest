package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

//1.goto https://login.yahoo.com/
//2.type username click on next button
//3.type password click on login/signin button

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooTest 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  /*implicitly wait for every "findElement()",
		 																	while web page load and find the element.*/
		
		driver.get("https://login.yahoo.com/"); /*driver.get() care for 1st time full page load so all elements will present.
													so there is "NoSuchElementException" is not occur while this*/
		
		driver.findElement(By.id("login-username")).sendKeys("chandelsumit1919");
		
		driver.findElement(By.id("login-signin")).click();
		
		/*try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		*/
		driver.findElement(By.id("login-passwd")).sendKeys("9665171919");
		
		driver.findElement(By.id("login-signin")).click();
		
		driver.quit();
		

	}

}
