package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//section[@class='content-header']")
WebElement login_message;
@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
WebElement end_tour;
@FindBy(xpath="//span[text()='User Management']")
WebElement user_management;
@FindBy(xpath="//span[@class='title' and contains(text(),'Users')]")
WebElement users_option;
@FindBy(xpath="//a[@class='dropdown-toggle']")
WebElement user_logout;
@FindBy(xpath="//a[text()='Sign Out']")
WebElement signout_button;
@FindBy(xpath="//a[text()='Profile']")
WebElement profile_button;
@FindBy(id="last_name")
WebElement edit_lastname;
@FindBy(xpath="//button[text()='Update']")
WebElement update_button;

public String getLoginText()
{
	String user_message=login_message.getText();
	return user_message;
}
public String getHomePageTitle()
{
	String title=driver.getTitle();
	return title;
}
public void clickOnEndTourButton()
{
	end_tour.click();
}
public void clickOnUserManagement()
{
	user_management.click();
}
public AddUserPage clickOnUsersOption()
{
	users_option.click();
	return new AddUserPage(driver);
}
public void clickOnUserLogOut()
{
	user_logout.click();
}
public void clickOnSignOutButton()
{
	signout_button.click();
}
public void clickOnProfileButton()
{
	profile_button.click();
}
public void clearLastName()
{
	edit_lastname.clear();
}
public void enterNewLastName(String new_lastname)
{
	edit_lastname.sendKeys(new_lastname);
}
public void clickOnUpdateButton()
{
	update_button.click();
}
public String getUserProfileText()
{
	String edit_text=user_logout.getText();
	return edit_text;
}


}
