package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DoubleClickAlert 
{
	WebDriver driver;

	@Test
	public void doubleClickAction() 
	{
		driver.get("http://only-testing-blog.blogspot.com/2014/09/selectable.html");

		WebElement button=driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));

		Actions builder=new Actions(driver);

		builder.doubleClick(button).build().perform();

		Alert alert;
		try{
			alert=driver.switchTo().alert();

			alert.accept();
		}
		catch(NoAlertPresentException e)
		{
			fail("No Such Alert Present");
			e.printStackTrace();
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
