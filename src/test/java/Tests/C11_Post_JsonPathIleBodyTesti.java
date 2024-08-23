package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class C11_Post_JsonPathIleBodyTesti {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleri = new JSONObject();

        rezervasyonTarihleri.put("checkin", "2023-01-10");
        rezervasyonTarihleri.put("checkout", "2023-01-20");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 369);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", rezervasyonTarihleri);
        requestBody.put("additionalneeds", "Salih abi");

        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);
        response.prettyPrint();

        //4 - Assertion

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("booking.firstname", equalTo("Recep"),
                        "booking.lastname", equalTo("Ivedik"),
                        "booking.totalprice", equalTo(369),
                        "booking.depositpaid", equalTo(true),
                        "booking.bookingdates.checkin", equalTo("2023-01-10"),
                        "booking.bookingdates.checkout", equalTo("2023-01-20"),
                        "booking.additionalneeds", equalTo("Salih abi"));

    }
}
