package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.CucumberHooks;

public class User {

    private final WebDriver driver = step_definitions.CucumberHooks.driver;
    private final WebDriverWait driverWait = step_definitions.CucumberHooks.driverWait;

}