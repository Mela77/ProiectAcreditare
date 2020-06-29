package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=6")
public class CheckoutPage extends PageObject {

    @FindBy(id="billing_first_name")
    private WebElementFacade firstNameField;
    @FindBy(id="billing_last_name")
    private WebElementFacade lastNameField;
    @FindBy(css = "select[id=\"billing_country\"]")
    private WebElementFacade countryFieldDropdown;
    @FindBy(id="billing_address_1")
    private WebElementFacade addressField;
    @FindBy(id="billing_city")
    private WebElementFacade townField;
    @FindBy(id="billing_state")
    private WebElementFacade countyField;
    @FindBy(id="billing_postcode")
    private WebElementFacade postCodeField;
    @FindBy(id="billing_phone")
    private WebElementFacade phoneNumberField;
    @FindBy(id="billing_email")
    private WebElementFacade emailAddressField;
    @FindBy(id="place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".woocommerce-order p")
    private WebElementFacade orderReceivedMessage;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade incorrectBillingDetailsMessage;



    public void setFirstNameField(String firstName){
        typeInto(firstNameField, firstName);
    }
    public void setLastNameField(String lastName){
        typeInto(lastNameField, lastName);
    }
    public void selectCountry(String text) {
        countryFieldDropdown.selectByVisibleText(text);
    }
    public void setAddressField(String address){
        typeInto(addressField, address);
    }
    public void setTownField(String townName){
        typeInto(townField, townName);
    }
    public void setCountyField(String countyName){
        typeInto(countyField, countyName);
    }
    public void setPostCodeField(String postCode){
        typeInto(postCodeField, postCode);
    }
    public void setPhoneNumberField(String telephone){
        typeInto(phoneNumberField, telephone);
    }
    public void setEmailAddressField(String emailAddress){
        typeInto(emailAddressField, emailAddress);
    }
    public void placeOrder(){
        clickOn(placeOrderButton);
    }
    public String getOrderReceivedConf(){
        waitFor(orderReceivedMessage);
        return orderReceivedMessage.getText();
    }
    public String getIncorrectBillingDetailsMessage(){
        waitFor(incorrectBillingDetailsMessage);
        return incorrectBillingDetailsMessage.getText();
    }







}
