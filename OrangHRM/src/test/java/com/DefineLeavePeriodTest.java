package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DefineLeavePeriodTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\selenium\\OrangHRM\\src\\main\\java\\org\\openqa\\selenium\\support\\ui\\ChromeDriver.java");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Navigate to the URL of the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Enter valid credentials to log in to the application
        driver.findElement(By.xpath("username")).sendKeys("Admin");
        driver.findElement(By.xpath("password")).sendKeys("admin123");
        driver.findElement(By.xpath("btnLogin")).click();

        // Navigate to the "Define Leave Period" page
        driver.findElement(By.xpath("menu_leave_viewLeaveModule")).click();
        driver.findElement(By.xpath("menu_leave_defineLeavePeriod")).click();
    }

    @DataProvider(name = "leavePeriodData")
    public Object[][] leavePeriodData() {
        return new Object[][] { { "2023-01-01", "2023-12-31" }, { "2024-01-01", "2024-12-31" } };
    }

    @Test(dataProvider = "leavePeriodData")
    public void testDefineLeavePeriod(String startDate, String endDate) {
        // Fill in the "Start Date" and "End Date" fields
        WebElement startDateField = driver.findElement(By.id("leaveperiod_txtStartDate"));
        startDateField.clear();
        startDateField.sendKeys(startDate);

        WebElement endDateField = driver.findElement(By.id("leaveperiod_txtEndDate"));
        endDateField.clear();
        endDateField.sendKeys(endDate);

        // Click on the "Save" button
        driver.findElement(By.id("btnSave")).click();

        // Wait for the success message to appear
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Verify that the success message appears
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='message success fadable']"));
        assert successMessage.isDisplayed();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }
}
