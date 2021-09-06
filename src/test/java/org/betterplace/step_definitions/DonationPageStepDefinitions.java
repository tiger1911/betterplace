package org.betterplace.step_definitions;

import org.betterplace.pages.DonationPage;
import org.betterplace.utilities.BrowserUtils;
import org.betterplace.utilities.ConfigurationReader;
import org.betterplace.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

public class DonationPageStepDefinitions extends DonationPage {

    @Given("The user is on the donation page")
    public void the_user_is_on_the_donation_page() throws InterruptedException {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        WebElement cookieAcceptButton = Driver.get().findElement(By.xpath("//button[@class='btn btn-primary btn-large flex-grow mb-3']"));
        if (cookieAcceptButton.isDisplayed()){
            cookieAcceptButton.click();
        }
    }

    @Given("The user is on the donation page link1")
    public void the_user_is_on_the_donation_page_link1() {
        String url = ConfigurationReader.get("url1");
        Driver.get().get(url);
        WebElement cookieAcceptButton = Driver.get().findElement(By.xpath("//button[@class='btn btn-primary btn-large flex-grow mb-3']"));
        if (cookieAcceptButton.isDisplayed()){
            cookieAcceptButton.click();
        }
    }

    @Given("The user enters {string} Euro in the amount input box and select {string} radio button")
    public void the_user_enters_Euro_in_the_amount_input_box_and_select_radio_button(String amount1, String radioButton) {

        //amount.clear();
        amount.sendKeys(Keys.CONTROL, Keys.chord("a"));
        amount.sendKeys(Keys.BACK_SPACE);
        amount.sendKeys(Keys.BACK_SPACE);
        amount.sendKeys(amount1);
    }

    @Given("The user selects {string} radio button")
    public void the_user_selects_radio_button(String radioButton) {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(sepaLastschriftRadioButton);
    }

    @Given("The user clicks on the succesIBANButton and copy success IBAN value")
    public void the_user_clicks_on_the_succesIBANButton_and_copy_success_IBAN_value() {

        BrowserUtils.clickWithJS(succesIBANButton);
    }

    @Then("The user sends copied success IBAN value to the inputBoxIBAN")
    public void the_user_sends_copied_success_IBAN_value_to_the_inputBoxIBAN() {

        String IBANValue = successIBANValue.getText();
        System.out.println(IBANValue);
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().frame(Driver.get().findElement(By.xpath("//iframe[@title='Sicherer Eingaberahmen für IBAN']")));
        inputBoxIBAN.sendKeys(IBANValue);
        Driver.get().switchTo().parentFrame();

    }

    @When("The user clicks on the jetztSpenden button")
    public void the_user_clicks_on_the_jetztSpenden_button() {
        BrowserUtils.waitFor(1);
        jetztSpendenButton.click();
    }

    @Then("The user donates successfully")
    public void the_user_donates_successfully() {
        BrowserUtils.waitFor(3);
        String pageTitle = Driver.get().getTitle();
        Assert.assertEquals("Danke für deine Spende – betterplace.org",pageTitle);
        System.out.println(pageTitle);


    }



}
