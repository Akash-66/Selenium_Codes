package org.example.TestScripts;

import org.example.DriverClass.Drivers;
import org.example.pageObjectModel.GitHubOperations;
import org.openqa.selenium.WebDriver;

public class GitHub {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = Drivers.openChromeDriver();
        driver.get("https://github.com/Akash-66");
        GitHubOperations gitHubOperations = new GitHubOperations(driver);
        gitHubOperations.clickRepoButton();
        Thread.sleep(6000);
        driver.quit();
    }
}
