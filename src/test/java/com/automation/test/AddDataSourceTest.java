package com.automation.test;

import com.automation.base.BaseTest;
import com.automation.pages.AddDataSource;
import com.automation.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddDataSourceTest extends BaseTest {
    AddDataSource dataSource;
    @BeforeClass
    public void setUpPage() {
        dataSource = new AddDataSource(driver);  // driver comes from BaseTest
    }
    @Test(
            groups ="datasource",
            dependsOnGroups="Login"
    )
    public void addDataSource() throws InterruptedException {
        dataSource.setupDatasource(
                properties.getProperty("sourceName"),
               properties.getProperty("host"),
                //properties.getProperty("port"),
                properties.getProperty("user"),
                properties.getProperty("dbpassword"),
                properties.getProperty("database")
        );
    }
}
