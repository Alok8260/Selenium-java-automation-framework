package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final WebDriverWait webDriverWait;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailId;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    public void login(String email, String pwd) {
        webDriverWait.until(ExpectedConditions.visibilityOf(emailId));
        emailId.clear();
        emailId.sendKeys(email);

        webDriverWait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pwd);

        webDriverWait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        submitBtn.click();
    }
}
