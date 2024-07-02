package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.DateUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']")
	WebElement login_message;
	@FindBy(xpath = "//button[@class='btn btn-default btn-sm']")
	WebElement end_tour;
	@FindBy(xpath = "//span[text()='User Management']")
	WebElement user_management;
	@FindBy(xpath = "//i[@class='fa fa-user']//following-sibling::span")
	WebElement users_option;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement user_logout;
	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout_button;
	@FindBy(xpath = "//a[text()='Profile']")
	WebElement profile_button;
	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement logindate_field;

	public String getLoginText() {
		String user_message = login_message.getText();
		return user_message;
	}

	public String getHomePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnEndTourButton() {
		end_tour.click();
	}

	public UserManagementPage clickOnUserManagement() {
		user_management.click();
		return new UserManagementPage(driver);
	}

	public UsersPage clickOnUsersOption() {
		users_option.click();
		return new UsersPage(driver);
	}

	public void clickOnUserLogOut() {
		user_logout.click();
	}

	public void clickOnSignOutButton() {
		signout_button.click();
	}

	public My_ProfilePage clickOnProfileButton() {
		profile_button.click();
		return new My_ProfilePage(driver);
	}

	public String getUserProfileText() {
		String edit_text = user_logout.getText();
		return edit_text;
	}

	public String getLoginDate() {
		String login_date = logindate_field.getText();
		return login_date;
	}

	public String getCurrentDate() {
		String current_date = DateUtility.getUserLoginDate(Constants.SYSTEM_DATE);
		return current_date;
	}

}
