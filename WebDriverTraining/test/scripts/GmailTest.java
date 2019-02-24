package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailTest
{

	static WebDriver driver=new ChromeDriver();

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "test//resources//chromedriver.exe");

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		WebElement emailid= driver.findElement(By.id("identifierId"));
		waitForElement(emailid);
		emailid.sendKeys("chandelsumit1919");

		driver.findElement(By.id("identifierNext")).click();

		/*try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{

		(//span[@class='_54nh'])[6]

		//span[contains(text(),'Log Out')]
			e.printStackTrace();
		}*/

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("********");
		Thread.sleep(1000);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Compose')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(":pt")).sendKeys("vishal.chandale@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id(":pb")).sendKeys("Gmail Automation Email Assignment");
		Thread.sleep(1000);
		driver.findElement(By.id(":qg")).sendKeys("Hello Sir, This mail send by automation script author-Sumit.");
		Thread.sleep(1000);
		driver.findElement(By.id(":p1")).click();
	}


	public static void waitForElement(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));


	}


}