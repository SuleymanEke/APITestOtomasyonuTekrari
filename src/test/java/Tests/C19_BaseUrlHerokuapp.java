package Tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuappApi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specHerokuapp.pathParam("first", "booking");
        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given(specHerokuapp).when().get("{first}");
        //response.prettyPrint();
        //4 - Assertion
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", hasSize(greaterThan(290)));

        JsonPath responseJsonPath = response.jsonPath();
        //System.out.println(responseJsonPath.getString("bookingid"));
        System.out.println("Booking Id: "+responseJsonPath.getList("bookingid").size());


    }


}
