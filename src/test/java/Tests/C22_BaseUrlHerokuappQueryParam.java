package Tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuappApi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specHerokuapp.pathParam("first", "booking")
                .queryParams("firstname", "Eric", "second", "Wilson");

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given(specHerokuapp).when().get("{first}");
        response.prettyPrint();


        //4 - Assertion
        response.then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("bookingid", Matchers.hasSize(4));

    }


}
