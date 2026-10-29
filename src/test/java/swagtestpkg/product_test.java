package swagtestpkg;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basepkg.ReporterClass;
import basepkg.base;
import pagepkg.Login;
import pagepkg.product;

public class product_test extends base{
	
	Login log ;
    product pdt;

	
	@Test(priority = 1)

    public void logo() throws IOException, InterruptedException {
        // 
		test = extent.createTest("Checkout Process Test");
		log = new Login(driver);
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();
        Thread.sleep(2000);

        test = extent.createTest("logo validation test");
        
        pdt = new product(driver);
        WebElement x = pdt.logoverify();

        if (x.isDisplayed()) {
            test.pass("logo displayed in product page");
        } else {
            String path = ReporterClass.screenshotmethodString(driver, "logo_fail");
            test.addScreenCaptureFromPath(path);
            test.fail("logo not displayed");
        }
    }
    @Test(priority = 2)
    public void additemstocart() throws InterruptedException {
    	// 2. Sort products
        pdt.sortProducts("Price (low to high)");
        test.pass("Products sorted by Price (low to high)");
        Thread.sleep(2000);
        
        // 3. Add items to cart
        pdt.additems();
        Thread.sleep(2000);
        
        // 4. Product details list and print
        List<WebElement> dtl = pdt.productdtls();
        Thread.sleep(2000);
        System.out.println("Total Number of Products: " + dtl.size());
        test.pass("Total Number of Products added/found: " + dtl.size());
        
        for (WebElement ele : dtl) {
            System.out.println(ele.getText());
        }
        
       pdt.clickCartIcon();
       Thread.sleep(3000);
//        pdt.clickHamburgerMenu();
//        Thread.sleep(1000);
        
        
//        test.pass("Hamburger Menu clicked and flow completed successfully");
    }}