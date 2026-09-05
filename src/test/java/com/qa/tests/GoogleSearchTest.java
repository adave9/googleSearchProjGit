package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.pages.GoogleHomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends TestBase {

	
	 
    @Test
    public void testGoogleTitle(){
    	GoogleHomePage googleHome = new GoogleHomePage(driver);
        String title = googleHome.getTitle();
        Assert.assertEquals(title, "Google");
    }

    @Test
    public void testGoogleSearchExecution() {
        GoogleHomePage googleHome = new GoogleHomePage(driver);
        googleHome.searchFor("Selenium Java");
        Assert.assertTrue(driver.getTitle().contains("Selenium Java"));
    }
}