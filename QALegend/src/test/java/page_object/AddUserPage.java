package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add_user_field;
	@FindBy(id="first_name")
	WebElement firstname_field;
	@FindBy(id="last_name")
	WebElement lastname_field;
	@FindBy(id="email")
	WebElement email_field;
	@FindBy(xpath="//select[@id='role']")
	WebElement role_dropdown;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement userpassword;
	@FindBy(id="confirm_password")
	WebElement confirm_userpassword;
	@FindBy(id="submit_user_button")
	WebElement save_button;
	@FindBy(className="toast-success")
	WebElement success_message;
	
	
	public void clickOnAddUser()
	{
		add_user_field.click();
	}
	public void enterFirstName(String firstname)
	{
		firstname_field.sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		lastname_field.sendKeys(lastname);
	}
	public void enterEmail(String email)
	{
		email_field.sendKeys(email);
	}
	public void selectFromDropDown()
	{
		Select select=new Select(role_dropdown);
		select.selectByIndex(2);
	}
	public void enterUserName(String username_value)
	{
		username.sendKeys(username_value);
	}
	public void enterPassword(String passworduser)
	{
		userpassword.sendKeys(passworduser);
	}
	public void enterConfirmPassword(String passworduser)
	{
		confirm_userpassword.sendKeys(passworduser);
	}
	public void clickOnSaveButton()
	{
		save_button.click();
	}
	public void waitForTextToBeInvisible()
	{
		WaitUtility.waitForElementToBeInVisible(driver, success_message);
	}

}
