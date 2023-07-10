package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class UpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with valid id {int} and json")
    public void patchUpdateUserWithValidIdAndJson(int id) {
        File json= new File(Constants.REQ_BODY+"/UpdateUser.json");
        reqresAPI.patchUpdateUser(id,json);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }


    @And("Validate json schema patch update user")
    public void validateJsonSchemaPatchUpdateUser() {
        File json = new File(Constants.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
