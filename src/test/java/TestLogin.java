import org.example.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    //  WebDriver driver= null;
    LoginPage login;
    private boolean isSuccessExpected;


    //Bad scenario
    @DataProvider(name = "InvalidloginCredentials")
    public Object[][] invalidloginData() {
        return new Object[][]{
                {"media_ss", "secret_sauce"},
                {"standard_user", "Tests"},
                {"secret_sauce", "secret_sauce"},
                {"", "secret_sauce"},
                {"",""},
                {"standard_user", ""},
                {"standard_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "InvalidloginCredentials")
    public void invalidLoginSteps(String username, String password) {
        driver.navigate().to("https://www.saucedemo.com/");
        login = new LoginPage(driver);

        login.loginSteps(username, password);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Happy scenario
    @DataProvider(name = "ValidLoginCredentials")
    public Object[][] validLoginData() {
        return new Object[][]{
                {"visual_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"standard_user", "secret_sauce"}
        };
    }


    @Test(dataProvider = "ValidLoginCredentials")


    public void validLoginSteps(String username, String password) {
        driver.navigate().to("https://www.saucedemo.com/");
        login = new LoginPage(driver);
        login.loginSteps(username, password);
        WebElement prodPageElement = driver.findElement(By.xpath("//span[@data-test=\"title\"]"));
        Assert.assertTrue(prodPageElement.isDisplayed(), "Products");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

