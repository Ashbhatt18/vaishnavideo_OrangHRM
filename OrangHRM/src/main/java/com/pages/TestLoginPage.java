package com.pages;

import org.openqa.selenium.firefox.firefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;


public class TestLoginPage {
    firefoxDriver driver;
    
    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new firefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
    
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    
    @Test
    public void testLogin() {
        loginpage loginPage = new loginpage(driver);
        loginPage.login("Admin", "admin123");
        
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        String actualUrl = driver.getCurrentUrl();
        
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}

