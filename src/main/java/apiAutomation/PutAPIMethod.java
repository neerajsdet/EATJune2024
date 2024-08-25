package apiAutomation;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutAPIMethod {
    public String urlPutRequest = "https://fakerestapi.azurewebsites.net/api/v1/Books/100";
    public String contentType = "application/json";
    public Map payload = null;

    @Test
    public void editBookWithPutRequest(){
        payload = new HashMap();
        payload.put("id","120");
        payload.put("title","New Book");
        payload.put("description","This is the put request");
        payload.put("pageCount",0);
        payload.put("excerpt","Test");
        payload.put("publishDate","2023-12-16T17:40:55.925Z");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200);
    }


    @Test
    public void editBookWithPutRequestAndGetResponse(){
        payload = new HashMap();
        payload.put("id","120");
        payload.put("title","New Book");
        payload.put("description","This is the put request");
        payload.put("pageCount",0);
        payload.put("excerpt","Test");
        payload.put("publishDate","2023-12-16T17:40:55.925Z");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("title",equalTo("New Book"))
                .body("description",equalTo("This is the put request"));
    }



    @Test
    public void verifyResponseCodeOfPutRequest(){
        payload = new HashMap();
        payload.put("id","121");
        payload.put("title","New Book");
        payload.put("description","This is the put request");
        payload.put("pageCount",0);
        payload.put("excerpt","Test");
        payload.put("publishDate","2023-12-16T17:40:55.925Z");

        given().contentType(contentType).body(payload)
                .when()
                .put(urlPutRequest)
                .then()
                .statusCode(200);
    }


}
