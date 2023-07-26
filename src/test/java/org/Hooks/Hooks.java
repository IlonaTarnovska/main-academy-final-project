package org.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenide.BasePage;
import java.time.Duration;

public class Hooks {

    @Before
    public void createDriver () {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        BasePage.setDriverThreadLocal(driver);
    }


    @After
    public void quiteDriver() {
        BasePage.getDriver().quit();
    }

}