package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefintions {

    @Steps
    LoginSteps loginSteps;

    @Given("User navigate to test site")
    public void UserNavigateToGmail() {
        loginSteps.navigate();
    }

    @When("User enters credentials")
    public void userEntersCredentials(DataTable table) {
        Map <String, String> userIdMap = table.asMap();
        loginSteps.login(userIdMap.get("userName"), userIdMap.get("password"));
    }

    @Then("User login successful")
    public void userLoginSuccessful() {
        loginSteps.successfulLogin();
    }

    @Then("User login unsuccessful")
    public void userLoginUnsuccessful() {
        loginSteps.unsuccessfulLogin();
    }

    @When("User navigate to Home")
    public void userNavigateToHome() {
        loginSteps.goToHome();
    }

    @Then("Home page displayed")
    public void homePageDisplayed() {
        assertThat(loginSteps.homePage.hello().isDisplayed()).isTrue();
    }
}
