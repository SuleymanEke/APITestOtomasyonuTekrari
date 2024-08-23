package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_TestYaparkenTekrarlardanKurtulma {
    /*
    https://restful-booker.herokuapp.com/booking/10 url'ine GET request gonderdigimizde donen Response'in
        status code'unun 200,
        ve content type'inin application-json,
        ve response body'sindeki
        "firstname"in "Susan",
        ve "lastname"in "Jackson",
        ve "totalprice"in 612,
        ve "depositpaid"in false'
        ve additionalneeds"in "Breakfast"
    oldugunu test edin.
     */

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"))
                .body("lastname", equalTo("Wilson"))
                .body("totalprice", lessThan(1000))
                .body("depositpaid", equalTo(true))
                .body("additionalneeds", Matchers.nullValue());

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Mary"))
                .body("lastname", equalTo("Wilson"))
                .body("totalprice", lessThan(1000))
                .body("depositpaid", equalTo(true))
                .body("additionalneeds", nullValue());


    }
}
