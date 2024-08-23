package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_ResponseBodyTesti {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", Matchers.equalTo(44))
                .body("userId", Matchers.equalTo(5))
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
    }
}
