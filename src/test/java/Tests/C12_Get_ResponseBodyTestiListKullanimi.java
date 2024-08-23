package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C12_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://dummy.restapiexample.com/api/v1/employees";

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("data.id", hasSize(24),
                        "data.employee_name", hasItem("Ashton Cox"),
                        "data.employee_age", hasItems(61, 21, 35));



    }
}
