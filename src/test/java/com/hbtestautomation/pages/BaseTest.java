package com.hbtestautomation.pages;


import com.hbtestautomation.utility.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.hbtestautomation.utility.ConfigDataProviders;


public class BaseTest {

    public WebDriver driver;
    public ConfigDataProviders config;


    @BeforeSuite
    public void setUpSuite()
    {
        config=new ConfigDataProviders();

    }
    @BeforeClass
    public void setUp()
    {
        driver=BrowserFactory.startApplication(config.getBrowser(),config.getStagingUrl());
    }

    @AfterClass
    public void tearDown()
    {
        BrowserFactory.quitBrowser(driver);
    }


}