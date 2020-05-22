package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends APAbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DressesPage hoverClickSummerDresses(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebElement womenHoverButton = driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
        builder.moveToElement(womenHoverButton).perform();

        By locator = By.linkText("Summer Dresses");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.findElement(locator).click();
        return new DressesPage(driver);
    }
}
