package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import helper.AndroidGestures;
import helper.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends AndroidGestures
{
	AndroidDriver driver;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[1]")
	private WebElement logoutButton;
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc='EXPLORE']")
	private WebElement exploreLabel;
	
	@AndroidFindBy(accessibility = "check some out of here!!")
	private WebElement checkSomeLabel;
	
	@AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
	private WebElement bannerImages;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Hyundai')]")
	private WebElement product;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'From:')]")
	private List<WebElement> product1;
	
	@AndroidFindBy(accessibility = "Explore Cart Now !!")
	private WebElement cartButton;	
	
	@AndroidFindBy(xpath = "android.widget.EditText")
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().text(\"FeedBack Enter your feedback\"))")
	private WebElement element;
	
/*	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().textContains(\"Hyundai\"))")
	private WebElement element1;
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*Explore Cart Now !!.*\"))")
	private WebElement elementid;*/
	
	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(resourceIdMatches(\".*Explore Cart Now !!.*\"));")
	private WebElement scroll;
	
	
	public HomePage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void logoutButtonClick()
	{
		logoutButton.click();
	}

	public void headerTextVerify()
	{
		Assert.assertEquals(exploreLabel.getAttribute("content-desc"), "EXPLORE");
		Assert.assertEquals(checkSomeLabel.getAttribute("content-desc"), "Check some out of here!!");
	}
	
	public void bannerSwipe()
	{
		AppiumUtils.waitForElementToBeClickable(driver, bannerImages);		
		swipeGesture(bannerImages, "right");
	}
	
	public void singleProductScrollDown()
	{
		scrollGesture(0, 600, 200, 1500, "down");
		AppiumUtils.waitForElementToVisible(driver, product);		
		product.click();
	}
	
	public void productScrollUpAndDown(ProductPage pp) 
	{
		if(!product1.get(0).isDisplayed())
		{
			scrollGesture(0, 600, 200, 1500, "down");

			for(int i = 0; i < product1.size() + 1; i++)
			{
				//if(i==2)
				//{
					swipeGesture(product1.get(i), "right");
					//Thread.sleep(2000);
				//}
				AppiumUtils.waitForElementToVisible(driver, product1.get(i));
				product1.get(i).click();
				pp.backButtonClick();
				//swipeGesture(product1.get(i+1), "right");				
			}
		}
		else
		{
			scrollGesture(0, -600, 200, 1500, "up");
		}		
	}
	
	public void productsSwipe() 
	{
		AppiumUtils.waitForElementToBeClickable(driver, product);		
		swipeGesture(product, "right");
		product.click();
	}
	
	public void cartButtonClick()
	{
		if(!product.isDisplayed())
		{
			scrollGesture(0, 400, 0, 1800, "down");
			AppiumUtils.waitForElementToVisible(driver, cartButton);
			cartButton.click();
		}
		else
		{
			scrollGesture(0, 100, 0, 400, "down");
			AppiumUtils.waitForElementToVisible(driver, cartButton);
			Assert.assertEquals(cartButton.getAttribute("content-desc"), "Explore Cart Now !!");
			cartButton.click();
		}
	}
	
	public void scrolltocart()
	{
		element.click();
		element.sendKeys("test");
	}
	
	public void singleProductScrollAndLongPress()
	{
		scrollGesture(0, 600, 200, 1500, "down");
		//scrollToText(product.getAttribute("content-desc").substring(0));
		AppiumUtils.waitForElementToVisible(driver, product);		
		longClickGesture(product, "2000");
	}
}
