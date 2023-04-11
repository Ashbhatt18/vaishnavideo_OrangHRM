package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRMLeaveListTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up the driver
        System.setProperty("webdriver.chrome.driver", "/OrangHRM/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
        // Log in to the website
        WebElement username = driver.findElement(By.id("txtUsername"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @Test
    public void testFillDataAndReset() {
        // Click on the Leave tab
        WebElement leaveTab = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveTab.click();
        
        // Click on the Leave List submenu
        WebElement leaveListSubMenu = driver.findElement(By.id("menu_leave_viewLeaveList"));
        leaveListSubMenu.click();
        
        // Fill the data
        WebElement employeeName = driver.findElement(By.id("leaveList_txtEmployee_empName"));
        employeeName.sendKeys("John Smith");
        WebElement leaveType = driver.findElement(By.id("leaveList_cmbSubunit"));
        leaveType.sendKeys("Annual Leave");
        WebElement leaveStatus = driver.findElement(By.id("leaveList_cmbWithTerminated"));
        leaveStatus.sendKeys("All");
        WebElement fromDate = driver.findElement(By.id("calFromDate"));
        fromDate.sendKeys("2023-04-01");
        WebElement toDate = driver.findElement(By.id("calToDate"));
        toDate.sendKeys("2023-04-30");
        WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();
        
        // Reset the data
        WebElement resetButton = driver.findElement(By.id("btnReset"));
        resetButton.click();
    }

    @AfterMethod
    public void tearDown() {
        // Quit the driver
        driver.quit();
    }
}