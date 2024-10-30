package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

        public void checkoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"checkout\"]")));
        checkoutBtn.click();

    }


    public void checkoutProcess(String firstname,String lastname , String postalcode){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
        WebElement lNameField = driver.findElement(By.id("last-name"));
        WebElement postalField = driver.findElement(By.id("postal-code"));
        fNameField.sendKeys(firstname);
        lNameField.sendKeys(lastname);
        postalField.sendKeys(postalcode);
    }

    public void continueButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"continue\"]")));
        continueBtn.click();
    }

    public void finishButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        finishBtn.click();

    }

    public void backHomeButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backHomeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("back-to-products")));
        backHomeBtn.click();
    }

    public void verifyTwitterIcon(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement twitterIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='social_twitter']/a")));
        twitterIcon.click();

    }
    public void verifyFacebookIcon(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement facebookIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='social_facebook']/a")));
        facebookIcon.click();

    }

    public void verifyLinkedinIcon(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkedinIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='social_linkedin']/a")));
        linkedinIcon.click();

    }






}
