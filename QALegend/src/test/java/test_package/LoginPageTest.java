package test_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation_core.Base;

public class LoginPageTest extends Base{
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		WebElement login_field=driver.findElement(By.id("username"));
		login_field.sendKeys();
		WebElement password_field=driver.findElement(By.id("password"));
		password_field.sendKeys();
		WebElement login_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
	//Assertion
	}
	
	@Test
	public void verifyErrorMessageWhileLoginWithInvalidCredentials()
	{
		WebElement login_field=driver.findElement(By.id("username"));
		login_field.sendKeys("abcd");
		WebElement password_field=driver.findElement(By.id("password"));
		password_field.sendKeys("123");
		WebElement login_button=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		login_button.click();
	
	}

}
