package org.example.scope;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Link {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "c:\\selenium-drivers\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // count links on the page
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        // count link in footer only
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //count links of first column
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        int number = columnDriver.findElements(By.tagName("a")).size();
        System.out.println(number);

        //click on each link and check if the pages are opening
        for (int i = 1; i < number; i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }

        Set<String> set = driver.getWindowHandles();
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
    }
}
