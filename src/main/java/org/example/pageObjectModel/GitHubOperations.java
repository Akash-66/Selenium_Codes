package org.example.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GitHubOperations {

    private WebDriver driver;

    public GitHubOperations(WebDriver driver)
    {
        this.driver = driver;
    }


    By repoButton = By.xpath("//a[contains(@href,\"/Akash-66?tab=repositories\")]");
    By repoURL = By.xpath("//a[contains(@href,\"Akash-66/Robot-Automation\")]");

    public  void clickRepoButton()
    {
        driver.findElement(repoButton).click();
    }

    public  void clickRepoUrl()
    {
        driver.findElement(repoURL).click();
    }
}
