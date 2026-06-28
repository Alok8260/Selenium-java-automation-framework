package com.automation.test;

import com.automation.base.BaseTest;
import com.automation.pages.AskYourDatabasePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AskYourDatabaseTest extends BaseTest {
    AskYourDatabasePage dataSource;
    @BeforeClass
    public void setUpPage() {
        dataSource = new AskYourDatabasePage(driver);  // driver comes from BaseTest
    }
    @Test(
            groups ="datasource",
            dependsOnGroups="Login"
    )
    public void addDataSource() throws InterruptedException {
        dataSource.clickDatasource();
        dataSource.enterDatasourceName("sourceName");
        dataSource.selectDatasourceType();
        dataSource.enterDatabaseCredentials(
               properties.getProperty("host"),
                //properties.getProperty("port"),
                properties.getProperty("user"),
                properties.getProperty("dbpassword"),
                properties.getProperty("database")
        );
        dataSource.clickTestConnection();
        String verifyTestConnection= dataSource.connectionStatusMessage();
        Assert.assertEquals(verifyTestConnection, properties.getProperty("testConnectionMsg"));
        dataSource.clickSave();

        String verifySucessMsg= dataSource.getSuccessMessage();
        Assert.assertEquals(verifySucessMsg, properties.getProperty("sucessMessage"));
    }
}
