package org.betterplace.step_definitions;

import org.betterplace.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().setSize(new Dimension(400,860));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }

    @AfterStep
    public void screenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot,"image/png","screenshot");


    }



}