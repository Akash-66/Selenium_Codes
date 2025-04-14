package org.example;

import org.example.pageObjectModel.GitHubOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GitHub {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\akash\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/Akash-66");
        //driver.manage().window().maximize();
        GitHubOperations gitHubOperations = new GitHubOperations(driver);
        gitHubOperations.clickRepoButton();
        //gitHubOperations.clickRepoUrl();
        Thread.sleep(6000);
        driver.quit();
    }
}
