package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myLeave {
	private WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "/OrangHRM/chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Navigate to the URL of the application
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void testScenario() {
        // Enter valid credentials to log in to the application
        driver.findElement(By.xpath("username")).sendKeys("Admin");
        driver.findElement(By.xpath("password")).sendKeys("admin123");
        driver.findElement(By.xpath("btnLogin")).click();

        // Click on the "Leave" option in the left panel
        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();

        // Select "Entitlements" from the "Leave" menu
        driver.findElement(By.id("menu_leave_Entitlements")).click();

        // Click on the "View Leave Entitlements" option
        driver.findElement(By.id("menu_leave_viewLeaveEntitlements")).click();

        // Select a leave type
        Select leaveTypeSelect = new Select(driver.findElement(By.id("entitlements_leave_type")));
        leaveTypeSelect.selectByVisibleText("Vacation US");

        // Select a leave period
        Select leavePeriodSelect = new Select(driver.findElement(By.id("period")));
        leavePeriodSelect.selectByVisibleText("2023-01-01 - 2023-12-31");

        // Click on the "Search" button
        driver.findElement(By.id("searchBtn")).click();

        // Verify that the entitlement appears in the search results
        String searchResults = driver.findElement(By.id("resultTable")).getText();
        Assert.assertTrue(searchResults.contains("Vacation US"));
        Assert.assertTrue(searchResults.contains("2023-01-01 - 2023-12-31"));
    }

    @AfterTest
    public void teardown() {
        // Close the browser window
        driver.quit();
    }
}

