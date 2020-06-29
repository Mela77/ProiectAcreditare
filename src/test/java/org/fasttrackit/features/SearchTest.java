package org.fasttrackit.features;

import net.thucydides.core.annotations.Steps;
import org.fasttrackit.steps.SearchSteps;
import org.fasttrackit.utils.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void searchWithMultipleResults(){
        searchSteps.searchForProduct("shirt");
        searchSteps.checkMultipleSearchResults("Showing all 3 results");
    }

    @Test
    public void searchWithSingleResult(){
        searchSteps.searchForProduct("cap");
        searchSteps.checkSingleSearchResults("DESCRIPTION");
    }

    @Test
    public void searchWithNoResult(){
        searchSteps.searchForProduct("qwerty");
        searchSteps.checkIfNoSearchResults("No products were found matching your selection.");
    }

    @Test
    public void searchByKeywordTest(){
        String productName = "Hoodie";
        searchSteps.searchForProduct(productName);
        searchSteps.verifyProductIsFound(productName);
    }

    @Test
    public void filterByPriceLowToHigh(){
        String productName = "shirt";
        searchSteps.searchForProduct(productName);
        searchSteps.sortByPrice();
        searchSteps.verifyProductPrices();
    }


}
