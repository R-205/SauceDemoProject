package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;


    public LogoutPage(WebDriver driver)
    {this.driver=driver;}

    public void openTopMenu(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement topMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
        topMenuBtn.click();
    }

    public void logoutAction(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"logout_sidebar_link\"]")));
        logoutBtn.click();
    }







}
