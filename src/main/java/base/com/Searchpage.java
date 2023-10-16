package base.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import locators.com.Locators;

public class Searchpage extends Baseclass {

	Locators LOCATOR;

	public Searchpage(WebDriver driver) {
		LOCATOR = PageFactory.initElements(driver, Locators.class);
	}

	public void search_product(String productname) {
		enterText(LOCATOR.getSearch_bar(), productname);
	}

	public void searchbar_button() {
		btnclick(LOCATOR.getsearch_button());
	}

	public void select_product() {

		btnclick(LOCATOR.getProduct_click());
		newTabhandle();

	}

	public void product_add_card() {
		btnclick(LOCATOR.getAddToCart_button());
		waitForElement(LOCATOR.getCartaddedmessage());
		String text = getText(LOCATOR.getCartaddedmessage());
		System.out.println(text);
		VerifyTextValidation(LOCATOR.getCartaddedmessage(), "Added to Cart");

	}
}
