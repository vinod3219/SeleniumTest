package testEmpDemo;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.Commons;

public class SetUp {

	WebDriver driver;

	@Before
	public void setup() {
		driver = Commons.getDriver();
	}

	@After
	public void clean() {
		driver.close();
	}

	public void assertLabels(Map<String, String> labels) {
		for (Entry<String, String> label : labels.entrySet()) {
			String labelId = label.getKey();
			String labelValue = label.getValue();
			WebElement password = driver.findElement(By.id(labelId));
			Assert.assertTrue("Password" + " is expected for display", password.isDisplayed());
			Assert.assertEquals("invalid labelName for " + labelId, labelValue, password.getText());

		}
	}

}
