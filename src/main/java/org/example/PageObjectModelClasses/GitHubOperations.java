package org.example.PageObjectModelClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GitHubOperations {

    private WebDriver driver;

    public GitHubOperations(WebDriver driver)
    {
        this.driver = driver;
    }


    By repoButton = By.xpath("//a[contains(@href,\"/Akash-66?tab=repositories\")]");

    public  void clickRepoButton()
    {
        driver.findElement(repoButton).click();
    }
}
