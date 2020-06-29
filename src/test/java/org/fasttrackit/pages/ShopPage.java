package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import java.util.List;



@DefaultUrl("http://qa5.fasttrackit.org:8008/?post_type=product")
public class ShopPage extends PageObject {

    @FindBy (css = ".product-type-simple")
    public List<WebElementFacade> productList;
    @FindBy (css = "a[href*='27']")
    public WebElementFacade beltProduct;
    @FindBy(css = "a[href*='33']")
    public WebElementFacade poloProduct;
    @FindBy (css = ".cart-contents")
    public WebElementFacade cartButton;



    public List<WebElementFacade> getShopProductList(){
        return productList;
    }

    public String getNameOfElement(int index){
        return productList.get(index).findElement(By.className("collection_title")).getText();
    }

    public void addProductToCart(int index){
        productList.get(index).findElement(By.cssSelector("a[href*=\"add-to-cart\"]")).click();
    }

    public void viewProductInCart(int index){
        productList.get(index).findElement(By.cssSelector(".added_to_cart")).click();
    }

    public void addBeltToCart(){
        clickOn(beltProduct);
    }
    public void addPoloToCart() { clickOn(poloProduct); }
    public void clickCartButton(){
        clickOn(cartButton);
    }

}
