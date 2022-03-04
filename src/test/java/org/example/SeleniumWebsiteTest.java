package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SeleniumWebsiteTest {

    private WebDriver driver;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://selenium.dev");
        WebElement blog = driver.findElement(By.linkText("Blog"));
        blog.click();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test_selenium_dot_dev_blog_2016_page() {
        WebElement link2016 = driver.findElement(By.id("m-blog2016"));
        link2016.click();

        WebElement element = driver.findElement(By.linkText("Fall Selenium Conf, Save the Date & Call for Speakers!"));
        assertEquals("Fall Selenium Conf, Save the Date & Call for Speakers!", element.getText());

        String title = driver.getTitle();
        assertEquals("Blog Posts - 2016 | Selenium", title);
    }

    @Test
    public void test_selenium_dot_dev_blog_2017_page() {
        WebElement link2017 = driver.findElement(By.id("m-blog2017"));
        link2017.click();

        String title = driver.getTitle();
        assertEquals("Blog Posts - 2017 | Selenium", title);
    }

}

