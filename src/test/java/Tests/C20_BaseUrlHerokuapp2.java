package Tests;

import baseUrl.BaseUrlHerokuappApi;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C20_BaseUrlHerokuapp2 extends BaseUrlHerokuappApi {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specHerokuapp.pathParam("first", "booking");

        JSONObject requestBody = new JSONObject();
        JSONObject rzvTarihleri = new JSONObject();

        rzvTarihleri.put("checkin", "2023-06-01");
        rzvTarihleri.put("checkout", "2023-06-10");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", rzvTarihleri);
        requestBody.put("additionalneeds", "Konusma laaan!");

        //System.out.println(requestBody.toString());


        //2 - Expected Data hazirlama
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("booking", requestBody);
        //System.out.println(expectedBody.toString());

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given(specHerokuapp).
                contentType(ContentType.JSON).
                when().
                body(requestBody.toString()).
                post("{first}");
        response.prettyPrint();

        //4 - Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", Matchers.equalTo("Recep"),
                        "booking.lastname", Matchers.equalTo("Ivedik"),
                        "booking.totalprice", Matchers.equalTo(500),
                        "booking.depositpaid", Matchers.equalTo(false),
                        "booking.bookingdates.checkin", Matchers.equalTo("2023-06-01"),
                        "booking.bookingdates.checkout", Matchers.equalTo("2023-06-10"),
                        "booking.additionalneeds", Matchers.equalTo("Konusma laaan!"));

        JsonPath json = response.jsonPath();
        assertEquals(expectedBody.getJSONObject("booking").get("firstname"), json.get("booking.firstname"));
        System.out.println(json.getString("booking.firstname"));

        assertEquals(expectedBody.getJSONObject("booking").get("lastname"), json.get("booking.lastname"));
        System.out.println(json.getString("booking.lastname"));

        assertEquals(expectedBody.getJSONObject("booking").get("totalprice"), json.get("booking.totalprice"));
        System.out.println(json.getString("booking.totalprice"));

        assertEquals(expectedBody.getJSONObject("booking").get("depositpaid"), json.get("booking.depositpaid"));
        System.out.println(json.getString("booking.depositpaid"));

        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                json.get("booking.bookingdates.checkin"));
        System.out.println(json.getString("booking.bookingdates.checkin"));

        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                json.get("booking.bookingdates.checkout"));
        System.out.println(json.getString("booking.bookingdates.checkout"));

        assertEquals(expectedBody.getJSONObject("booking").get("additionalneeds"),
                json.getString("booking.additionalneeds"));
        System.out.println(json.getString("booking.additionalneeds"));
    }


}
