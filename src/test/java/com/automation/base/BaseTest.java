package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected static Properties properties;

    @BeforeSuite
    public static void loadConfig() throws IOException {
        properties = new Properties();
        try (FileInputStream file = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(file);
        }
    }

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("appUrl"));
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
