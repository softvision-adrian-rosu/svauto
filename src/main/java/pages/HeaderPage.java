package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.WebElementHelper.areVisible;

public class HeaderPage extends BasePage {

    @FindBy(xpath = "//div[@class='banner']")
    private WebElement banner;

    @FindBy(className = "shop-phone")
    private WebElement phoneContactHeader;

    @FindBy(xpath = "//a[@title='Contact Us']")
    private WebElement contactUsLink;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCart;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    protected boolean isCurrent() {
        return areVisible(banner);
    }

    protected boolean isValid() {
        return areVisible(banner, phoneContactHeader, contactUsLink, shoppingCart);
    }

    public void clickLogoutButton(){
        this.logoutButton.click();
    }

    public void clickContactUsLink(){
        this.contactUsLink.click();
    }

    public void clickShoppingCart(){
        this.shoppingCart.click();
    }
}
