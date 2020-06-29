package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;
import org.junit.Assert;

public class LoginSteps {
    private HomePage homePage;
    private MyAccountPage myAccountPage;

    @Step
    public void navigateToLogin(){
        homePage.open();
        homePage.clickLoginLink(); }
    @Step
    public void loginDetails(String emailAddress, String password){
       myAccountPage.setUsernameLogin(emailAddress);
       myAccountPage.setPassLoginField(password); }
    @Step
    public void clickRememberMe(){
        myAccountPage.clickRememberMe();
    }
    @Step
    public void clickLogin(){
        myAccountPage.clickLogin(); }
    @Step
    public void checkIfLoggedIn(String expected){
        String message = myAccountPage.getHelloMessage();
        Assert.assertEquals(expected, message); }
    @Step
    public void checkIfInvalidLogin(String expected){
        String message = myAccountPage.getInvalidUsernameMessage();
        Assert.assertEquals(expected, message); }

    @Step
    public void login(String email, String password, String message){
        navigateToLogin();
        loginDetails(email, password);
        clickRememberMe();
        clickLogin();
        checkIfLoggedIn(message);

    }





}
