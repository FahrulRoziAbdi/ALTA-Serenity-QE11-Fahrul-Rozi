package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class ListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get single user with valid id {int}")
    public void getSingleUserWithValidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
    @And("Validate json schema get single user")
    public void validateJsonSchemaGetSingleUser() {
        File json = new File(Constants.JSON_SCHEMA+"/SingleUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single user with invalid id {int}")
    public void getSingleUserWithInvalidId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }


}
