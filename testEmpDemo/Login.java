package testEmpDemo;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends SetUp {

	@Test
	public void testLogin() throws InterruptedException{
		driver.get("http://localhost:9080/EmpDemo/");
		Thread.sleep(3000);
		WebElement header = driver.findElement(By.tagName("h1"));
		Assert.assertTrue("Login Page"+ " is expected for display", header.isDisplayed());
		testVisibleAndEnable("loginName","password");
		driver.findElement(By.name("loginName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.tagName("input"));
		Assert.assertTrue("login button is expected for display", login.isDisplayed());
		Assert.assertTrue("login button is enable", login.isEnabled());
		login.submit();
		WebElement errormsg = driver.findElement(By.tagName("font"));
	    Assert.assertTrue("Message is expected for display", errormsg.isDisplayed());
		System.out.println(errormsg);
	}
	private void testVisibleAndEnable(String... names){
		for(String name: names){
			WebElement Name = driver.findElement(By.name(name));
			Assert.assertTrue(name+ " is expected for display", Name.isDisplayed());
			Assert.assertTrue(name +" to enable", Name.isEnabled());
	
		}
	}
}
