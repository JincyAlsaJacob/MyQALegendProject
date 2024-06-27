package test_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UsersPage;
import utilities.ExcelUtility;

public class UsersPageTest extends Base{
	
	@Test
	public void verifySearchUser()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
	    String username_on_search=ExcelUtility.getStringData(0, 1, Constants.USERS_PAGE);
	    
	    LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    home.clickOnUserManagement();
	    UsersPage users= home.clickOnUsersOption();
	    users.searchUserOnSearchField(username_on_search);
	    String actual_usertext=users.getSearchUser();
	    String expected_usertext=username_on_search;
	    Assert.assertEquals(actual_usertext, expected_usertext, Messages.LOGIN_FAILED);
	  }
	

}
