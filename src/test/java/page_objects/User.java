package page_objects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User {

    private final WebDriver driver = step_definitions.CucumberHooks.driver;
    private final WebDriverWait driverWait = step_definitions.CucumberHooks.driverWait;

    private final By headerImageLocator = By.id("header-image");
    private final By cookiePolicyBarLocator = By.cssSelector("div[class='widget widget_eu_cookie_law_widget'] form");
    private final By buttonCloseAndAcceptLocator = By.cssSelector("input[value='Close and accept']");
    private final By allImagesInTheGalleryLocator = By.cssSelector("div[class='tiled-gallery type-rectangular'] div[class='gallery-group images-1']");
    private final By slideSelectedLocator = By.cssSelector("div[class='jp-carousel-slide selected']");
    private final By navigationBarLocator = By.id("nav");
    private final By pageTitleLocator =By.cssSelector("h2[class='page-title']");
    private By navigationBarButtonLocator(String buttonName){return By.xpath("//a[text()='" + buttonName + "']");}


    public User user() { return this; }

    public void navigateTo(String url){
        driver.get(url);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(headerImageLocator));
    }

    public void canSeeHeaderImage() {
        Assertions.assertTrue(driver.findElement(headerImageLocator).isEnabled(),
                "\n\nUser can NOT see header image on the top of page!\n\n");
    }

    public void canSeeCookiePolicyBar() {
        Assertions.assertTrue(driver.findElement(cookiePolicyBarLocator).isDisplayed(),
                "\n\nUser can NOT see Cookie Policy bar on the bottom of page!\n\n");
    }

    public void canSeeCookiePolicyText(String cookiePolicyText) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(cookiePolicyBarLocator));
        Assertions.assertTrue(driver.findElement(cookiePolicyBarLocator).getText().contains(cookiePolicyText),
                "\n\nCookie Policy text doesn't contain expected text!\n" +
                        "expected: " + cookiePolicyText + "\n" +
                        "actual:   " + driver.findElement(cookiePolicyBarLocator).getText() +"\n\n");
    }

    public void clickButtonCloseAndAccept() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(buttonCloseAndAcceptLocator));
        driver.findElement(buttonCloseAndAcceptLocator).click();
    }

    public void canNotSeeCookiePolicyBar() {
        driverWait.until(ExpectedConditions.invisibilityOfElementLocated(cookiePolicyBarLocator));
        Boolean isPresent = driver.findElements(cookiePolicyBarLocator).size() > 0;
        System.out.println(" > Is Cookie Policy bar Present? " + isPresent);
        Assertions.assertFalse(isPresent, "\n\nUser can see Cookie Policy bar on the bottom of page!\n\n");
    }

    public void clickOnTheFirstImageInTheGallery() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(allImagesInTheGalleryLocator));
        driver.findElement(allImagesInTheGalleryLocator).click();
    }

    public void canSeeImageIsDisplayedInHigherResolution() {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(slideSelectedLocator));
        Assertions.assertTrue(driver.findElement(slideSelectedLocator).isDisplayed(),
                "\n\nCarousel slide is not displayed!\n");
    }

    public void clicksOnTheTopBarButtonNamed(String buttonName) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(navigationBarLocator));
        driver.findElement(navigationBarButtonLocator(buttonName)).click();
    }

    public void canSeeTitleOfTheGalleryIs(String galleryTitle) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(pageTitleLocator));
        Assertions.assertTrue(driver.findElement(pageTitleLocator).getText().contains(galleryTitle),
                "\n\nPage title '" + galleryTitle + "' is not displayed!\n");
    }
}