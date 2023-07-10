package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class RegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json=new File(Constants.REQ_BODY+"/RegisterUser.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }
    @And("Response body id was {int} and token {string}")
    public void responseBodyIdWasAndToken(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID_USER,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }
    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterSucSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }



    @Given("Register user with invalid json")
    public void registerUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY+"/RegisUserInvalid.json");
        reqresAPI.postRegisterUser(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int BadReq) {
        SerenityRest.then().statusCode(BadReq);
    }

    @And("Response body error should be {string}")
    public void responseBodyError(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR,equalTo(error));
    }


    @And("Validate json schema invalid register")
    public void validateJsonSchemaInvalidRegister() {
        File json = new File(Constants.JSON_SCHEMA+"/RegisterUnsucSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
