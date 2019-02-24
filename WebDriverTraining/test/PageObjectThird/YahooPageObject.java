package PageObjectThird;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class YahooPageObject extends LoadableComponent<YahooPageObject>
{
	//@FindBy (how=How.ID, using="login-username") private WebElement userEmail;
	@FindBy (id="login-username") private WebElement userEmail;
	
	@FindBy (id="login-passwd") private WebElement userPass;
	
	@FindBy(id="login-signin") private WebElement nextButton;
	
	@FindBy(id="login-signin") private WebElement buttonLogin;
	
	WebDriver driver;
	
	
	String url="https://login.yahoo.com/";
	String pageTitle = "Yahoo - login";
	
	public YahooPageObject()
	{
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		PageFactory.initElements(driver, this);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void logInTest(String email,String pass) throws InterruptedException
	{
		
		userEmail.sendKeys(email);
		
		nextButton.click();
		
		userPass.sendKeys(pass);
		
		buttonLogin.click();
	}
	
	public void close()
	{
		driver.quit();
	}

	@Override
	protected void isLoaded() throws Error 
	{
		assertEquals(driver.getTitle(),pageTitle);
	}

	@Override
	protected void load() 
	{
		driver.get(url);
	}
	
	public String getNextPageTitle() 
	{
		return driver.getTitle();
	}

}
