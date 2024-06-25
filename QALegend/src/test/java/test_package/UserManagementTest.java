package test_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.ExcelUtility;


public class UserManagementTest extends Base{
	@Test
	public void verifyUserManagementOptionsUsers()
	{

		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    UserManagementPage management=home.clickOnUserManagement();
	    boolean users_displayed=management.isUsersOptionEnabled();
	    Assert.assertTrue(users_displayed, Messages.USER_OPTION_NOT_ENABLED);
	    
	}
	@Test
	public void verifyUserManagementOptionsRoles()
	{

		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
	    
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    UserManagementPage management=home.clickOnUserManagement();
	    boolean roles_displayed=management.isRolesOptionEnabled();
	    Assert.assertTrue(roles_displayed, Messages.ROLES_OPTION_NOT_ENABLED);
	    
	}

}
