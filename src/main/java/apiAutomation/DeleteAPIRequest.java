package apiAutomation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAPIRequest {

    private String urlDeleteRequestSpecificBook = "https://fakerestapi.azurewebsites.net/api/v1/Books/23";


    @Test
    public void deleteRequestAPIMethod(){
        given()
                .when()
                .delete(urlDeleteRequestSpecificBook)
                .then()
                .statusCode(200);
    }

    @Test
    public void deleteRequestAPIMethod1(){
        given()
                .when()
                .delete(urlDeleteRequestSpecificBook)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

}
