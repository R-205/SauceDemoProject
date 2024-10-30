import org.example.ProductPage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestProduct extends TestBase {

    ProductPage product;


    @DataProvider(name = "sortOptions")
    public Object[][] createSortOptions() {
        return new Object[][]{
                {"Name (A to Z)"},
                {"Name (Z to A)"},
                {"Price (low to high)"},
                {"Price (high to low)"}
        };
    }

        @Test(dataProvider = "sortOptions",priority = 1)
        public void selectOptionFromdropDown (String option){
        product = new ProductPage(driver);
        product.selectOptionFromDropdown(option);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

    @DataProvider(name = "productDataProvider")
    public Object[][] productDataProvider() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
        };
    }

        @Test(dataProvider = "productDataProvider",priority = 2)
        public void testProductDetails (String productName) {
            product = new ProductPage(driver);
            Assert.assertTrue(product.isAddToCartButtonDisplayed(), "Add to Cart button is not displayed!");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    @DataProvider(name = "productNames")
    public Object[][] createProductNames() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"}
        };
    }

    @Test(dataProvider = "productNames", priority = 3)
    public void testAddToCart (String productName){
        product = new ProductPage(driver);
        product.AddToCart(productName);
        product.goToCart();
        WebElement productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
        Assert.assertNotNull(productInCart, "Product not found in cart: " + productName);
        product.continueShopping();
   }



        @Test(priority = 4)
    public void testAddProductsToCart() {
        product = new ProductPage(driver);
        product.addProductsToCart();
        product.goToCart();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 5)
    public void testRemoveProduct (){

        product = new ProductPage(driver);
        product.removeProduct();
        String productName = "Sauce Labs Bike Light";
        try {
            WebElement productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()='" + productName + "']"));
            Assert.fail("Product is still present in the cart: "+ productName);
        } catch (NoSuchElementException e) {
            System.out.println("Product has been successfully removed from the cart.");
        }
    }


//    @Test(priority = 6)
//    public void verifyCartTotalPrice() {
//
//        WebElement itemPriceElement = driver.findElement(By.className("inventory_item_price"));
//        String itemPriceText = itemPriceElement.getText().replace("$", ""); // إزالة رمز الدولار
//        double itemPrice = Double.parseDouble(itemPriceText);
//
//        WebElement totalPriceElement = driver.findElement(By.className("summary_total_label"));
//        String totalPriceText = totalPriceElement.getText().replace("Total: $", ""); // إزالة النص الإضافي
//        double totalPrice = Double.parseDouble(totalPriceText);
//
//        // تحقق من أن السعر الإجمالي يطابق سعر المنتج
//        Assert.assertEquals(totalPrice, itemPrice, "Total price does not match the item price.");
//    }





//    @Test(priority = 6)
//    public void verifyCartTotalPrice() {
//        product = new ProductPage(driver);
//        product.goToCart();
//
//        String actualTotalPrice = driver.findElement(By.className("summary_total_label")).getText();
//        String expectedTotalPrice = "119.95";
//
//        Assert.assertTrue(actualTotalPrice.contains(expectedTotalPrice), "Total price is incorrect! Expected: $" + expectedTotalPrice + " but found: " + actualTotalPrice);
//
//        System.out.println("Cart total price verification passed! Total: " + actualTotalPrice);
//    }




}


