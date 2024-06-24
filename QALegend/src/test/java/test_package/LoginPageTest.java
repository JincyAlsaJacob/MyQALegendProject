package test_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import dataproviders.DataProviders;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		String actual_loginmessage=home.getLoginText();           
		String expected_loginmessage=ExcelUtility.getStringData(2, 1, Constants.LOGINPAGE);
		Assert.assertEquals(actual_loginmessage, expected_loginmessage, Messages.LOGINFAILED);
	}
	

	/*@Test(dataProvider="InvalidUserCredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMessageWhileLoginWithInvalidCredentials(String username, String password)
	{
	    LoginPage login=new LoginPage(driver);
	    login.enterUsername(username);
	    login.enterPassword(password);
	    login.clickOnLoginButton();
	    String actual_errormessage=login.getErrorMessage();
	    String expected_errormessage=ExcelUtility.getStringData(3, 1, Constants.LOGINPAGE);
	    Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.LOGINSUCCESSFUL); 
	}
*/
	
}
