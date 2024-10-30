package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement UsernameField(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        // return driver.findElement(By.id("user-name"));
        return  userNameField;
    }
    public WebElement PasswordField(){


        return driver.findElement(By.id("password"));
    }
    public WebElement LoginButton(){


        return driver.findElement(By.name("login-button"));
    }

    public void loginSteps(String username,String password){
        UsernameField().sendKeys(username);
        PasswordField().sendKeys(password);
        LoginButton().click();

    }

}