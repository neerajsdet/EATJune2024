package apiAutomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAPIRequest {

    private String urlGetRequest = "https://fakerestapi.azurewebsites.net/api/v1/Books";
    private String urlGetRequestSpecificBook = "https://fakerestapi.azurewebsites.net/api/v1/Books/23";


    @Test
    public void getRequestAPIMethod(){
        given()
                .when()
                .get(urlGetRequest)
                .then()
                .statusCode(200);
    }

    @Test
    public void getRequestAPIMethodWithResponse(){
        given()
                .when()
                .get(urlGetRequest)
                .then()
                .statusCode(200)
                .log()
                .body();
    }
    @Test
    public void getRequestAPIMethodWithResponseForSpecificBookID(){
        given()
                .when()
                .get(urlGetRequestSpecificBook)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void verifyGetRequestAPIResponseForSpecificBookID(){
        given()
                .when()
                .get(urlGetRequestSpecificBook)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("title", equalTo("Book 23"));
    }

}
