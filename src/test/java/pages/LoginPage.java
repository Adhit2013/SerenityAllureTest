package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://practicetestautomation.com/practice-test-login")
public class LoginPage extends PageObject {

    @FindBy(css = "#username")
    private WebElementFacade userName;

    @FindBy(css = "#submit")
    private WebElementFacade submit;

    @FindBy(css = "#password")
    private WebElementFacade password;

    @FindBy(css = "#error")
    private WebElementFacade invalidLoginMsg;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    private WebElementFacade homeTab;

    public void enterUserName(String name) {
        $(userName).type(name);
    }

    public void enterPassword(String pwd) {
        $(password).type(pwd);
    }

    public void submit() {
        $(submit).click();
    }

    public boolean invalidLoginMessageDisplayed(){
        return $(invalidLoginMsg).isDisplayed();
    }

    public void goToHomePage(){
        homeTab.click();
    }
}

