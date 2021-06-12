package test1;

import Utils.ParameterDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsPom extends ParameterDriver {

    @Test
    void contactUsTest(){
        ContactUsElements elements=new ContactUsElements(driver);

        elements.contactUsBtn.click();
        elements.enquiryText.sendKeys("Hello World");
        elements.submitBtn.click();
        Assert.assertTrue(elements.result.getText().contains("successfully"));

    }
}
