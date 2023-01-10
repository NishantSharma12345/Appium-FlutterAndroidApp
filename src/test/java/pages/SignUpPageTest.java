package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class SignUpPageTest extends BaseClassAndroid
{
	LoginPage lp;
	SignUpPage sp;
	HomePage hp;
	ProductPage pp;
	OTPPage otpp;
	CartPage cp;
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		sp = new SignUpPage(driver);
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
		otpp = new OTPPage(driver);
		cp = new CartPage(driver);
	}
	
	@Test
	public void androidUserSignUpPageTestPerform() throws InterruptedException
	{
		/*lp.signUpClick();
		sp.signUpHeaderVerify();
		loginClickVerify();
		sp.userSignUp(prop.getProperty("email"), prop.getProperty("password"));
		sp.loginClick();*/
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		otpp.enterOTPNumber();
		Thread.sleep(5000);
		hp.singleProductScrollAndLongPress(); 
		Thread.sleep(4000);
		hp.cartButtonClick();
		cp.backButtonClick();
		hp.sendFeedback();
		//hp.productScrollUpAndDown(pp);
		Thread.sleep(4000);
		/*hp.bannerSwipe();
		Thread.sleep(4000);
		/*hp.productScroll();
		Thread.sleep(5000);
		pp.backButtonClick();
		Thread.sleep(5000);*/
		//hp.productScrollUpAndDown(pp);swipeGesture(bannerImages1.get(0), "left");
		//hp.scrolltocart();
		/*hp.singleProductScrollDown();
        pp.dragAndDropQuantityInCart();
		Thread.sleep(5000);
		/*hp.cartButtonClick();
		 */
		//hp.singleProductScrollAndLongPress();
		//Thread.sleep(5000);
	}
	
	public void loginClickVerify()
	{
		sp.loginClick();
		lp.signUpClick();		
	}
}
