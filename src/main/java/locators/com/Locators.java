package locators.com;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {

	@FindBy(id = "twotabsearchtextbox")
	private WebElement search_bar;

	@FindBy(id = "nav-search-submit-button")
	private WebElement search_button;

	@FindBy(xpath = "//div[@class='a-section aok-relative s-image-fixed-height']//img")
	private WebElement product_click;

	@FindBy(id = "add-to-cart-button")
	private WebElement addToCart_button;

	@FindBy(css = "#attachDisplayAddBaseAlert .a-alert-heading")
	private WebElement cartaddedmessage;

	public WebElement getSearch_bar() {
		return search_bar;
	}

	public WebElement getsearch_button() {
		return search_button;
	}

	public WebElement getProduct_click() {
		return product_click;
	}

	public WebElement getAddToCart_button() {
		return addToCart_button;
	}

	public WebElement getCartaddedmessage() {
		return cartaddedmessage;
	}

}
