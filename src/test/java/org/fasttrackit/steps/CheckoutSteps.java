package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CheckoutPage;
import org.junit.Assert;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;

    @Step
    public void validBillingInfo(String firstName, String lastName, String country, String address, String townName,
                            String countyName, String postCode, String phone, String emailAddress){
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.selectCountry(country);
        checkoutPage.setAddressField(address);
        checkoutPage.setTownField(townName);
        checkoutPage.setCountyField(countyName);
        checkoutPage.setPostCodeField(postCode);
        checkoutPage.setPhoneNumberField(phone);
        checkoutPage.setEmailAddressField(emailAddress);
    }
    @Step
    public void clickOnPlaceOrder(){
        checkoutPage.placeOrder();
    }

    @Step
    public void checkOrderReceived(String expected){
        String message = checkoutPage.getOrderReceivedConf() ;
        Assert.assertEquals(expected, message);
    }

    @Step
    public void invalidBillingInfo(String firstName, String lastName, String country, String address, String townName,
                                 String countyName, String postCode, String emailAddress){
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.selectCountry(country);
        checkoutPage.setAddressField(address);
        checkoutPage.setTownField(townName);
        checkoutPage.setCountyField(countyName);
        checkoutPage.setPostCodeField(postCode);
        checkoutPage.setEmailAddressField(emailAddress);
    }
    @Step
    public void verifyImpossibleToCheckout(String expected){
        String message = checkoutPage.getIncorrectBillingDetailsMessage() ;
        Assert.assertEquals(expected, message);
    }


}
