package testEmpDemo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import test.Commons;

public class SetUp {

	WebDriver driver;
	
  @Before
  public void setup(){
	driver = Commons.getDriver();
  }
  @After
	public  void clean() {
		driver.close();
	}
  
}
