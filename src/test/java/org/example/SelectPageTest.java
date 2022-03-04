package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.example.Main.chromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SelectPageTest {
    private WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup(){
        driver = chromeDriver();
        driver.get("http://localhost:8082/");
        WebElement selectLink  =driver.findElement(By.id("selectLink"));
        selectLink.click();
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void select_maybe_from_select_box(){
        WebElement selectElement =driver.findElement(By.id("select1"));
        Select select =new Select(selectElement);
        select.selectByValue("maybe");
        assertEquals("maybe",selectElement.getAttribute("value"));
    }
}
