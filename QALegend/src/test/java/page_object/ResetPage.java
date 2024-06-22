package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement emailID_field;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement reset_password_button;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement reset_error_message;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement confirmation_message;
	
	public void enterEmail(String email)
	{
		emailID_field.sendKeys(email);
	}
	public void clickOnPasswordResetButton()
	{
		reset_password_button.click();
	}
	public String getResetErrorMessage()
	{
		String message=reset_error_message.getText();
		return message;
	}
	public String getConfirmationMessage() 
	{
		String message=confirmation_message.getText();
		return message;
	}
	

}
