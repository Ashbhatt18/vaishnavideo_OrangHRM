package com;


import org.openqa.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.pages.AfterMethod;
import com.pages.BeforeMethod;
import com.pages.Test;


public class LeaveListTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path for the chromedriver executable file
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Navigate to the Leave List page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewLeaveList");
    }

    @Test
    public void testLeaveListSearch() {
        // Find the elements for the various input fields and enter the desired data
        WebElement employeeNameField = driver.findElement(By.id("leaveList_txtEmployee_empName"));
        employeeNameField.sendKeys("John Doe");

        WebElement dateFromField = driver.findElement(By.id("calFromDate"));
        dateFromField.sendKeys("2023-04-01");

        WebElement dateToField = driver.findElement(By.id("calToDate"));
        dateToField.sendKeys("2023-04-30");

        // Find the "Search" button and click it
        WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();

        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultTable")));

        // Assert that the search results contain the expected data
        WebElement resultTable = driver.findElement(By.id("resultTable"));
        String expectedData = "John Doe";
        Assert.assertTrue(resultTable.getText().contains(expectedData), "Data not found in search results.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
