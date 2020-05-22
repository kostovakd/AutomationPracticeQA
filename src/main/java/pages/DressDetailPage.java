package pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DressDetailPage extends APAbstractPage {

    @FindBy(className = "icon-plus")
    private ExtendedWebElement quantityButton;

    @FindBy(id = "group_1")
    private ExtendedWebElement selectSizeInput;

    @FindBy(id = "color_8")
    private ExtendedWebElement changeWhiteColor;

    @FindBy(id = "add_to_cart")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//div[@id='layer_cart']//span[@class='cross']")
    private ExtendedWebElement clickCloseWindow;

    public DressDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasTweetButton(WebDriver driver) {
        return driver.findElement(By.className("icon-twitter")).isDisplayed();
    }

    public boolean hasFacebookButton(WebDriver driver) {
        return driver.findElement(By.className("icon-facebook")).isDisplayed();
    }

    public DressesPage clickQuantity(int clickTimes) {
        for (int i = 0; i < clickTimes; i++) {
            quantityButton.click();
        }
        return new DressesPage(driver);
    }

    public DressesPage selectSize() {
        Select sizeMenu = new Select(driver.findElement(By.id("group_1")));
        sizeMenu.selectByValue("2");
        selectSizeInput.sendKeys(Keys.RETURN);
        return new DressesPage(driver);
    }

    public DressesPage changeColor() {
        changeWhiteColor.click();
        return new DressesPage(driver);
    }

    public DressesPage clickAddToCart() {
        addToCartButton.click();
        return new DressesPage(driver);
    }

    public DressesPage closeWindow() {
        clickCloseWindow.click();
        return new DressesPage(driver);
    }
}
