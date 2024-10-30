package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    public void selectOptionFromDropdown(String optionText) {
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionText);

    }


    public void ProductDetailsPage(String productName){
        WebElement product = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        product.click();

    }
    public boolean isAddToCartButtonDisplayed() {
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        return addToCartButton.isDisplayed();
    }



    public void AddToCart(String productName){
//        WebElement addProToCart = driver.findElement(By.xpath("//div[text()='" + productName + "']//following::button[text()='Add to cart']"));
//        addProToCart.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String xpath = "//div[text()='" + productName + "']//following::button[text()='Add to cart']";
        WebElement addProToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        addProToCart.click();
    }

    public void goToCart() {
        WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
        cartButton.click();
    }

    public void continueShopping() {
        WebElement continueButton = driver.findElement(By.id("continue-shopping"));
        continueButton.click();
    }

    public void removeProduct(){
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        removeButton.click();
    }

    public void addProductsToCart() {
        List<WebElement> addToCartButtons = driver.findElements(By.cssSelector("[name^='add-to-cart']"));

        for (WebElement button : addToCartButtons) {
            button.click();
        }
    }





}
