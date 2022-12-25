package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage 
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "(//android.widget.Button)[1]")
	private WebElement backButton;
	
	@AndroidFindBy(xpath = "//android.view.View/android.widget.Button")
	private WebElement cartButton;
	
	public ProductPage(AndroidDriver driver)
	{
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
}
