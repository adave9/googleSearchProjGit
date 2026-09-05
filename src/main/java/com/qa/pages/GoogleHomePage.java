package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	
    private WebDriver driver;
    
    @FindBy(name = "q")
    private WebElement searchBox;
    
    public GoogleHomePage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver,this);
    }
    
    public String getTitle() {
    	return driver.getTitle();
    }

    public String getURL() {
    	return driver.getCurrentUrl();
    }
    
    public void searchFor(String query) {
    	searchBox.sendKeys(query+Keys.ENTER);
    }
}