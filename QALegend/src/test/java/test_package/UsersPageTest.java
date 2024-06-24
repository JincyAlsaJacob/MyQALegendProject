package test_package;

import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UsersPage;
import utilities.ExcelUtility;

public class UsersPageTest extends Base{
	
	@Test
	public void verifySearchUser()
	{
		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGINPAGE);
	    String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGINPAGE);
	    String email_on_search=ExcelUtility.getStringData(0, 1, Constants.USERSPAGE);
	    
		LoginPage login=new LoginPage(driver);
	    login.enterUsername(login_username);
	    login.enterPassword(login_password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    home.clickOnUserManagement();
	    UsersPage users= home.clickOnUsersOption();
	    users.searchOnSearchFieldUsingEmail(email_on_search);
	   
	   
	    //String actual_mailid=
	   
	
	}
	

}
