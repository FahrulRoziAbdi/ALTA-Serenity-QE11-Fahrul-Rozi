package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.json.Json;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;
import javax.naming.directory.SearchResult;
import java.io.File;

public class LoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson() {
        File json = new File(Constants.REQ_BODY+"/LoginUser.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File json = new File(Constants.JSON_SCHEMA+"/LoginUserSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //LOGIN UNSUCCESSFUL
    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY+"/InvalidLogin.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Validate json schema invalid login user")
    public void validateJsonSchemaInvalidLoginUser() {
        File json = new File(Constants.JSON_SCHEMA+"/InvalidLoginSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @Given("Post login user with invalid json schema")
    public void postLoginUserWithInvalidJsonSchema() {
        File json = new File(Constants.REQ_BODY+"/InvalidLogin.json");
        reqresAPI.postLoginUser(json);

    }

    @And("Validate json schema login unsuccessfully")
    public void validateJsonSchemaLoginUnsuccessfully() {
        File json = new File(Constants.JSON_SCHEMA+"/InvalidJsonLoginSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
