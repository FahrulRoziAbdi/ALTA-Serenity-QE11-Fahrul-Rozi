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

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
    // GET LIST USER
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page value should be {int}")
    public void responseBodyPageValueShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/ListUsersSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//    @And("Print if status code {int} OK")
//    public void printIfStatusCodeOK(int ok) {
//        SerenityRest.and().log().ifStatusCodeIsEqualTo(ok);
//    }
//    @And("Get log body")
//    public void getLogBody() {
//        SerenityRest.and().log().body();
//    }
//
//    @And("Get log all")
//    public void getLogAll() {
//        SerenityRest.and().log().all();
//    }
    //POST CREATE NEW USER
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/Users.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USERS);
    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldeBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responeBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    //PUT UPDATE USER
    @Given("Put update user with valid id {int} and json")
    public void putUpdateUserWithValidIdAndJson(int id) {
        File json = new File(Constants.REQ_BODY+"/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }
    @And("Validate update user JSON Schema")
    public void validateUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //DELETE USER
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Should return status code {int} No Content")
    public void shouldReturnStatusCodeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }



}
