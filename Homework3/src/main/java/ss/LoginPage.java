package ss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(5000);
       // driver.findElement(By.cssSelector("[value=\"#organic-div > form > div.login__form_action_container > button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"organic-div\"]/form/div[3]/button"));
        Thread.sleep(5000);


    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.xpath("//*[@id=\"error-for-username\"]"));
        return errorPage.getText();
    }
}

