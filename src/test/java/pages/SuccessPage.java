package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://practicetestautomation.com/logged-in-successfully/")
public class SuccessPage extends PageObject {

    @FindBy(xpath="//a[normalize-space()='Log out']")
    private WebElementFacade logout;

    public WebElementFacade loggedIn(){
        return logout;
    }
}
