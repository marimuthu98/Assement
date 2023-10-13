package base.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import locators.com.Locators;

public class Searchpage extends Baseclass {

	Locators lp;

	public Searchpage(WebDriver driver) {
		lp = PageFactory.initElements(driver, Locators.class);
	}

	public void search(String productname) {
		enterText(lp.getSearch_bar(), productname);
	}

	public void text(String product) throws InterruptedException {
		getallTexts(lp.getitem());
		clickEqual(lp.getitem(), product);
		btnclick(lp.getProduct_click());
		newTabhandle();
		btnclick(lp.getAddToCart_button());
		Thread.sleep(2000);
		VerifyTextValidation(lp.getCartaddedmessage(), "Added to Cart");
//		String text = getText(lp.getCartaddedmessage());
//		System.out.println(text);
	}
}
