package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {

	public static boolean isElementDisplayed(WebElement element) {
		boolean option_displayed = element.isDisplayed();
		return option_displayed;
	}

	public static boolean isElementEnabled(WebElement element) {
		boolean option_enabled = element.isEnabled();
		return option_enabled;
	}

	public static boolean isElementSelected(WebElement element) {
		boolean option_selected = element.isEnabled();
		return option_selected;
	}

}
