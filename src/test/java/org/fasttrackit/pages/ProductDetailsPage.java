package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductDetailsPage extends PageObject {

    @FindBy (id="tab-title-description")
    private WebElementFacade descriptionTab;



    public String getSingleSearchResultsMessage(){
        return descriptionTab.getText();
    }





}
