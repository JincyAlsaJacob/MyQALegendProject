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

public class UsersPageTest extends Base {

	@Test
	public void verifySearchUser() {
		String username = ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password = ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
		String search_email = ExcelUtility.getStringData(1, 1, Constants.USERS_PAGE);

		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		UsersPage users = home.clickOnUsersOption();
		users.searchUserOnSearchFieldUsingEmail(search_email);
		String actual_usertext = users.getSearchUser();
		String expected_usertext = search_email;
		Assert.assertEquals(actual_usertext, expected_usertext, Messages.USER_LOGIN_FAILED);
	}

}
