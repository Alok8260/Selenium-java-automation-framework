package com.automation.test;

import com.automation.base.BaseTest;
import com.automation.pages.NewConversionPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewConversationTest extends BaseTest {
    NewConversionPage newConversionPage;
    @BeforeClass
    public void setUpPage() {
        newConversionPage = new NewConversionPage(driver);  // driver comes from BaseTest
    }
    @Test(
            groups = "newConversion",
            dependsOnGroups="datasource"
    )
    public void newConversion() throws InterruptedException {
        int maxAttempt=Integer.parseInt(properties.getProperty("maxAttempts"));
        Thread.sleep(20000);
        for(int i = 0; i < maxAttempt; i++) {
            String statusMessage=newConversionPage.getDataSourceStatus();
            if(statusMessage.equalsIgnoreCase(properties.getProperty("data_Source_Status"))){
                newConversionPage.clickAskConversion();
                Thread.sleep(10000);
                newConversionPage.AskConversion(properties.getProperty("askQuestion"));
                Thread.sleep(10000);
                return;
            }else {
                Thread.sleep(5000);
                newConversionPage.clickRefreshButton();
            }
        }
        throw new RuntimeException("Data Source status did not become Completed.");
    }
}
