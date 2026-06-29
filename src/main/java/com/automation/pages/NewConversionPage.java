package com.automation.pages;

import com.automation.Base.BasePage;
import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewConversionPage extends BasePage {
    public NewConversionPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "(//span[contains(text(),'Completed')])[1]")
    WebElement dataSourceStatus;

    @FindBy(xpath = "//button[@title='Refresh']")
    WebElement refreshButton;

    @FindBy(xpath = "(//span)[16]")
    WebElement clickAskConversion;

    @FindBy(xpath = "//textarea[@id='question']")
    WebElement askQuestionTextBox;

    @FindBy(xpath = "//button[@title='Submit']")
    WebElement submitQuestion;

    public String getDataSourceStatus(){
        return waitUtil.getText(dataSourceStatus);
    }
    public void clickRefreshButton(){
        waitUtil.click(refreshButton);
    }
    public void clickAskConversion(){
        waitUtil.click(clickAskConversion);
    }
    public void AskConversion(String typeYourQuestion){
        waitUtil.type(askQuestionTextBox, typeYourQuestion);
        waitUtil.click(submitQuestion);
    }

}
