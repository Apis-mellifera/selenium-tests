package org.example.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.close();
    }
}
