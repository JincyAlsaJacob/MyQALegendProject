package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_ProfilePage {

	WebDriver driver;

	public My_ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "last_name")
	WebElement edit_lastname;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement update_button;

	public void clearLastName() {
		edit_lastname.clear();
	}

	public void enterNewLastName(String new_lastname) {
		edit_lastname.sendKeys(new_lastname);
	}

	public void clickOnUpdateButton() {
		update_button.click();
	}

}
