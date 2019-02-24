package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class GoogleHomePageLinksTestNG 
{
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void testGoogleLinks() 
	{

		driver.get("https://www.google.com"); 	//Go to url
		
		driver.manage().window().maximize();

		List<WebElement> allGoogleLinks= driver.findElements(By.tagName("a")); 
		//All google links by tag name 'a' stored in List Array

		System.out.println("No. of Google HomePage Links"+ allGoogleLinks.size());

		for(int i=0;i<allGoogleLinks.size();i++)
		{
			System.out.println(allGoogleLinks.get(i).getText()+"-"+allGoogleLinks.get(i).getAttribute("href"));
		}

		//OR WE CAN USE FOR EACH LOOP

		/*for(WebElement oneLink:allGoogleLinks)
		{
			System.out.println(oneLink.getText()+"-"+oneLink.getAttribute("href"));
		}*/
	}


	@AfterMethod
	public void afterMethod() 
	{
		driver.quit();
	}

}
