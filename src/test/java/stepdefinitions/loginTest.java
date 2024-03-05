package stepdefinitions;


import setup.BaseSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojos.RegisteredUser;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class loginTest {

    String baseUrl;
    BaseSetup confManager;
    private RequestSpecification request;
    private Response response;



    @Given("with valid creds")
    public void validate_creds(){
        System.out.println("I have valid credentials");
//        System.out.println(System.getProperty("user.dir"));
        confManager = new BaseSetup();
//        System.out.println(confManager.getProperty("baseUrl"));
        request = RestAssured.given().baseUri(confManager.getProperty("baseUrl"));




    }

    @When("login")
    public void login(){
        System.out.println("login");
        // Make API request to login endpoint
        // use either POJO or hasMap for body
        RegisteredUser pp = new RegisteredUser("ikram+1111@trustsignal.io", "!@#$%^&*");
        response = request.
                contentType("application/json").
                body(pp).
                when().
                post("/v2/auth/login");

    }

    @Then("login successfully")
    public void validatelogin(){
        System.out.println("login successfully");
        Assert.assertEquals(response.getStatusCode(), 200);
//      System.out.print(response.asPrettyString());
    }

//    public String api_key(){
//        //extract the response as a JSON object
//        // traverse to the api_key
//        // return string
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            JsonNode node = objectMapper.readTree(response.asString());
//            JsonNode nameNode = node.get("name");
//            String name = nameNode.asText();
//            System.out.println(name);
//            JsonNode ageNode = node.get("age");
//            int age = ageNode.asInt();
//            System.out.println(age);
//            JsonNode array = node.get("technologies");
//            JsonNode jsonNode = array.get(1);
//            String techStr = jsonNode.asText();
//            System.out.println(techStr);
//            JsonNode child = node.get("nestedObject");
//            JsonNode childField = child.get("field");
//            String field = childField.asText();
//            System.out.println(field);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//        JsonNode apiKeyNode = rootNode.get("api_key");
//        String apiKey = apiKeyNode.asText();
//        return "ikram";
//    }

}
