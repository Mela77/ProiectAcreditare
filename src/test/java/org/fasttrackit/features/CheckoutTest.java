package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.CartSteps;
import org.fasttrackit.steps.CheckoutSteps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private CartSteps cartSteps;
    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CheckoutSteps checkoutSteps;




    @Test
    public void verifyCheckoutTest(){
        loginSteps.login("manuelapandrea@mailinator.com", "Asda123456!",
                "Hello manuelapandrea (not manuelapandrea? Log out)");
        cartSteps.navigateToShop();
        cartSteps.addSpecificProductsToCart();
        cartSteps.navigateToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.validBillingInfo("Manuela", "Pandrea", "United Kingdom (UK)",
                "28 Clifton Gardens", "London",
                "London","NW117EL","+47451234456","manuelapandrea@mailinator.com");
        checkoutSteps.clickOnPlaceOrder();
        checkoutSteps.checkOrderReceived("Thank you. Your order has been received.");

    }

    @Test
    public void verifyCheckoutWithoutPhoneNumberTest(){
        loginSteps.login("manuelapandrea1@mailinator.com", "Asda123456!",
                "Hello manuelapandrea1 (not manuelapandrea1? Log out)");
        cartSteps.navigateToShop();
        cartSteps.addSpecificProductsToCart();
        cartSteps.navigateToCart();
        cartSteps.proceedToCheckout();
        checkoutSteps.invalidBillingInfo("Manuela", "Pandrea", "United Kingdom (UK)",
                "28 Clifton Gardens", "London",
                "London","NW117EL","manuelapandrea@mailinator.com");
        checkoutSteps.clickOnPlaceOrder();
        checkoutSteps.verifyImpossibleToCheckout("Billing Phone is a required field.");

    }
}
