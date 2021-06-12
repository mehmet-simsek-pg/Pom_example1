package test2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductElements {

    public ProductElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Apparel & Shoes")
    WebElement shoesBtn;

    @FindBy(css = "a[title='Show details for Blue and green Sneaker']")
    WebElement productBtn1;

    @FindBy(id = "add-to-wishlist-button-28")
    WebElement productWishListBtn1;

    @FindBy(css = "a[title^='Show details']")
    WebElement productBtn2;

    @FindBy(id = "add-to-wishlist-button-5")
    WebElement productWishListBtn2;

    @FindBy(css = "a[class='ico-wishlist']")
    WebElement wishListBtn;

    @FindBy(css = "td[class='product']>a")
    List<WebElement> productsName;

    @FindBy(name = "removefromcart")
    List<WebElement> removeProduct;

    @FindBy(name = "updatecart")
    WebElement wishLitUpdateBtn;
}
