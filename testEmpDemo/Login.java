package testEmpDemo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Login extends SetUp {

	@Test
	public void testLoginFailure() throws InterruptedException{
		loginSubmit("admin","admin123");
		WebElement errormsg = driver.findElement(By.tagName("font"));
	    Assert.assertTrue("Message is expected for display", errormsg.isDisplayed());
	    Assert.assertEquals("Message is expected for display","Invalid Login",errormsg.getText());
	    checkForm();
	}
	
	@Test
	public void testLoginSucess() throws InterruptedException{
		loginSubmit("admin","admin");
		
		
	}

	private void loginSubmit(String uname,String pwd) throws InterruptedException {
		driver.get("http://localhost:9080/EmpDemo/");
		Thread.sleep(3000);
		WebElement login = checkForm();
		driver.findElement(By.name("loginName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pwd);
		login.submit();
	}

	private WebElement checkForm() throws InterruptedException {
		WebElement header = driver.findElement(By.tagName("h1"));
		Assert.assertTrue("Login Page" + " is expected for display", header.isDisplayed());
		
		Map<String,String> map = new HashMap<>();
		map.put("userNameLbl", "User Name:");
		map.put("passwordLbl", "Password:");
		assertLabels(map);
		
		testVisibleAndEnable("loginName","password");
		
		Thread.sleep(3000);
		WebElement login = driver.findElement(By.tagName("input"));
		Assert.assertTrue("login button is expected for display", login.isDisplayed());
		Assert.assertTrue("login button is enable", login.isEnabled());
		return login;
	}
	
	private void testVisibleAndEnable(String... names){
		for(String name: names){
			WebElement Name = driver.findElement(By.name(name));
			Assert.assertTrue(name+ " is expected for display", Name.isDisplayed());
			Assert.assertTrue(name +" to enable", Name.isEnabled());
		}
	}
}
