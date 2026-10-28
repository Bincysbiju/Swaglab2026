package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement pass;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement login;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    public WebElement logo;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement logoverification() {
        return logo;
    }

    public WebElement buttontext() {
        return login;
    }

    public void setvalue(String user, String pwd) throws InterruptedException {
    	username.clear();
        username.sendKeys(user);
        pass.clear();
        pass.sendKeys(pwd);
    }

    public void login_button() {
        login.click();
    }
}
//    @FindBy(xpath = "//*[@id='user-name']")
//    WebElement username;
//
//    @FindBy(xpath = "//*[@id='password']")
//    WebElement password;
//
//    @FindBy(xpath = "//*[@id='login-button']")
//    WebElement login;
//
//    public Login(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    public void setvalue(String user, String pass) {
//        username.sendKeys(user);
//        password.sendKeys(pass);
//    }
//
//    public void login_button() {
//        login.click();
//    }
//}

