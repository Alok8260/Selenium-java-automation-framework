package com.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

        private WebDriver driver;
        private WebDriverWait wait;

        public  WaitUtil(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        public void type(WebElement element, String text) {
            wait.until(ExpectedConditions.visibilityOf(element));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            element.clear();
            element.sendKeys(text);
        }

        public void click(WebElement element) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            element.click();
        }
    public String getText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    public boolean isTextPresent(WebElement element, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
        return element.getText().trim().equalsIgnoreCase(expectedText);
    }
}
