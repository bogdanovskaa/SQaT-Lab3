import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ss.LoginPage;
import ss.ProductPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Testing{

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }




    @Test
    public void Test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("Test1", "Test2");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "");


    }
    @Test
    //SMENI GO IMETO
    public void Test2() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "123456789");
        String errorMessage = loginPage.getErrorMessage();
        assertEquals(errorMessage, "");


    }

@Test
public void SuccessfulLogIn(){
    driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");

    final WebElement username = driver.findElement(By.id("username"));
    final WebElement password = driver.findElement(By.id("password"));
    final WebElement login = driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button"));

    username.sendKeys("bogdanovskaanastasija@gmail.com");
    //It works
    password.sendKeys("");

    login.click();
}

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Win10 Creator/Desktop/Homework3/src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
