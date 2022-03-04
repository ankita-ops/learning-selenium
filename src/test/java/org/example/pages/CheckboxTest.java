package org.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckboxTest {

    private WebDriver driver;
    HomePage home;

    @BeforeClass
    public static void init() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        home = new HomePage(driver);
        home.navigate();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void test_lettuce_checkbox_selected() {
        home.navigateToRadioPage();
    }


}

