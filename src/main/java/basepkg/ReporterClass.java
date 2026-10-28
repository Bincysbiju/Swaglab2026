package basepkg;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReporterClass {
	public static ExtentReports sam() {
        // Create Reports folder
        File folder = new File("./reports");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        
        ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/report.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Swag Labs Automation");
        reporter.config().setTheme(Theme.DARK);
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        
        extent.setSystemInfo("Tester", "bincy");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser", "Chrome");
        
        return extent;
    }
    

	public static String screenshotmethodString(WebDriver driver, String screenshotname) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        File folder = new File("./screenshot");
        if (!folder.exists()) {
            folder.mkdirs();
        }
        
        String destination = "./screenshot/" + screenshotname + ".png";
        FileHandler.copy(src, new File(destination));
        
        return destination;
    }
}
//	public static ExtentReports sam() {
//        File folder = new File("./reports");
//        if (!folder.exists()) {
//            folder.mkdirs();
//        }
//        
//        ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/report.html");
//        reporter.config().setDocumentTitle("Automation Report");
//        reporter.config().setReportName("Swag Labs Automation");
//        reporter.config().setTheme(Theme.DARK);
//        
//        ExtentReports extent = new ExtentReports();
//        extent.attachReporter(reporter);
//        
//        extent.setSystemInfo("Tester", "Bincy s Biju");
//        extent.setSystemInfo("OS", "Windows 11");
//        extent.setSystemInfo("Browser", "Chrome");
//        
//        return extent;
//    }
//    
//	public static String screenshotMethod(WebDriver driver, String screenshotName) throws IOException {
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File src = ts.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("./reports") + "/screenshots/" + screenshotName + ".png";
//        FileUtils.copyFile(src, new File(destination));
//        return destination;
//    }
//
//}
