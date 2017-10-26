package pft.module;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SampleTestSubmitRequest {
    private ChromeDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void sampleTestSubmitRequest() {
        wd.get("http://www.acams.org/");
        wd.findElement(By.linkText("×")).click();
        wd.findElement(By.xpath("//li[@id='menu-item-14798']//a[.='Contact Us']")).click();
        wd.findElement(By.id("input_223_23")).click();
        wd.findElement(By.id("input_223_23")).clear();
        wd.findElement(By.id("input_223_23")).sendKeys("Name");
        wd.findElement(By.id("input_223_2")).click();
        wd.findElement(By.id("input_223_2")).clear();
        wd.findElement(By.id("input_223_2")).sendKeys("name@email.com");
        wd.findElement(By.id("input_223_40")).click();
        wd.findElement(By.id("input_223_40")).clear();
        wd.findElement(By.id("input_223_40")).sendKeys("123-456-789");
        wd.findElement(By.id("input_223_27")).click();
        wd.findElement(By.id("input_223_27")).clear();
        wd.findElement(By.id("input_223_27")).sendKeys("AnyComapny");
        if (!wd.findElement(By.xpath("//select[@id='input_223_20']//option[4]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='input_223_20']//option[4]")).click();
        }
        if (!wd.findElement(By.xpath("//select[@id='input_223_21']//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//select[@id='input_223_21']//option[7]")).click();
        }
        wd.findElement(By.id("input_223_6")).click();
        wd.findElement(By.id("input_223_6")).clear();
        wd.findElement(By.id("input_223_6")).sendKeys("Sample inquiry");
        wd.findElement(By.id("gform_submit_button_223")).click();
        if (!wd.findElement(By.tagName("html")).getText().contains("Thank you for submitting your inquiry.")) {
            System.out.println("verifyTextPresent failed");
        }
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
