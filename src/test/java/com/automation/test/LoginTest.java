package com.automation.test;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
        LoginPage loginPage;

        @BeforeClass
        public void setUpPage() {
            loginPage = new LoginPage(driver);  // driver comes from BaseTest
        }

        @Test(groups="Login")
        public void testValidLogin() {
            loginPage.login(
                    properties.getProperty("username"),  // from config.properties
                    properties.getProperty("password")   // from config.properties
            );
        }

//        @Test
//        public void testInvalidLogin() {
//            loginPage.login("wrong@email.com", "wrongPass");
//            // add assertion here
//        }
}
