package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement username_field;
	@FindBy(id="password")
	WebElement password_field;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement login_button;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement error_message;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgot_password_field;
	
	public void enterUsername(String username)
	{
		username_field.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		password_field.sendKeys(password);
	}
	public HomePage clickOnLoginButton()
	{
		login_button.click();
		return new HomePage(driver);
	}
	public String getErrorMessage()
	{
		String message=error_message.getText();
		return message;
	}
	public ResetPage clickOnForgotPassword()
	{
		forgot_password_field.click();
		return new ResetPage(driver);
	}
}
