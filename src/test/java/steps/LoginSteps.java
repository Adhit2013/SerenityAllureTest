package steps;

import io.qameta.allure.Attachment;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.ManagedPages;
//import net.serenitybdd.annotations.Step;   // same Step class in Allure
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.environment.EnvironmentProperties;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import pages.SuccessPage;
import utils.ScenarioContext;
import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps {

    @ManagedPages
    public LoginPage loginPage;

    @ManagedPages
    public SuccessPage successPage;

    @ManagedPages
    public HomePage homePage;

    @Step("Navigate to Test Site")
    public void navigate(){
      loginPage.open();
    }

    @Step("Login to Test Site")
    public void login(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.submit();
        captureScreenshot();
    }

    @Step("Successful Login")
    public void successfulLogin(){
        assertThat(successPage.loggedIn().isDisplayed()).isTrue();
        assertThat(getDriver().getCurrentUrl()).isEqualTo(successPage.getClass().getAnnotation(DefaultUrl.class).value());
    }

    @Step("Unsuccessful Login")
    public void unsuccessfulLogin() {
        assertThat(loginPage.invalidLoginMessageDisplayed()).isTrue();
    }

    @Step("Go To Home From Login")
    public void goToHome() {
        loginPage.goToHomePage();
    }

    @Attachment(value="Login Screen", type="image/png", fileExtension = ".png")
    public byte[] captureScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
