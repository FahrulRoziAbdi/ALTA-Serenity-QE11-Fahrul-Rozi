package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class DelayResponseStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get delay response with valid page {int}")
    public void getDelayResponseWithValidPage(int page) {
        reqresAPI.getDelayResponse(page);
    }

    @When("Send request get delay response")
    public void sendRequestGetDelayResponse() {
        SerenityRest.when().get(ReqresAPI.DELAY);
    }

    @And("Validate json schema delay response")
    public void validateJsonSchemaDelayResponse() {
        File json = new File(Constants.JSON_SCHEMA+"/DelaySchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
