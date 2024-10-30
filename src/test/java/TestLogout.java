import org.example.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLogout extends TestBase{
    LogoutPage logout;


    @Test
    public void logoutProcess(){
        logout = new LogoutPage(driver);
        logout.openTopMenu();
        logout.logoutAction();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
