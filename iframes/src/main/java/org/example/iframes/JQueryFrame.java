package org.example.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class JQueryFrame {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        //find out how many frames on that page
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        //driver.findElement(By.id("draggable")).click();
        Actions actions = new Actions(driver);
        WebElement source  = driver.findElement(By.id("draggable"));
        WebElement target  = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).build().perform();
        driver.close();
    }
}
