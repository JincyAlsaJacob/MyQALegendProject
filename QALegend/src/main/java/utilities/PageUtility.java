package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public static void selectFromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectFromDropDownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public static void selectFromDropDownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void forSimpleAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public static void forConfirmationAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public static void forPromptAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
		alert.accept();

	}

	public static void forRightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public static void forDoubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public static void forDragAndDrop(WebDriver driver, WebElement source_element, WebElement target_element) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source_element, target_element).build().perform();
	}

	public static void forDragAndOffset(WebDriver driver, WebElement source_element) {
		Actions action = new Actions(driver);
		action.dragAndDropBy(source_element, 50, 100).build().perform();
	}

	public static void forMouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

}
