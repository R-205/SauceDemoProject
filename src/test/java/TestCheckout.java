import org.example.CheckoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestCheckout extends TestBase {
    CheckoutPage checkout;


    @DataProvider(name = "UserInformationInputs")
    public Object[][] checkoutData() {
        return new Object[][]{

                {"", "",""},
                {"", "ahmed",""},
                {"ali", "ahmed",""},
                {"ali", "ahmed","1234"}

        };
    }

    @Test(dataProvider = "UserInformationInputs" , priority = 1)
    public void CheckoutSteps(String firstname,String lastname , String postalcode) {
        driver.navigate().to("https://www.saucedemo.com/cart.html");
        checkout = new CheckoutPage(driver);
        checkout.checkoutButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkout.checkoutProcess(firstname,lastname,postalcode);
        checkout.continueButton();
//        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "URL did not match User information page.");
//        checkout.checkoutProcess(firstname,lastname,postalcode);
//        if (firstname.isEmpty() || lastname.isEmpty() || postalcode.isEmpty() ){
//            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html", " URL did not match expected page URL.");
//        } else if (firstname.equals("ali") && lastname.equals("ahmed") && postalcode.equals("1234")) {
//            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "URL did not match expected page URL.");
//        }


    }



    @Test(priority = 2)
    public void verifyTotalPrice(){
        checkout = new CheckoutPage(driver);
        String actualItemTotal = driver.findElement(By.xpath("//div[@class=\"summary_subtotal_label\"]")).getText();

        String expectedItemTotal = "119.94999999999999";
        Assert.assertTrue(actualItemTotal.contains(expectedItemTotal), "Item total is incorrect! Expected: $" + expectedItemTotal + " but found: " + actualItemTotal);

        System.out.println("Item total verification passed! Total: " + actualItemTotal);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void verifyCheckoutProcessDone(){
        checkout = new CheckoutPage(driver);
        checkout.finishButton();
        String actualText = driver.findElement(By.xpath("//h2[@class=\"complete-header\"]")).getText();
        String expectedText = "Thank you for your order!";
        Assert.assertTrue(actualText.contains(expectedText));
        System.out.println("successful checkout process");
        checkout.backHomeButton();

    }

    @Test(priority = 4)


    public void followUsLinks() {
        checkout = new CheckoutPage(driver);
        String originalTab = driver.getWindowHandle();
            // twitter
        checkout.verifyTwitterIcon();
        switchToNewTab(originalTab);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("x.com/saucelabs"));
        String twitterUrl = driver.getCurrentUrl();
        Assert.assertTrue(twitterUrl.contains("https://x.com/saucelabs"));
        driver.close();
        driver.switchTo().window(originalTab);


        //facebook
        checkout.verifyFacebookIcon();

        switchToNewTab(originalTab);

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlContains("facebook.com/saucelabs"));
        String facebookUrl = driver.getCurrentUrl();
//        Assert.assertTrue(facebookUrl.contains("https://facebook.com/saucelabs"));
        Assert.assertTrue(facebookUrl.contains("facebook"));

        driver.close();
        driver.switchTo().window(originalTab);


//        //linked in
        checkout.verifyLinkedinIcon();

        switchToNewTab(originalTab);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait2.until(ExpectedConditions.urlContains("linkedin.com/company/sauce-labs"));
        String linkedinUrl = driver.getCurrentUrl();
//        Assert.assertTrue(linkedinUrl.contains("linkedin"));
        Assert.assertTrue(linkedinUrl.contains("linkedin"));

        driver.close();
        driver.switchTo().window(originalTab);


//
   }

    private void switchToNewTab(String originalTab) {
        // الحصول على جميع معرفات علامات التبويب المفتوحة
        Set<String> allTabs = driver.getWindowHandles();

        for (String handle : allTabs) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}










