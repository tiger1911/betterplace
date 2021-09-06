package org.betterplace.pages;

import org.betterplace.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DonationPage {

    public DonationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy( xpath = "//input[@name='amount_cents']")
    public WebElement amount;

    @FindBy(css = "[id='single']")
    public WebElement einmaligRadioButton;

    @FindBy(xpath = "(//span[@class='generic-custom-radio'])[5]")
    public WebElement sepaLastschriftRadioButton;

    @FindBy(css = "[id= 'first_name']")
    public WebElement vorname;

    @FindBy(css= "[id= 'last_name']")
    public WebElement nachname;

    @FindBy(css = "[id='email']")
    public WebElement email;

    @FindBy(css = "[id='show_amount']")
    public WebElement betragAnzeigenRadioButton;

    @FindBy(xpath = "//input[@class='InputElement is-empty Input Input--empty']")
    public WebElement inputBoxIBAN;

    @FindBy(xpath = "//button[@class='btn btn-large btn-primary submit-donation-button']")
    public WebElement jetztSpendenButton;

    @FindBy(xpath = "//a[contains(.,'IBAN (success)')]")
    public WebElement succesIBANButton;

    @FindBy(xpath = "(//span/code)[1]")
    public WebElement successIBANValue;

}
