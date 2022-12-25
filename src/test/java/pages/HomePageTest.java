package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class HomePageTest extends BaseClassAndroid
{
	LoginPage lp;
	HomePage hp;
	ProductPage pp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		pp = new ProductPage(driver);
	}

	@Test
	public void androidUserLoginPageTestPerform() throws InterruptedException
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		hp.headerTextVerify();
		hp.bannerSwipe();
		hp.productScrollUpAndDown(pp);
		hp.productScrollUpAndDown(pp);
		hp.logoutButtonClick();
	}
	
}
