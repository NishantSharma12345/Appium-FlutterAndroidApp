package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class ProductPageTest extends BaseClassAndroid
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
	public void androidProductPageTestPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		//hp.singleProductScrollDown();
		pp.cartButtonClick();
		pp.backButtonClick();
	}
}
