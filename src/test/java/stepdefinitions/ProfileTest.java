package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.NewUser;
import pojos.RegisteredUser;
import setup.BaseSetup;

public class ProfileTest {

    String baseUrl;

    NewUser new_user;
    RegisteredUser registeredUser;
    BaseSetup confManager;

    RequestSpecification request;

    Response response;

    @Given("with valid credentials")
    public void with_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("with valid credentials");
        confManager = new BaseSetup();
        request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));
//        throw new io.cucumber.java.PendingException();
    }
    @When("get the profile of a user")
    public void get_the_profile_of_a_user() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("get the profile of a user");
//        response = request.
//                contentType("application/json").
//                        body(registeredUser).
//                                when().log().all().
//                                post("/v2/auth/login");
//        throw new io.cucumber.java.PendingException();
    }
    @Then("user should get profile details")
    public void user_should_get_profile_details() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("user should get profile details");
    }
}
