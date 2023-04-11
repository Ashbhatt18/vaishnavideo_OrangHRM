package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.firefoxDriver;

import org.openqa.selenium.support.PageFactory;

import com.pages.FindBy;

public class loginpage {
    WebDriver driver;
    
    @FindBy(name = "username")
    WebElement username;
    
    @FindBy(name = "password")
    WebElement password;
    
    @FindBy(name = "btnLogin")
    WebElement loginButton;
    
    public loginpage(firefoxDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void loginage(firefoxDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	public void LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        loginButton.click();
    }
}