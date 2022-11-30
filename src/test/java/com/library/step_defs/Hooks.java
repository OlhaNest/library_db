package com.library.step_defs;


import com.library.utilities.ConfigurationReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){


        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));


    }

    @After
    public void tearDown(Scenario scenario){


        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @Before("@db")
    public void setupDB(){
        DB_Util.createConnection();


    }
    @After("@db")
    public void destroyDB(){
        DB_Util.destroy();

    }

    /*

    when we run different feature do we need to change tagName from hooks class? from before and after
    -if we have @db tag over feature/scenario this Hooks will run

     */

}
