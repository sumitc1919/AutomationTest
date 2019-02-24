package PageObjectThird;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;

public class YahooPageObjectLogInTest 
{
	YahooPageObject yobj;
	
  @Test
  public void loginTest() throws InterruptedException
  {
	  yobj.logInTest("chandelsumit1919","9665171919");
	  assertEquals(yobj.getNextPageTitle(),"Yahoo");
  }
  
  @BeforeClass
  public void beforeClass() 
  {
	  yobj=new YahooPageObject();
	  yobj.get();
	  yobj.load();
	  yobj.isLoaded();
  }

  @AfterClass
  public void afterClass() 
  {
	  //yobj.close();
  }

}
