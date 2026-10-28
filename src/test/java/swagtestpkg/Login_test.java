package swagtestpkg;

import java.io.IOException;

import utilitiispkg.ExcelUtil;
import pagepkg.Login;
import basepkg.ReporterClass;
import basepkg.base;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class Login_test extends base {
	Login log;

    
    // DATA PROVIDER FOR LOGIN
    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        String path = "D:\\dataoes.xlsx";
        return ExcelUtil.getTestData(path, "Sheet1");
    }

    // LOGIN DATA-DRIVEN TEST
    @Test(dataProvider = "loginData", priority = 1)
    public void loginTest(String user, String password) throws InterruptedException, IOException {
        driver.get("https://www.saucedemo.com/");
        
        test = extent.createTest("Login Test - " + user);
        
        log = new Login(driver);
        log.setvalue(user, password);
        log.login_button();

        System.out.println("Executed for: " + user);

        String currentUrl = driver.getCurrentUrl();

        // LOGIN SUCCESS
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            test.pass("Login successful for: " + user);
        } 
        // LOGIN FAILURE
        else {
            String screenshotName = "LoginFailed_" + user;
            ReporterClass.screenshotmethodString(driver, screenshotName);
            
            test.addScreenCaptureFromPath(
                "screenshot\\" + screenshotName + ".png"
            );
            
            test.fail("Login failed for: " + user);
            Assert.fail("Login failed for: " + user);
        }
    }

    // LOGO VALIDATION
    @Test
    public void logoValidation() throws IOException {
        driver.get("https://www.saucedemo.com/");
        
        test = extent.createTest("Logo Validation Test");
        log = new Login(driver);
        
        boolean logoPresent = log.logoverification().isDisplayed();
        
        if (logoPresent) {
            test.pass("Logo is displayed");
        } else {
            String screenshotName = "logo_validation";
            ReporterClass.screenshotmethodString(driver, screenshotName);
            test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
            test.fail("Logo not displayed");
            Assert.fail("Logo not displayed");
        }
    }

    // BUTTON TEXT VALIDATION
    @Test(priority = 2)
    public void buttontexivalidation() throws IOException {
        driver.get("https://www.saucedemo.com/");
        
        test = extent.createTest("Button Text Validation Test");
        log = new Login(driver);
        
        String text = log.buttontext().getDomAttribute("value");
        
        if (text.equals("Login")) {
            test.pass("Button text is Login");
        } else {
            String screenshotName = "button_text_validation";
            ReporterClass.screenshotmethodString(driver, screenshotName);
            test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
            test.fail("Button text is not Login");
            Assert.fail("Button text is not Login");
        }
    }


    // PLACEHOLDER VALIDATION
       
    public void placeholdervalidation() throws IOException {
        driver.get("https://www.saucedemo.com/");
        
        test = extent.createTest("Placeholder Validation Test");
        log = new Login(driver);
        
        String usernamePlaceholder = log.username.getDomAttribute("placeholder");
        String passwordPlaceholder = log.pass.getDomAttribute("placeholder");
        
        if (usernamePlaceholder.equals("Username") && passwordPlaceholder.equals("Password")) {
            test.pass("Placeholder validation passed");
        } else {
            String screenshotName = "placeholder_validation";
            ReporterClass.screenshotmethodString(driver, screenshotName);
            test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
            test.fail("Placeholder validation failed");
            Assert.fail("Placeholder validation failed");
        }
    }

    // TITLE VALIDATION
    public void fetchtitle() throws IOException {
        driver.get("https://www.saucedemo.com/");
        
        test = extent.createTest("Title Validation Test");
        
        String act = driver.getTitle();
        String exp = "Swag Labs";
        
        if (exp.equals(act)) {
            test.pass("Title validation passed");
        } else {
            String screenshotName = "title_validation";
            ReporterClass.screenshotmethodString(driver, screenshotName);
            test.addScreenCaptureFromPath("screenshot\\" + screenshotName + ".png");
            test.fail("Title validation failed");
            Assert.fail("Title validation failed");
        }
    }
}