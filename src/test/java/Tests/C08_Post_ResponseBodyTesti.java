package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API");
        requestBody.put("body", "API ogrenmek ne guzel!");
        requestBody.put("userId", 10);
        System.out.println("Request Body: " + requestBody);

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);
        response.prettyPrint();

        //4 - Assertion
        response.then().assertThat().statusCode(201).contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("body", Matchers.containsString("API ogrenmek ne guzel!"))
                .body("userId", Matchers.lessThan(100));


    }
}
