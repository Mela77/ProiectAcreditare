package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.RegisterSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void testValidRegister(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount("manuela.pandrea@mailinator.com", "Asda123456!");
        registerSteps.clickRegister();
        registerSteps.checkIfRegistered("Hello manuela.pandrea (not manuela.pandrea? Log out)");
    }

    @Test
    public void testInvalidEmailAddressRegister(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount("manuelapandrea@mailinator", "Asda123456!");
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: Please provide a valid email address.");
    }

    @Test
    public void testRegisterWithoutPassword(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount("manuelapandreatest@mailinator.com", "");
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: Please enter an account password.");
    }

    @Test
    public void testIfPossibleToRegisterWithSameEmailAddress(){
        registerSteps.navigateToMyAccPage();
        registerSteps.createAccount("manuelapandrea@mailinator.com", "");
        registerSteps.clickRegister();
        registerSteps.checkIfValidRegisterEmailAddress("Error: An account is already registered with your email address. Please log in.");
    }

}
