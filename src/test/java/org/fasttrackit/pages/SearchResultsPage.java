package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy (css = ".woocommerce-result-count")
    private WebElementFacade multipleSearchResultsMessage;

    @FindBy (css = ".woocommerce-info")
    private WebElementFacade noSearchResultFound;

    @FindBy (css = ".type-product")
    private List<WebElementFacade> listOfResultsProducts;

    @FindBy (css = "select[class=\"orderby\"]")
    private WebElementFacade sortByElement;



    public String getMultipleSearchResultsMessage(){
        return multipleSearchResultsMessage.getText();
    }

    public String getNoSearchResultFound(){
        return noSearchResultFound.getText();
    }

    public boolean findProductInSearchResults(String name) {
        for (WebElementFacade product : listOfResultsProducts) {
            if (product.findBy(By.cssSelector(".collection_title h3")).getText().equals(name))
                return true;
        }
        return false;
    }
    public void sortByDropdown(String text) {
        sortByElement.selectByVisibleText(text);
    }

    public boolean checkPriceAscending() {

            int priceFirstProduct = getPriceFromElement(listOfResultsProducts.get(0));

            int priceLastProduct = getPriceFromElement(listOfResultsProducts.get(listOfResultsProducts.size()-1));
            if(priceFirstProduct < priceLastProduct) {
                return true;
            }
            return false;
    }

    private int getPriceFromElement(WebElementFacade element){
        String priceAsString = element
                .findBy(By.cssSelector(".woocommerce-Price-amount ")).getText()
                .replace("lei", "")
                .replace(".00", "");
        return Integer.parseInt(priceAsString);
    }





}
