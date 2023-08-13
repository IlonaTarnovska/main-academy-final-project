package org.selenide.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.selenide.BasePage.getDriver;

public class WaitHelper {

    private static final WebDriverWait wait = getWait(5);

    public static WebElement visibility(WebElement element) {
        wait(wait, ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement invisibility(WebElement element) {
        wait(wait, ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement clickable(WebElement element) {
        wait(wait, ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement visibility(WebElement element, int durationSeconds) {
        wait(getWait(durationSeconds), ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement invisibility(WebElement element, int durationSeconds) {
        wait(getWait(durationSeconds), ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement clickable(WebElement element, int durationSeconds) {
        wait(getWait(durationSeconds), ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    private static WebDriverWait getWait(int durationSeconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(durationSeconds));
    }

    private static <T> void wait(WebDriverWait wait, ExpectedCondition<T> webElementExpectedCondition) {
        try {
            wait.until(webElementExpectedCondition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
