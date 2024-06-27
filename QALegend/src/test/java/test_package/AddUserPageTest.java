package test_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.AddUserPage;
import page_object.HomePage;
import page_object.LoginPage;
import page_object.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base{
	@Test
	public void verifyAddUser()
	{   
		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
	    String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
	    
		String firstname=RandomDataUtility.getFirstname();
	    String lastname=RandomDataUtility.getLastname();
	    String email=firstname+Constants.DOT+lastname+Constants.GMAIL;
	    String passworduser=firstname+Constants.AT+lastname;
	    String username_value=firstname+Constants.DOT+lastname;
	    
	    LoginPage login=new LoginPage(driver);
	    login.enterUsername(login_username);
	    login.enterPassword(login_password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    home.clickOnUserManagement();
	    UsersPage users= home.clickOnUsersOption();
	    AddUserPage add_user=users.clickOnAddUser();
	    add_user.enterFirstName(firstname);
	    add_user.enterLastName(lastname);
	    add_user.enterEmail(email);
	    add_user.selectFromDropDown();
	    add_user.enterUserName(username_value);
	    add_user.enterPassword(passworduser);
	    add_user.enterConfirmPassword(passworduser);
	    add_user.clickOnSaveButton();            
	    users.searchUserOnSearchField(username_value);
	   // String actual_usertext=users.getSearchUser();
	    //String expected_usertext=username_value;
	    //Assert.assertEquals(actual_usertext, expected_usertext, Messages.LOGIN_FAILED);
	    
	}
	    
	
	@Test
	public void verifyUserLoginWithNewlyAddedUser()
	{
		String login_username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
	    String login_password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
	    
		String firstname=RandomDataUtility.getFirstname();
	    String lastname=RandomDataUtility.getLastname();
	    String email=firstname+Constants.DOT+lastname+Constants.GMAIL;
	    String passworduser=firstname+Constants.AT+lastname;
	    String username_value=firstname+Constants.DOT+lastname;
	    
	    LoginPage login=new LoginPage(driver);
	    login.enterUsername(login_username);
	    login.enterPassword(login_password);
	    HomePage home=login.clickOnLoginButton();
	    home.clickOnEndTourButton();
	    home.clickOnUserManagement();
	    UsersPage users= home.clickOnUsersOption();
	    AddUserPage add_user=users.clickOnAddUser();
	    add_user.enterFirstName(firstname);
	    add_user.enterLastName(lastname);
	    add_user.enterEmail(email);
	    add_user.selectFromDropDown();
	    add_user.enterUserName(username_value);
	    add_user.enterPassword(passworduser);
	    add_user.enterConfirmPassword(passworduser);
	    add_user.clickOnSaveButton();  
	    add_user.waitForTextToBeInvisible();
	    home.clickOnUserLogOut();
	    home.clickOnSignOutButton();
	    login.enterUsername(username_value);
	    login.enterPassword(passworduser);
	    login.clickOnLoginButton();
	    String actual_message=home.getLoginText();
	    String expected_message=Constants.PROFILE_WELCOME+firstname+Constants.CHARACTER;
	    Assert.assertEquals(actual_message, expected_message, Messages.LOGIN_FAILED);
		
	}

}
