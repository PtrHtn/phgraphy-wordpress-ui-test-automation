package page_objects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

public class User {

    private final WebDriver driver = step_definitions.CucumberHooks.driver;
    private final WebDriverWait driverWait = step_definitions.CucumberHooks.driverWait;

    private final By headerImageLocator = By.id("header-image");


    public User user() { return this; }

    public void navigateTo(String url){
        driver.get(url);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(headerImageLocator));
    }

    public void canSeeHeaderImage() {
        Assertions.assertTrue(driver.findElement(headerImageLocator).isEnabled(),
                "\n\nUser can NOT see header image on the top of page!\n\n");
    }
}