package pages;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClassAndroid;

public class CartPageTest extends BaseClassAndroid 
{
	LoginPage lp;
	HomePage hp;
	ProductPage pp;
	CartPage cp;
	
	@BeforeClass
	public void init()
	{
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cp = new CartPage(driver);
	}
	
	@Test
	public void androidCartPageTestPerform()
	{
		lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
		hp.cartButtonClick();
		cp.emptyOrNotEmptyCartPage();
		//hp.productsSwipe();
		pp.cartButtonClick();
		pp.backButtonClick();
		hp.cartButtonClick();
		cp.addAddressButtonClick();
	}
}
