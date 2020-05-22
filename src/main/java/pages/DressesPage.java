package pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DressesPage extends APAbstractPage {
    final String CART_PRODUCT_QUANTITY_XPATH = "//dt['cart_block_product_6_41_0']//span[@class='quantity']";

    @FindBy(xpath = "//ul[@class='product_list grid row']/li[2]//a[@class='quick-view']/span")
    private ExtendedWebElement middleQuickViewButton;

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasSummerDressesText(WebDriver driver) {
        return driver.findElement(By.xpath("//p[text()='Catalog']")).isDisplayed();
    }

    public DressDetailPage clickQuickView() {
        middleQuickViewButton.click();
        return new DressDetailPage(driver);
    }

    public boolean hasIconProceedToCheckoutButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Proceed to checkout")));
        return driver.findElement(By.linkText("Proceed to checkout")).isDisplayed();
    }

    public DressesPage hoverBasket(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebElement basketHoverButton = driver.findElement(By.xpath("//b[contains(text(), 'Cart')]/.."));

        builder.moveToElement(basketHoverButton).perform();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CART_PRODUCT_QUANTITY_XPATH)));
        return new DressesPage(driver);
    }

    public String getCartProductQuantity(WebDriver driver) {
        return driver.findElement(By.xpath(CART_PRODUCT_QUANTITY_XPATH)).getText();
    }

    public boolean hasCorrectCartProductName(WebDriver driver, String titleName) {
        return driver.findElement(By.xpath("//a[@class='cart_block_product_name' and @title='" + titleName + "']")).isDisplayed();
    }


    public String getCartProductSizeAndColor(WebDriver driver) {
        return driver.findElement(By.xpath("//dt['cart_block_product_6_41_0']//*[@class='product-atributes']")).getText();
    }

    public String getCartProductPrice(WebDriver driver) {
        return driver.findElement(By.xpath("//dt['cart_block_product_6_41_0']//span[@class='price']")).getText();
    }

    public String getCartTotalPrice(WebDriver driver) {
        return driver.findElement(By.xpath("//span[@class='price cart_block_total ajax_block_cart_total']")).getText();
    }
}
