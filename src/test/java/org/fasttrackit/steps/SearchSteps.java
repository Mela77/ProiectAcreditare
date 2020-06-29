package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.HomePage;
import org.fasttrackit.pages.ProductDetailsPage;
import org.fasttrackit.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ProductDetailsPage productDetailsPage;


    @Step
    public void searchForProduct(String value){
        homePage.open();
        homePage.setSearchField(value);
        homePage.clickOnSearchTopButton();
    }
    @Step
    public void checkMultipleSearchResults(String expected){
        String message = searchResultsPage.getMultipleSearchResultsMessage();
        Assert.assertEquals(expected, message);
    }
    @Step
    public void checkSingleSearchResults(String expected){
        String message = productDetailsPage.getSingleSearchResultsMessage();
        Assert.assertEquals(expected, message);
    }
    @Step
    public void checkIfNoSearchResults(String expected){
        String message = searchResultsPage.getNoSearchResultFound();
        Assert.assertEquals(expected, message);
    }
    @Step
    public void verifyProductIsFound(String name){
        Assert.assertTrue(searchResultsPage.findProductInSearchResults(name));
    }
    @Step
    public void sortByPrice(){
        searchResultsPage.sortByDropdown("Sort by price: low to high");
    }

    @Step
    public void verifyProductPrices(){
        Assert.assertTrue(searchResultsPage.checkPriceAscending());
    }






}
