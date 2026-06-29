package com.automation.pages;

import com.automation.Base.BasePage;
import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailId;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    public void login(String email, String pwd) {
        waitUtil.type(emailId, email);
        waitUtil.type(password, pwd);
        waitUtil.click(submitBtn);

    }
}
