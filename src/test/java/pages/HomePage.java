package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://practicetestautomation.com")
public class HomePage extends PageObject {

    @FindBy(xpath="//h1[normalize-space()='Hello']")
    private WebElementFacade helloText;

    public WebElementFacade hello(){
        return helloText;
    }
}
