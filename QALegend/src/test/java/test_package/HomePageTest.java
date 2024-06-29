package test_package;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constants.Constants;
import constants.Messages;
import page_object.HomePage;
import page_object.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class HomePageTest extends Base{
	@Test
	public void verifyHomePageTitle()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		String actual_title=home.getHomePageTitle();
		String expected_title=ExcelUtility.getStringData(0, 1, Constants.HOME_PAGE);
		Assert.assertEquals(actual_title, expected_title, Messages.TITLE_INVALID);
	}
//jhu
	@Test
	public void verifyUserLoginDate()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(1, 1, Constants.LOGIN_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		HomePage home=login.clickOnLoginButton();
		String actual_logindate=home.getLoginDate();
		String expected_logindate=home.getCurrentDate();
		Assert.assertEquals(actual_logindate, expected_logindate, Messages.LOGIN_DATE_MISMATCH);
		
	}
	
    

}
