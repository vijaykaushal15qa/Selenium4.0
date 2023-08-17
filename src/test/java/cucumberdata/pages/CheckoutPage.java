package cucumberdata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElement billingFirstNameFld;

    @FindBy(id = "billing_last_name")
    private WebElement billingLastNameFld;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressOneField;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    private List<WebElement> billingStateDropDown;

    @FindBy(id = "billing_city")
    private WebElement billingCityFld;

    @FindBy(id = "billing_postcode")
    private WebElement billingZipFld;

    @FindBy(css = "#billing_email")
    private WebElement billingMailFld;

    @FindBy(id = "place_order")
    private WebElement placeOrderBtn;

    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String billingFirstName) {
        WebElement e =wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.click();
        e.sendKeys(billingFirstName);
        return this;
    }
    public CheckoutPage enterBillingLastName(String billingLastName)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.click();
        e.sendKeys(billingLastName);
        return this;
    }
    public CheckoutPage enterBillingAddressLineOne(String billingAddressLineOne)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingAddressOneField));
        e.click();
        e.sendKeys(billingAddressLineOne);
        return this;
    }
    public CheckoutPage selectBillingState(String stateName)
    {
        for (WebElement stateValue:billingStateDropDown)
        {
            if(stateValue.getText().contains("stateName"))
            {
                stateValue.click();
                break;
            }
        }
    //Select select=new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDropDown)));
        //select.selectByVisibleText(stateName);
        return this;
    }

    public CheckoutPage enterBillingCity(String billingCity)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.click();
        e.sendKeys(billingCity);
        return this;
    }
    public CheckoutPage enterZip(String zipCode)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.click();
    e.clear();
        e.sendKeys(zipCode);
        return this;
    }
    public CheckoutPage enterBillingMail(String billingMail)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(billingMailFld));
        e.click();
        e.sendKeys(billingMail);
        return this;
    }

    public CheckoutPage setBillingDetails(String billingFirstName,String billingLastName,String billingAddressOne,
                                          String billingStateName,String billingCity, String billingZip, String billingEmail)
    {
    return enterBillingFirstName(billingFirstName).
            enterBillingLastName(billingLastName).
            enterBillingAddressLineOne(billingAddressOne).
            enterBillingCity(billingCity).
            selectBillingState(billingStateName).
            enterZip(billingZip).
            enterBillingMail(billingEmail);
    }

    public CheckoutPage placeOrder()
    {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice()
    {
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}

