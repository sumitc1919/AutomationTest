package scripts;

import org.openqa.selenium.By;

//1.Go to https://www.wikipedia.org
//2.Click on "English" link.
//3.Type "Selenium" in search box.
//4.Click on "Search" icon.
//5.Verify that "Selenium" appears on top of the page.
//6.Verify that page title is "Selenium - wikipedia"

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WikiTest 
{
	public static void main(String[] args)
	{
		/*Set the system property for firefox driver with convenient geckodriver path value,
		which can also run this test on different machine with use(not a full path) 
		with this path:-"test\\resources\\geckodriver64bit.exe".*/
		
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver64bit.exe"); 
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		//Firefox Driver
		//WebDriver driver1=new FirefoxDriver();
		//driver1.get("https://www.wikipedia.org");
		
		//Chrome Driver
		WebDriver driver1=new ChromeDriver();
		driver1.get("https://www.wikipedia.org");
		//driver cannot access methods which are defined only in ChromeDriver
		
		driver1.findElement(By.id("js-link-box-en")).click(); //Method Chaining
		//OR THROUGH THE "WebElement" CLASS.
		/*WebElement englishLink=driver1.findElement(By.id("js-link-box-en"));
		englishLink.click();*/
		
		driver1.findElement(By.id("searchInput")).sendKeys("Selenium"); //Find the web-page element by id. and pass the value to that element.
		
		driver1.findElement(By.id("searchButton")).click(); //Click on we-page search button.
		
		String expPageHeading="Selenium";
		String actPageHeading=driver1.findElement(By.id("firstHeading")).getText(); //return actual web-page heading
		
		if(expPageHeading.equals(actPageHeading))
			System.out.println("Page Heading Test Case Passed. ");
		else
			System.out.println("Page Heading Test Case Failed.");
		
		
		String expPageTitle="Selenium - Wikipedia";
		String actPageTitle=driver1.getTitle();		//return actual web-page title.
		
		if(expPageTitle.equals(actPageTitle))
			System.out.println("Page Title Test Case Passed.");
		else
			System.out.println("Page Title Test Case Failed.");
		
		driver1.quit();
	}

}
