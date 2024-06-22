package test_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.LoginPage;
import page_object.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base{
	
	@Test
	public void verifyResetPassword()
	{
		String email_value=ExcelUtility.getStringData(1, 1, Constants.RESETPAGE);
		
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnForgotPassword();
		reset.enterEmail(email_value);
		reset.clickOnPasswordResetButton();
		String actual_message=reset.getConfirmationMessage();
		String expected_message=ExcelUtility.getStringData(0, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_message, expected_message, Messages.INVALIDMAILID);
	
	}
	
	@Test
	public void verifyErrorMessageWithInvalidEmailidOnForgotPassword()
	{
		String email_value=ExcelUtility.getStringData(3, 1, Constants.RESETPAGE);
		
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnForgotPassword();
		reset.enterEmail(email_value);
		reset.clickOnPasswordResetButton();
		String actual_errormessage=reset.getResetErrorMessage();
		String expected_errormessage=ExcelUtility.getStringData(2, 1, Constants.RESETPAGE);
		Assert.assertEquals(actual_errormessage, expected_errormessage, Messages.VALIDMAILID);
		
	}   
	

}
