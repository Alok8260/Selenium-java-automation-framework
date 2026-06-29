package com.automation.Base;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected WaitUtil waitUtil;
    public BasePage(WebDriver driver){
        this.driver=driver;
        this.waitUtil=new WaitUtil(driver);
        PageFactory.initElements(driver, this);
    }
}
