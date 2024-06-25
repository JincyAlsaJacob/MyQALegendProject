package test_package;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UserManagementPage;
import utilities.ExcelUtility;


public class UserManagementTest extends Base{
	@Test
	public void verifyUserManagementOptionsUsers()
	{

		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
	    String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
	    
	    LoginPage login=new LoginPage(driver);
	    login.enterUsername(login_username);
	    login.enterPassword(login_password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    UserManagementPage management=home.clickOnUserManagement();
	    boolean users_displayed=management.isUsersOptionDisplayed();
	    Assert.assertTrue(users_displayed, Constants.USEROPTIONNOTDISPLAYED);
	    
	}
	@Test
	public void verifyUserManagementOptionsRoles()
	{

		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
	    String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
	    
	    LoginPage login=new LoginPage(driver);
	    login.enterUsername(login_username);
	    login.enterPassword(login_password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    UserManagementPage management=home.clickOnUserManagement();
	    boolean roles_displayed=management.isRolesOptionDisplayed();
	    Assert.assertTrue(roles_displayed, Constants.ROLESOPTIONNOTDISPLAYED);
	    
	}

}
