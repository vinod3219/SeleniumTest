package testEmpDemo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class TestAddEmployee extends SetUp {
	@Test
	public void addemp() throws InterruptedException{
	
		driver.get("http://localhost:9080/EmpDemo/");
		Thread.sleep(3000);
		
		driver.findElement(By.name("loginName")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		WebElement login = driver.findElement(By.tagName("input"));
		login.submit();
		WebElement element = driver.findElement(By.linkText("Employee"));

		Actions action = new Actions(driver);

        action.moveToElement(element);
        action.click().build().perform();
        
        driver.findElement(By.linkText("Add New Employee")).click();
        Thread.sleep(3000);
       
		addEmployeeDataForm();	
	
}
	private WebElement addEmployeeDataForm() throws InterruptedException{
	
		WebElement header = driver.findElement(By.tagName("h2"));
		Assert.assertTrue("Add Employee Data" + "is expected for display",header.isDisplayed());
		
		Map<String,String> map = new HashMap<>();
		map.put("empLoginLbl", "Employee login Name:");
		map.put("empPwdLbl", "Employee Password:");
		map.put("empFnameLbl", "Employee First Name:");
		map.put("empLnameLbl", "Employee Last Name:");
		map.put("desigLbl", "Designation:");
		map.put("genderLbl", "Gender:");
		map.put("dobLbl", "Date of Birth:");
		map.put("statusLbl", "Status:");
		map.put("deptLbl", "Department:");
		map.put("managerLbl", "Manager :");
		map.put("empSalLbl", "Employee Salary:");
		map.put("mnoLbl", "Mobile No:");
	//	map.put("statusLbl", "Marital Status:");
		assertLabels(map);
		WebElement MaleGender = driver.findElement(By.id("mRadio"));
		MaleGender.isDisplayed();
		MaleGender.isEnabled();
		MaleGender.isSelected();
		WebElement FemaleGender = driver.findElement(By.id("fRadio"));
		FemaleGender.isDisplayed();
		FemaleGender.isEnabled();
		dropdown("designation");
		dropdown("status");
		dropdown("department.id");
		dropdown("manager.id");
		
	/*	Select designation = new Select(driver.findElement(By.name("designation")));
		designation.selectByIndex(0);
		Select status = new Select(driver.findElement(By.name("status")));
		status.selectByIndex(0);
		Select department = new Select(driver.findElement(By.name("department.id")));
		department.selectByIndex(0);
		Select manager = new Select(driver.findElement(By.name("manager.id")));
		manager.selectByIndex(0); */
		testVisibleAndEnable("loginName","password","fName","lName","dateOfBirth","salary","mobileNo","maritalStatus");
		Thread.sleep(3000);
		WebElement presentaddress = driver.findElement(By.id("presentAddressLbl"));
		Assert.assertTrue("Present Address :"+"is expected for display",presentaddress.isDisplayed());
		map.put("addr1Lbl", "Address Line 1:");
		map.put("addr2Lbl", "Address Line 2:");
		map.put("cityLbl", "City:");
		map.put("stateLbl", "State:");
		map.put("countryLbl", "Country:");
		map.put("pinLbl", "Pin Code:");
		assertLabels(map);
		testVisibleAndEnable("addresses[0].addrLine1","addresses[0].addrLine2","addresses[0].city","addresses[0].state","addresses[0].country","addresses[0].pin");
		WebElement permanentaddress = driver.findElement(By.id("permanentAddressLbl"));
		Assert.assertTrue("Permanent Address" + "is expected for display",permanentaddress.isDisplayed());
		map.put("addr1Lbl", "Address Line 1:");
		map.put("addr2Lbl", "Address Line 2:");
		map.put("cityLbl", "City:");
		map.put("stateLbl", "State:");
		map.put("countryLbl", "Country:");
		map.put("pinLbl", "Pin Code:");
		assertLabels(map);
		testVisibleAndEnable("addresses[1].addrLine1","addresses[1].addrLine2","addresses[1].city","addresses[1].state","addresses[1].country","addresses[1].pin");
		driver.findElement(By.id("accept")).isDisplayed();
		WebElement submit = driver.findElement(By.tagName("input"));
		Assert.assertTrue("submit button is expected for display", submit.isDisplayed());
		Assert.assertTrue("submit button is enable", submit.isEnabled());
		return submit;
	}
	public void dropdown(String list){
		Select List = new Select(driver.findElement(By.name(list)));
		List.selectByIndex(0);
	}
	private void testVisibleAndEnable(String... names){
		for(String name: names){
			WebElement Name = driver.findElement(By.name(name));
			Assert.assertTrue(name+ " is expected for display", Name.isDisplayed());
			Assert.assertTrue(name +" to enable", Name.isEnabled());
		}
	}
}