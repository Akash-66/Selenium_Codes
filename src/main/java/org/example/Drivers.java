package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {

    public static WebDriver  webDriver;

    public  static WebDriver openChromeDriver()
    {
        System.setProperty("webdriver.chrome.driver",".//utilities//drivers//chromedriver.exe");
        webDriver = (WebDriver) new ChromeDriver();
        webDriver.manage().window().maximize();
        return  webDriver;
    }
}
