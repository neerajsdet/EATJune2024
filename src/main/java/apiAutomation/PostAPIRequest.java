package apiAutomation;

import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.put;
import static org.hamcrest.Matchers.equalTo;

public class PostAPIRequest {
    public static String urlPostRequest ="https://fakerestapi.azurewebsites.net/api/v1/Books";
    public static String contentType = "application/json";
    public static Map<String, String> payload = null;
//    {
//        "id": 250,
//            "title": "EAT",
//            "description": "AUTOMATION",
//            "pageCount": 200,
//            "excerpt": "string",
//            "publishDate": "2024-08-24T15:12:47.996Z"
//    }

   @Test
   public void createNewBookWithPostRequest(){
        payload = new HashMap<String, String>();
        payload.put("title", "EAT");
        payload.put("id", "250");
        payload.put("description", "AUTOMATION");
        payload.put("pageCount", "200");
        payload.put("excerpt", "string");
        payload.put("publishDate", "2024-08-24T15:12:47.996Z");

       given().contentType(contentType).body(payload)
               .when()
               .post(urlPostRequest)
               .then()
               .statusCode(200);
   }

    @Test
    public void createNewBookWithPostRequestAndGetResponse(){
        payload = new HashMap<String, String>();
        payload.put("title", "EAT");
        payload.put("id", "250");
        payload.put("description", "AUTOMATION");
        payload.put("pageCount", "200");
        payload.put("excerpt", "string");
        payload.put("publishDate", "2024-08-24T15:12:47.996Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test
    public void createNewBookWithPostRequestAndVerifyResponse(){
        payload = new HashMap<String, String>();
        payload.put("title", "ABC");
        payload.put("id", "250");
        payload.put("description", "AUTOMATION");
        payload.put("pageCount", "200");
        payload.put("excerpt", "string");
        payload.put("publishDate", "2024-08-24T15:12:47.996Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("title", equalTo("ABC"));
    }


















    @Test
    public static void validateResponseCodeInPostMethod(){
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("title", "Book 101");
        payload.put("description", "this book we are creating for testing purpose");
        payload.put("pageCount", "1");
        payload.put("excerpt", "testing");
        payload.put("publishDate","2023-12-16T16:44:59.059Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200);
    }
}
