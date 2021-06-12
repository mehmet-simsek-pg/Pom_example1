package test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactUsElements {
    public ContactUsElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsBtn;

    @FindBy(id = "Enquiry")
    WebElement enquiryText;

    @FindBy(name = "send-email")
    WebElement submitBtn;

    @FindBy(className = "result")
    WebElement result;
}
