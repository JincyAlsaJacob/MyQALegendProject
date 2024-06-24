package test_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.My_ProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class My_ProfilePageTest extends Base{
	
	@Test
	public void verifyEditProfile()
	{
    	
    	String username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
		String new_lastname=RandomDataUtility.getLastname();

		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserLogOut();
		My_ProfilePage profile=home.clickOnProfileButton();
		profile.clearLastName();
		profile.enterNewLastName(new_lastname);
		profile.clickOnUpdateButton();
		String actual_editname=home.getUserProfileText();
		String expected_editname=Constants.PROFILE_NAME+new_lastname;
		Assert.assertEquals(actual_editname, expected_editname, Messages.FAILEDPROFILEUPDATION);
		
	}

}
