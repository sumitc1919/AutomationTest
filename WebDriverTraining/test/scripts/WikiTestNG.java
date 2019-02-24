package scripts;

//BeforeClass
//BeforeMethod
//Test Google
//AfterMethod
//BeforeMethod
//Test Wiki
//AfterMethod
//AfterClass

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class WikiTestNG 
{
	/*If we dont want to close browser after every method execution and continue the browser
	 * with next Test then we can use @BeforeClass and @AfterClass*/
	
	/*The method will call by alphabetically*/
	
	
	WebDriver driver1;			//Declare as a class variable, which access by all method of class.
	
	
	@BeforeClass
	public void beforeClass()		//Execute only once before all test are execute.
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver1=new ChromeDriver();
	}
	
	@AfterClass
	public void afterClass() 		//Execute only once after all test are executed.
	{
		driver1.quit();
	}

	@BeforeMethod					//Execute before every test method.
	public void beforeMethod()			
	{
		
	}
	
	@AfterMethod					//Execute after every test method.
	public void afterMethod() 
	{
		
	}
	
	@Test
	public void wikitest() 
	{
		driver1.get("https://www.wikipedia.org");

		driver1.findElement(By.id("js-link-box-en")).click(); //Method Chaining

		driver1.findElement(By.id("searchInput")).sendKeys("Selenium"); //Find the web-page element by id. and pass the value to that element.

		driver1.findElement(By.id("searchButton")).click(); //Click on we-page search button.

		String expPageHeading="Selenium1";
		String actPageHeading=driver1.findElement(By.id("firstHeading")).getText(); //return actual web-page heading

		assertEquals(actPageHeading, expPageHeading,"Page Heading Test Case Pass");

		String expPageTitle="Selenium - Wikipedia";
		String actPageTitle=driver1.getTitle();		//return actual web-page title.

		assertEquals(actPageTitle, expPageTitle,"Page Title Test Case Pass");
	}
	
	@Test
	public void googletest()
	{
		driver1.get("http://www.google.co.in");
		driver1.findElement(By.name("q")).sendKeys("Selenium Job In Pune");
	}

}