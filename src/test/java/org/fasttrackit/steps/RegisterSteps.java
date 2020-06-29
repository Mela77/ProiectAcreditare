package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;
import org.junit.Assert;

public class RegisterSteps {
    private HomePage homePage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToMyAccPage(){
        homePage.open();
        homePage.clickMyAccount(); }
    @Step
    public void createAccount(String emailAddress, String pass){
        myAccountPage.setRegisterEmailField(emailAddress);
        myAccountPage.setRegisterPassField(pass); }
    @Step
    public void clickRegister(){
        myAccountPage.clickRegister();
    }
    @Step
    public void checkIfRegistered(String expected){
        String message = myAccountPage.getHelloMessage();
        Assert.assertEquals(expected, message); }
    @Step
    public void checkIfValidRegisterEmailAddress(String expected){
        String message = myAccountPage.getInvalidEmailAddressMessage();
        Assert.assertEquals(expected,message); }





}
