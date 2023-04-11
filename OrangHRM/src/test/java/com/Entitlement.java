package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Entitlement {
	
	
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
	        driver.findElement(By.xpath("username")).sendKeys("your-username");
	        driver.findElement(By.xpath("password")).sendKeys("your-password");
	        driver.findElement(By.xpath("btnLogin")).click();

	        // Click on the "Leave" option in the left panel
	        driver.findElement(By.id("menu_leave_viewLeaveModule")).click();

	        // Select "Entitlements" from the "Leave" menu
	        driver.findElement(By.id("menu_leave_Entitlements")).click();

	        // Click on the "Add Entitlements" button
	        driver.findElement(By.id("entitlements_addBtn")).click();

	        // Select a leave type by clicking on the radio button next to it
	        driver.findElement(By.id("entitlements_leave_type")).click();

	        // Fill out the required information, including the employee name, entitlement amount, and validity period
	        driver.findElement(By.id("entitlements_employee_empName")).sendKeys("deo");
	        driver.findElement(By.id("entitlements_entitlement")).sendKeys("20");
	        driver.findElement(By.id("entitlements_validityStartDate")).sendKeys("2023-04-11");
	        driver.findElement(By.id("entitlements_validityEndDate")).sendKeys("2024-04-11");

	        // Click on the "Save" button to apply the entitlement
	        driver.findElement(By.id("btnSave")).click();

	        // Verify that the entitlement has been added successfully
	        String successMessage = driver.findElement(By.id("entitlements_resultTable")).getText();
	        Assert.assertTrue(successMessage.contains("Entitlement assigned successfully"));
	    }

	}

