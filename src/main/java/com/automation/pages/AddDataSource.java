package com.automation.pages;

import com.automation.utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddDataSource{
    private WebDriver driver;
    private WaitUtil waitUtil;
    public AddDataSource(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitUtil=new WaitUtil(driver);
    }
    //This is click the home page datasource
    @FindBy(xpath = "(//li[@class='step-2'])[1]")
    WebElement addHDatasourceBtn;

    //This is click the data source in the data source list page
    @FindBy(xpath = "//button[@title='Add Data Source']")
    WebElement addDatasourceBtn;

    //Set the data source Name
    @FindBy(xpath = "//input[@name='name']")
    WebElement datasourceName;

    //Select the data source type
    @FindBy(xpath = "//div[contains(text(),'MySQL')]")
    WebElement dataSourceType;

    //Enter the host
    @FindBy(xpath = "//input[@placeholder='Host']")
    WebElement dataSourceHost;

    //Enter db user name
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement dbUserName;

    //Enter db password
    @FindBy(xpath = "//input[@id='password']")
    WebElement dbPass;

    //Enter db name
    @FindBy(xpath = "//input[@id='database_name']")
    WebElement dbName;

    //Click the test connection
    @FindBy(xpath = "//button[normalize-space()='Test Connection']")
    WebElement testConnection;

    @FindBy(xpath = "//span[text()='Test Connection Successful!']")
    WebElement isTestConnection;

    //click save button
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;

    public void setupDatasource(String sourceName, String host, String dbUser, String pass, String yourDbName) throws InterruptedException {
        Thread.sleep(10000);
       waitUtil.click(addHDatasourceBtn);

       waitUtil.click(addDatasourceBtn);

       waitUtil.type(datasourceName, sourceName);

        waitUtil.click(dataSourceType);

        waitUtil.type(dataSourceHost, host);

        waitUtil.type(dbUserName, dbUser);

        waitUtil.type(dbPass, pass);

        waitUtil.type(dbName, yourDbName);

       waitUtil.click(testConnection);

        if (waitUtil.isTextPresent(isTestConnection, "Test Connection Successful!")) {
            waitUtil.click(saveBtn);
        } else {
            throw new RuntimeException("Connection failed: " +
                    waitUtil.getText(isTestConnection));
        }
    }

}
