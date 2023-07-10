package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";
    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String POST_CREATE_USERS = Constants.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";
    public static String POST_REGISTER_USER = Constants.BASE_URL+"/api/register";
    public static String LOGIN_USER = Constants.BASE_URL+"/api/login";
    public static String DELAY = Constants.BASE_URL+"/api/users?delay={page}";


    @Step("Get list users")
    public void getListUsers(int page){
        SerenityRest.given().pathParam("page",page);
    }
    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single user")
    public void getSingleUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Patch update user")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post register user")
    public void postRegisterUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Post login user")
    public void postLoginUser (File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Get delay response")
    public void getDelayResponse(int page){
        SerenityRest.given().pathParam("page",page);
    }


}
