package Tests;

import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholderApi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specJsonPlaceHolder.pathParam("first", "posts");

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().spec(specJsonPlaceHolder).get("{first}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("title", hasSize(100));

        //4 - Assertion
    }

    @Test
    public void test02() {
        //1 - Request Body ve End-Point hazirlama
        specJsonPlaceHolder.pathParams("first", "posts", "second", 44);

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().spec(specJsonPlaceHolder).get("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion
        response.
                then().
                assertThat().
                statusCode(200).
                body("title", Matchers.equalTo("optio dolor molestias sit"));


    }
}
