package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.MyAccountPage;
import org.fasttrackit.pages.ShopPage;
import org.junit.Assert;

public class CartSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private CartPage cartPage;
    private MyAccountPage myAccountPage;


    @Step
    public void navigateToShop(){
        myAccountPage.clickShopLink();
    }

    @Step
    public void addProductToCart(int index){
        shopPage.getNameOfElement(index);
        shopPage.addProductToCart(index); }
    @Step
    public void viewProductInCart(int index){
        shopPage.viewProductInCart(index);
    }
    @Step
    public void checkIfCartPage(){
        Assert.assertEquals(cartPage.getCartPageTitle(),"Cart");
    }
    @Step
    public void verifyProductInCart(String name){
        Assert.assertTrue(cartPage.checkProductExistsInCart(name)); }
    @Step
    public void addSpecificProductsToCart(){
        shopPage.addBeltToCart();
        shopPage.addPoloToCart(); }
    public void navigateToCart(){
        shopPage.clickCartButton(); }
    @Step
    public void navigateToShopFromHome(){
        homePage.open();
        homePage.clickShopButton(); }
    @Step
    public void verifyTotalProductPricesInCart(){
        Assert.assertTrue(cartPage.checkProductsTotalPrice()); }
    @Step
    public void proceedToCheckout(){
        cartPage.clickCheckoutButton();
    }









}
