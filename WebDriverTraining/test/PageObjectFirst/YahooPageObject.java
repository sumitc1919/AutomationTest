package PageObjectFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooPageObject 
{
	private WebElement userEmail;
	private WebElement userPass;
	private WebElement nextButton;
	private WebElement buttonLogin;
	
	WebDriver driver;
	WebDriverWait wait;
	
	String url="https://login.yahoo.com/";
	
	public YahooPageObject()
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get(url);
		
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void logInTest(String email,String pass) throws InterruptedException
	{
		userEmail=driver.findElement(By.id("login-username"));
		userEmail.sendKeys(email);
		
		nextButton=driver.findElement(By.id("login-signin"));
		nextButton.click();
		
		//Thread.sleep(6000);
		//userPass=driver.findElement(By.id("login-passwd"));
		userPass = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login-passwd"))));
		userPass.sendKeys(pass);
		
		buttonLogin=driver.findElement(By.id("login-signin"));
		buttonLogin.click();
	}
	
	public void close()
	{
		driver.quit();
	}
	
	public String getNextPageTitle() 
	{
		return driver.getTitle();
	}

}
