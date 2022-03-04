package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.Main.chromeDriver;
import static org.junit.Assert.assertEquals;

public class TablePageTest {
    private WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup(){
        driver = chromeDriver();
        driver.get("http://localhost:8082/");
        WebElement tableLink  =driver.findElement(By.id("tableLink"));
        tableLink.click();
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void test_table(){
        WebElement element = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));
        assertEquals("Table 2 Row 1", element.getText());
    }
    }

