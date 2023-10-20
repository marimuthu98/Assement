package base.com;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	protected static WebDriver driver;

	public void browserLanuch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		System.out.println("Website Launching");
		System.out.println("Wesite Launched and maximixed");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);

	}

	public void btnclick(WebElement element) {
		element.click();

	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String getallTexts(List<WebElement> element) {
		List<WebElement> elements = element;
		for (WebElement element1 : elements) {
			String elementText = element1.getText();
			System.out.println(elementText);
		}
		return null;

	}

	public WebElement clickEqual(List<WebElement> elements, String textToMatch) {
		for (WebElement element : elements) {
			String elementText = element.getText();
			if (elementText.equals(textToMatch)) {
				element.click();
				return element;
			} else {
				System.out.println("Text is Not Matched");
			}

		}

		return null;
	}

	public WebElement findLocatorById(String data) {
		WebElement element = driver.findElement(By.id(data));
		return element;
	}

	public WebElement findLocatorByName(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}

	public WebElement findLocatorByClassName(String data) {
		WebElement element = driver.findElement(By.className(data));
		return element;
	}

	public WebElement findLocatorByXpath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}

	public void implicitlyWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public String gettitle() {
		String title = driver.getTitle();
		return title;

	}

	public void closebrowser() {
		driver.close();
	}

	public void closeallbrowser() {
		driver.quit();
		System.out.println("Website is Closed");
	}

	public void alertByAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();

	}

	public void alertByDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
		;

	}

	public void alertBySendkeys(String data) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(data);

	}

	public void selectByIndex(WebElement element, int indexnum) {
		Select s = new Select(element);
		s.selectByIndex(indexnum);
	}

	public void selectByValue(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public void selectByVisibletext(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public void deselectByIndex(WebElement element, int indexnum) {
		Select s = new Select(element);
		s.deselectByIndex(indexnum);
	}

	public void deselectByValue(WebElement element, String data) {
		Select s = new Select(element);
		s.deselectByValue(data);
	}

	public static void newTabhandle() {
		Set<String> par = driver.getWindowHandles();
		Set<String> newwindow = driver.getWindowHandles();
		for (String x : newwindow) {
			if (!par.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}

	public static void parentTabhandle() {
		driver.close();
		Set<String> par = driver.getWindowHandles();
		for (String x : par) {
			driver.switchTo().window(x);
		}

	}

	public static void VerifyTextValidation(WebElement element, String Text) {
		String actualText = (element.getText()).trim();
		try {
			Assert.assertEquals(actualText, Text);
			System.out.println("The expected '" + Text + "' popup message is verified.");
		} catch (AssertionError e) {
			System.out.println(
					"The Expected success message is " + Text + " but the Actual message is " + actualText + "");
			throw e;
		}
	}

	public static void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void FailedMethodTakesscreenshot(ITestResult result) throws Exception {


		TakesScreenshot scr = (TakesScreenshot) driver;
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
	    LocalDateTime ldt = LocalDateTime.now();
	    String TimeStamp = dtf.format(ldt);
	    File srcFile = scr.getScreenshotAs(OutputType.FILE);

	    if (result.FAILURE == result.getStatus()) {
	        String directory = System.getProperty("user.dir") + "/FailureScreenShots/";
	        File dir = new File(directory);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        String destination = directory + TimeStamp + "-" + result.getName() + ".png";
	        File destFile = new File(destination);
	        FileUtils.copyFile(srcFile, destFile);
	    } else if (result.SKIP == result.getStatus()) {
	    } else if (result.SUCCESS == result.getStatus()) {

	    }

	}

	

}
