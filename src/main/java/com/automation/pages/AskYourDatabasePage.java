package com.automation.pages;

import com.automation.Base.BasePage;
import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AskYourDatabasePage extends BasePage {
    public AskYourDatabasePage(WebDriver driver){
        super(driver);
    }
    //This is click the home page datasource
    @FindBy(xpath = "(//li[@class='step-2'])[1]")
    private WebElement addHDatasourceBtn;

    //This is click the data source in the data source list page
    @FindBy(xpath = "//button[@title='Add Data Source']")
    private WebElement addDatasourceBtn;

    //Set the data source Name
    @FindBy(xpath = "//input[@name='name']")
   private WebElement datasourceName;

    //Select the data source type
    @FindBy(xpath = "//div[contains(text(),'MySQL')]")
    private WebElement dataSourceType;

    //Enter the host
    @FindBy(xpath = "//input[@placeholder='Host']")
    private WebElement dataSourceHost;

    //Enter db user name
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement dbUserName;

    //Enter db password
    @FindBy(xpath = "//input[@id='password']")
    private WebElement dbPass;

    //Enter db name
    @FindBy(xpath = "//input[@id='database_name']")
    private WebElement dbName;

    //Click the test connection
    @FindBy(xpath = "//button[normalize-space()='Test Connection']")
    private WebElement testConnection;

    @FindBy(xpath = "//span[text()='Test Connection Successful!']")
    private WebElement getTestConnectionMsg;

    //click save button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@aria-label='Data Source created successfully.']")
    private WebElement verifyMsg;

    public void clickDatasource(){
        waitUtil.scrollToBottom();
        waitUtil.click(addHDatasourceBtn);

        waitUtil.click(addDatasourceBtn);
    }
    public void enterDatasourceName(String sourceName){
        waitUtil.type(datasourceName, sourceName);
    }
    public void selectDatasourceType(){
        waitUtil.click(dataSourceType);
    }
    public void enterDatabaseCredentials(String host, String dbUser, String pass, String yourDbName) throws InterruptedException {
        waitUtil.scrollToBottom();
        waitUtil.type(dataSourceHost, host);
        waitUtil.type(dbUserName, dbUser);
        waitUtil.type(dbPass, pass);
        waitUtil.type(dbName, yourDbName);
    }
    public void clickTestConnection() {
        waitUtil.click(testConnection);
    }
    public String connectionStatusMessage(){
            return waitUtil.getText(getTestConnectionMsg);
    }
    public void clickSave(){
        waitUtil.click(saveBtn);
    }
    public String getSuccessMessage(){
        return waitUtil.getText(verifyMsg);
    }

}
