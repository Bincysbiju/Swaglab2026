package basepkg;

import java.time.Duration;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class base {
	public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;
    
    public String url = "https://www.saucedemo.com/";
    
    
    @BeforeSuite
    public void setupReport() {
        extent = ReporterClass.sam();

    	driver = new ChromeDriver();
        driver.get(url);
    }
//    @BeforeTest
//    public void browser_launch() {
//        driver = new ChromeDriver();
//        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//    }
    
    @AfterSuite
    public void teardown() {
        driver.quit();
        extent.flush();
    }
}

