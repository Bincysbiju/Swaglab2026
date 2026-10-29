package swagtestpkg;

import java.util.List;

import org.openqa.selenium.WebElement;
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
        
        
        driver.get("https://www.saucedemo.com/");
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();
        Thread.sleep(2000);
        test.pass("Logged in successfully for Checkout flow");
        
        // 2. Sort products
        pdt.sortProducts("Price (low to high)");
        test.pass("Products sorted by Price (low to high)");
        Thread.sleep(2000);
        
        // 3. Add items to cart
        pdt.additems();
        Thread.sleep(2000);
        
        // 4. Product Details extraction & Reporting
        List<WebElement> dtl = pdt.productdtls();
        Thread.sleep(2000);
        System.out.println("Total Number of Products: " + dtl.size());
        test.pass("Total Number of Products found: " + dtl.size());
        
        for (WebElement ele : dtl) {
            String productDetails = ele.getText();
            System.out.println(productDetails);
            test.info("Product Info: " + productDetails);
        }

        pdt.clickCartIcon();
        Thread.sleep(2000);
        
        // 6. Click Checkout Button
        ck.clickCheckout();
        Thread.sleep(2000);
        
        // 7. Enter Checkout Information
        ck.setDetails("Anand", "Kumar", "682001");
        Thread.sleep(2000);
        
        // 8. Finish Order
        ck.clickFinish();
        Thread.sleep(2000);
        test.pass("Checkout process completed successfully");
        
        // 9. Logout Flow )
        
        ck.clickHamburgerMenu();
        Thread.sleep(2000);
        test.pass("Hamburger Menu clicked and flow completed successfully");
        ck.clickLogout();
        Thread.sleep(2000);
        
        test.pass("Logout completed successfully after checkout");
    }
}