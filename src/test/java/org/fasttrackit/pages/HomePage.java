package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {


    @FindBy(css = ".menu-item-70")
    private WebElementFacade myAccountLink;

    @FindBy(css = ".account")
    private WebElementFacade loginLink;

    @FindBy(css = ".search-form .search-field")
    private  WebElementFacade searchField;

    @FindBy(css = ".search-form .searchsubmit")
    private WebElementFacade searchTopButton;

    @FindBy(css = ".menu-item-73")
    private WebElementFacade shopLink;



    public void clickMyAccount(){
        clickOn(myAccountLink);
    }
    public void clickLoginLink(){
        clickOn(loginLink);
    }

    public void setSearchField(String value){
        waitFor(searchField);
        typeInto(searchField, value);
    }
    public void clickOnSearchTopButton(){
        clickOn(searchTopButton);
    }

    public void clickShopButton(){
        clickOn(shopLink);
    }






}
