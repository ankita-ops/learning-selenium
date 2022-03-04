package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Main {

    public static void main(String[] args) {

        WebDriver driver = chromeDriver();

        // testGoogle(driver);
        testSeleniumDev(driver);
    }

    private static void testGoogle(WebDriver driver) {
        driver.get("http://google.com");

        // document.getElementsByName("q")[0]
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        // document.getElementsByName("q")[0].value = "Selenium Testing"
        searchBox.sendKeys("Selenium Testing");
        searchBox.sendKeys(Keys.ENTER);
    }

    public static void testSeleniumDev(WebDriver driver) {
        driver.get("https://selenium.dev");
        WebElement blog =driver.findElement(By.linkText("Blog"));
        blog.click();
        WebElement link2016 =driver.findElement(By.id("m-blog2016"));
        link2016.click();
        WebElement element =driver.findElement(By.linkText("Fall Selenium Conf, Save the Date & Call for Speakers!"));
        element.click();

        driver.quit();
        driver.close();

    }


    public static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver chromeDriver() {

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}

