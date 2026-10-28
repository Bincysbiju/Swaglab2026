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
	log=new Login(driver);
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();
        test = extent.createTest("logo validation test");
        pdt=new product(driver);
        WebElement x = pdt.logoverify();
        
        if(x.isDisplayed()) 
        {
            test.pass("logo displayed in product page");
        } 
        else 
        {
            String path = ReporterClass.screenshotmethodString(driver, "logo_fail");
            test.addScreenCaptureFromPath(path);
            test.fail("logo not displayed");
        }
    }

    @Test(priority = 2)
    public void additemstocart() throws InterruptedException {
    	test = extent.createTest("Product Page Actions & Cart Test");
    	Login log = new Login(driver);
        log.setvalue("standard_user", "secret_sauce");
        log.login_button();

        pdt = new product(driver);
        
        Thread.sleep(5000);
        
        // sort
        pdt.sortProducts("Price (low to high)");
        test.pass("Products sorted by Price (low to high)");
        Thread.sleep(2000);
        
        // 2. cart
        pdt.additems();
        Thread.sleep(5000);
        
        // 
        List<WebElement> dtl = pdt.productdtls();
        Thread.sleep(2000);
        System.out.println("Total Number of Products: " + dtl.size());
        test.pass("Total Number of Products added/found: " + dtl.size());
        for(WebElement product : dtl) {
            System.out.println(product.getText());
        }
        
        pdt.clickHamburgerMenu();
        test.pass("Hamburger Menu clicked successfully");
        Thread.sleep(2000);
        
        pdt.clickCartIcon();
        test.pass("Navigated to Cart page successfully");
        Thread.sleep(2000);
    }}