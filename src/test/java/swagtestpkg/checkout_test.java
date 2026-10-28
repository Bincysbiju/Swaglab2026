package swagtestpkg;

import org.testng.annotations.Test;

import basepkg.base;
import pagepkg.Login;
import pagepkg.checkout;
import pagepkg.product;

public class checkout_test  extends base{
	@Test
    public void verifyCheckoutProcess() throws InterruptedException {
        Login log = new Login(driver);
        product pdt = new product(driver);
        checkout ck = new checkout(driver);
        
        test = extent.createTest("Checkout Process Test");
        
        // 1. Login
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();
        Thread.sleep(2000);
        
        // 2. Add items to cart
        pdt.additems();
        Thread.sleep(2000);
        
        // 3. Click Cart Icon
        ck.clickCart();
        Thread.sleep(2000);
        
        // 4. Click Checkout Button
        ck.clickCheckout();
        Thread.sleep(2000);
        
        // 5. Enter Checkout Information (First name, Last name, Zip)
        ck.setDetails("Anand", "Kumar", "682001");
        Thread.sleep(2000);
        
        // 6. Finish Order
        ck.clickFinish();
        Thread.sleep(2000);
     // 7. Click Hamburger
        ck.clickHamburgerMenu();
        Thread.sleep(2000);
        
        // 8. Click Logout
        ck.clickLogout();
        Thread.sleep(2000);
        
        test.pass("Checkout process completed successfully");
    }
}