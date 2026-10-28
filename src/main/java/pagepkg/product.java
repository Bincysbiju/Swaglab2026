package pagepkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class product {
	WebDriver driver;

    // Logo element
	@FindBy(xpath = "//div[@class='app_logo']")
    public WebElement logo;

    // Multiple Add to cart buttons
	@FindBy(xpath = "//button[text()='Add to cart']")
	List<WebElement> cartbutton;
    // Product details list
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> productdetails;
 // 1. Dropdown (Sorting container) element
    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement sortDropdown;

    // 2.  (Hamburger menu) element
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement hamburgerMenu;

    // 3. Cart icon element
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    // Constructor
    public product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Logo verification method
    public WebElement logoverify() {
        return logo;
    }

    // Add all items to cart using loop
    public void additems() throws InterruptedException {
        for (WebElement items : cartbutton) {
            Thread.sleep(2000);
            items.click();
        }
    }

    // Product details method
    public List<WebElement> productdtls() {
        return productdetails;
    }
 // Dropdown sorting method 
    public void sortProducts(String optionText) {
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(optionText);
    }

   
    public void clickHamburgerMenu() {
        hamburgerMenu.click();
    }

    // Cart icon click method
    public void clickCartIcon() {
        cartIcon.click();
    }
}

