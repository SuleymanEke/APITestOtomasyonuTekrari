package Tests;

import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlDummyRestapi2 extends BaseUrlJsonPlaceholderApi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specJsonPlaceHolder.pathParams("first", "posts", "second", 50);

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().spec(specJsonPlaceHolder).delete("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion
        response.then().assertThat().statusCode(200).body("title", Matchers.nullValue());

    }


}
