package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WebElementUtility;

public class UserManagementPage {
	WebDriver driver;
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	@FindBy(xpath="//i[@class='fa fa-user']//following-sibling::span")
	WebElement users_option;
	@FindBy(xpath="//i[@class='fa fa-briefcase']//following-sibling::span")
	WebElement roles_option;
	@FindBy(xpath="//i[@class='fa fa-handshake-o']//following-sibling::span")
	WebElement salescommisionagent_option;
	
	public boolean isUsersOptionDisplayed()
	{
		return WebElementUtility.isElementDisplayed(users_option);
	}
	public boolean isRolesOptionDisplayed()
	{
		return WebElementUtility.isElementDisplayed(roles_option);
	}
	public boolean isSalesCommissionAgentOptionDisplayed()
	{
		return WebElementUtility.isElementDisplayed(salescommisionagent_option);
	}

}
