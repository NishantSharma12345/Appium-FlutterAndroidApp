package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class LoginPageTest extends BaseClassAndroid
{
	LoginPage lp;
	SignUpPage sp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		sp = new SignUpPage(driver);
	}
	
	@Test
	public void androidUserLoginPageTestPerform() throws InterruptedException
	{
		lp.loginHeaderVerify();
		signUpClickVerify();
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(5000);
	}
	
	public void signUpClickVerify()
	{
		lp.signUpClick();
		sp.loginClick();
	}
}
