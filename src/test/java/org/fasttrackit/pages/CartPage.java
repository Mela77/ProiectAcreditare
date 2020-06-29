package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=5")
public class CartPage extends PageObject {


    @FindBy (css = ".entry-title")
    private WebElementFacade pageTitle;
    @FindBy (css = ".cart_item")
    private List<WebElementFacade> productAddedToCartList;
    @FindBy (css = ".order-total .amount")
    private WebElementFacade cartTotalAmount;
    @FindBy (css = ".checkout-button")
    private WebElementFacade checkoutButton;



    public String getCartPageTitle(){
        return pageTitle.getText();
    }

    public List<WebElementFacade> getProductList(){
        return  productAddedToCartList;
    }

    public boolean checkProductExistsInCart(String name){
        for(WebElementFacade currentElement : productAddedToCartList){
            if(currentElement.findElement(By.cssSelector(".product-name a")).getText().equals(name)){
                return true;
            }
        }
        return false;
    }

    public boolean checkProductsTotalPrice() {
        String productPriceAsString = productAddedToCartList.get(0)
                .findBy(By.cssSelector(".product-subtotal .amount")).getText()
                .replace("lei", "")
                .replace(".00", "");
        int priceFirstProduct = Integer.parseInt(productPriceAsString);
        String productPriceAsStringLastProduct = productAddedToCartList.get(productAddedToCartList.size()-1)
                .findBy(By.cssSelector(".product-subtotal .amount")).getText()
                .replace("lei", "")
                .replace(".00", "");
        int priceLastProduct = Integer.parseInt(productPriceAsStringLastProduct);
        String productTotalPriceAsString = cartTotalAmount.getText()
                .replace("lei", "")
                .replace(".00", "");
        int TotalCartPrice = Integer.parseInt(productTotalPriceAsString);
        int sum = priceFirstProduct + priceLastProduct;
        if(sum == TotalCartPrice) {
            return true;
        }
        return false;
    }

    public void clickCheckoutButton(){
        clickOn(checkoutButton);
    }






}
