package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class MyAccountPage extends PageObject {

    @FindBy(id="reg_email")
    private WebElementFacade registerEmailField;

    @FindBy(id="reg_password")
    private WebElementFacade registerPassField;

    @FindBy(css = "button[name='register']")
    private WebElementFacade registerButton;

    @FindBy(css = "p:nth-child(1)")
    private WebElementFacade helloMessage;

    @FindBy(id="username")
    private WebElementFacade usernameLoginField;

    @FindBy(id="password")
    private WebElementFacade passLoginField;

    @FindBy(css = ".button[name=login]")
    private WebElementFacade loginButton;

    @FindBy(id="rememberme")
    private WebElementFacade rememberMeButton;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade invalidUsernameMessage;

    @FindBy (css = ".woocommerce-error >li")
    private WebElementFacade invalidEmailAddressMessage;

    @FindBy(id="menu-item-73")
    private WebElementFacade shopLink;



    public void setRegisterEmailField(String registerEmail){
        typeInto(registerEmailField, registerEmail);
    }
    public void setRegisterPassField(String registerPass){
        typeInto(registerPassField, registerPass);
    }
    public void clickRegister(){
        clickOn(registerButton);
    }
    public String getHelloMessage(){
        return helloMessage.getText();
    }
    public void setUsernameLogin(String userEmail){
        typeInto(usernameLoginField, userEmail);
    }
    public void setPassLoginField(String userPass){
        typeInto(passLoginField, userPass);
    }
    public void clickRememberMe(){
        clickOn(rememberMeButton);
    }
    public void clickLogin(){
        clickOn(loginButton);
    }
    public String getInvalidUsernameMessage(){
        return invalidUsernameMessage.getText();}
    public String getInvalidEmailAddressMessage(){
        return invalidEmailAddressMessage.getText();}

    public void clickShopLink(){
        clickOn(shopLink);
    }
}
