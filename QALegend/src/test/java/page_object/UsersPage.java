package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.WaitUtility;

public class UsersPage {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement add_user_field;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_field;
	@FindBy(className = "toast-success")
	WebElement success_message;
	@FindBy(xpath = "//table[@id='users_table']//tr//td[4]")
	WebElement user_email;

	public AddUserPage clickOnAddUser() {
		add_user_field.click();
		return new AddUserPage(driver);
	}

	public void searchUserOnSearchFieldUsingEmail(String email) {
		search_field.sendKeys(email);
	}

	public String waitForTextToBeInvisible() {
		String msg_text = success_message.getText();
		WaitUtility.waitForElementToBeInVisible(driver, success_message);
		return msg_text;
	}

	public String getSearchUser() {

		WaitUtility.waitForElementToBeVisible(driver, user_email);
		String user_mail = user_email.getText();
		return user_mail;
	}

}
