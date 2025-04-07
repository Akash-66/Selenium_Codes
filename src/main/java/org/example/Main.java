package org.example;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, IOException {
        //testSwiggy();
        //brokenUrlValidation();
        //openNewWindow();
        //brokenImageValidation();
        //implicitWaitExample();
        //explicitWaitExample();
        fluentWaitExample();
    }

    public static void testSwiggy() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/restaurants");
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@class=\"sc-bXCLTC jRHowI\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div/div[2]/div[2]/div/h1")).sendKeys(Keys.PAGE_DOWN);
        driver.findElement(By.xpath("//div[@class=\"sc-toTrN gbuNhD\"]/child::div[2]/div/div/div/div[1]/div/button[2]")).click();
        //river.findElement(By.xpath("//a[@class=\"_3nTR3\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"sc-bLqSdX kJctoR\"]/div[2]/div")).click();
        Thread.sleep(2000);
        driver.quit();
    }
    public static void brokenUrlValidation() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/restaurants");
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));

        for(WebElement element : webElementList) {
            String urlData = element.getAttribute("href");
            //System.out.println(urlData);
            try {
                URL url = new URL(urlData);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() >= 200)
                    System.out.println("URL is working: " + urlData);
                else
                    System.out.println("URL is broken: " + urlData);
            } catch (Exception e) {
                //System.out.println(e);
            }
        }
        driver.quit();
    }

    public static void openNewWindow()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        String originalTab = driver.getWindowHandle();
        System.out.println(originalTab);
        driver.get("https://www.swiggy.com/restaurants");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for(String actual: handles)
        {
            if(!actual.equalsIgnoreCase(originalTab))
            {
                driver.switchTo().window(actual);
                driver.get("https://www.zomato.com/");
            }
        }
        driver.quit();
    }

    static void brokenImageValidation() throws IOException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.swiggy.com/restaurants");
        List<WebElement> webElementList = driver.findElements(By.tagName("img"));
        for(WebElement element:webElementList)
        {
            String urlData = element.getAttribute("src");
            try {
                URL url = new URL(urlData);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                if(httpURLConnection.getResponseCode()!=200)
                    System.out.println("Image is broken: "+urlData);
                else
                    System.out.println("Image is fine:"+urlData);


            } catch (MalformedURLException e) {
                //throw new RuntimeException(e);
            }
        }
        driver.quit();
    }
    static void implicitWaitExample()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.swiggy.com/restaurants");
        driver.quit();
    }

    static void explicitWaitExample() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/Akash-66");
        WebDriverWait webDriverWait = new WebDriverWait(driver,30);
        String title = driver.getTitle();
        webDriverWait.until(ExpectedConditions.titleIs(title));
        driver.findElement(By.xpath("//following::div[@class=\"Box pinned-item-list-item d-flex p-3 width-full public source\"][2]/child::div/child::div/child::span/a")).click();
        Thread.sleep(3000);
        driver.quit();
    }

    static void fluentWaitExample()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = (WebDriver) new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://github.com/Akash-66");
        FluentWait fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(5000,TimeUnit.SECONDS);
        fluentWait.pollingEvery(250, TimeUnit.SECONDS);
        fluentWait.ignoring(NoSuchElementException.class);
        String title = driver.getTitle();
        driver.quit();
    }
}