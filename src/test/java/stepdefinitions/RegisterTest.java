package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.testng.Assert;
import pojos.NewUser;
import pojos.RegisteredUser;
import setup.BaseSetup;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class RegisterTest {

    String baseUrl;

    NewUser new_user;
    RegisteredUser registeredUser;
    BaseSetup confManager;

    String api_key;

    String otp;


    private RequestSpecification request;
    private Response response;

    @Given("valid user details")
    public void valid_user_details() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("Valid User details");
        confManager = new BaseSetup();
        request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));
    }

    @When("the user tries to register")
    public void the_user_tries_to_register() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("trying to register");
        new_user = new NewUser("RestAPI_Automation","TrustSignalRestAPI",
                "ikram+restAPI123456789@trustsignal.io", "Yellow@8765",
                9718123456L, 1);
//        System.out.println(new_user.toString());
        response = request.body(new_user).when().log().all().post("/v2/auth/register");

    }

    @Then("the user should be registered successfully and status should be inactive")
    public void the_user_should_be_registered_successfully_and_status_should_be_inactive() {
        // Write code here that turns the phrase above into concrete actions
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if(response.getStatusCode() != 200)
            Assert.fail("User registration failed");
        String status = response.jsonPath().getString("account.status");
        System.out.println("account status: "+ status);
        if(!status.equals("pending"))
            Assert.fail("Status can only be pending for new registration");

    }
    @Given("received api_key")
    public void received_api_key() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        api_key = response.jsonPath().getString("api_key");
        if(api_key.isEmpty())
            Assert.fail("User registration unsuccessful");
        System.out.println("api_key: "+api_key+" received ");
        registeredUser = new RegisteredUser(new_user.getEmail(), new_user.getPassword());
    }
    @When("try to generate otp")
    public void try_to_generate_otp() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));
        response = request.queryParam("api_key",api_key).when().log().all().post("/v2/auth/generate-otp");
    }
    @Then("otp generated successfully")
    public void otp_generated_successfully() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if(response.getStatusCode() != 200)
            Assert.fail("User registration failed");
//        System.out.println(response.jsonPath().getString("success"));
        if(response.jsonPath().getString("success").equals("true"))
            System.out.println("otp generated successfully");
    }
    @Given("received generated otp")
    public void received_generated_otp() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException()
        System.out.println("received_generated_otp");


    }
    @When("try to verify with otp")
    public void try_to_verify_with_otp() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        System.out.println("try to verify with otp");
//      request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));
        response = request.body("{\n" +
                "    \"otp\":\"999999\"\n" +
                "}").when().post("v2/auth/verify-otp");
    }
    @Then("user status should change to active")
    public void user_status_should_change_to_active() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
        if(response.getStatusCode() != 200)
            Assert.fail("OTP verification failed");
//        System.out.println("User account verification status: "+response.jsonPath().getString("message"));

    }


    @Given("with above valid credentials")
    public void withAboveValidCredentials() {
        System.out.println(new_user.getEmail());
        System.out.println(new_user.getPassword());


    }

    @When("user try to login")
    public void userTryToLogin() {
        request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));
        response = request.
                contentType("application/json").
                body(registeredUser).
                when().log().all().
                post("/v2/auth/login");
    }

    @Then("login successfull")
    public void loginSuccessfull() {
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.jsonPath().getString("account"));


    }
}
