package test2;

import Utils.ParameterDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPom extends ParameterDriver {
    @Test
    void productTest() {
        ProductElements elements = new ProductElements(driver);

        elements.shoesBtn.click();
        elements.productBtn1.click();
        elements.productWishListBtn1.click();
        driver.navigate().back();
        elements.productBtn2.click();
        elements.productWishListBtn2.click();
        elements.wishListBtn.click();

        Assert.assertTrue(elements.productsName.get(0).getText().contains("Blue"));
        Assert.assertTrue(elements.productsName.get(1).getText().contains("Size"));

        for (WebElement removeBtn : elements.removeProduct) {
            removeBtn.click();
        }
        elements.wishLitUpdateBtn.click();
    }

}
