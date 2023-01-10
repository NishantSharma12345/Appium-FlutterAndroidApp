package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import helper.AndroidGestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends AndroidGestures
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement backButton;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button")
	private WebElement cartButton;
	
	@AndroidFindBy(accessibility ="1")
	private WebElement quantityNumber;
	
	public ProductPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void backButtonClick()
	{
		backButton.click();
	}
	
	public void cartButtonClick()
	{
		cartButton.click();
	}
	
	public void dragAndDropQuantityInCart()
	{
		dragGesture(quantityNumber,970,2190);
	}
}
