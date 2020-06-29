package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.LoginSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void testValidLoginWithEmailAddress(){

        loginSteps.navigateToLogin();
        loginSteps.loginDetails("manuelapandrea@mailinator.com", "Asda123456!");
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfLoggedIn("Hello manuelapandrea (not manuelapandrea? Log out)");
    }

    @Test
    public void testInvalidLogin(){
        loginSteps.navigateToLogin();
        loginSteps.loginDetails("manuela.pandrea.com", "Asda12346!");
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfInvalidLogin("ERROR: Invalid username. Lost your password?");
    }

    @Test
    public void testValidLoginWithUsername(){

        loginSteps.navigateToLogin();
        loginSteps.loginDetails("manuelapandrea", "Asda123456!");
        loginSteps.clickRememberMe();
        loginSteps.clickLogin();
        loginSteps.checkIfLoggedIn("Hello manuelapandrea (not manuelapandrea? Log out)");
    }
}
