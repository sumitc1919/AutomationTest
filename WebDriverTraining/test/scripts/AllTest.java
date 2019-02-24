package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AllTest 
{
	WebDriver driver1;
	
  @Test
  public void simpleTest()
  {
	  driver1.get("https://www.wikipedia.org");

		driver1.findElement(By.id("js-link-box-en")).click(); //Method Chaining

		driver1.findElement(By.id("searchInput")).sendKeys("Selenium"); //Find the web-page element by id. and pass the value to that element.

		driver1.findElement(By.id("searchButton")).click(); //Click on we-page search button.

		String expPageHeading="Selenium";
		String actPageHeading=driver1.findElement(By.id("firstHeading")).getText(); //return actual web-page heading

		assertEquals(actPageHeading, expPageHeading,"Page Heading Test Case Pass");

		String expPageTitle="Selenium - Wikipedia";
		String actPageTitle=driver1.getTitle();		//return actual web-page title.

		assertEquals(actPageTitle, expPageTitle,"Page Title Test Case Pass");

  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() 
  {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver1=new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
