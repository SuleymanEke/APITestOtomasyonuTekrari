package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezvTarihleri = new JSONObject();

        rezvTarihleri.put("checkin", "2023-11-10");
        rezvTarihleri.put("checkout", "2023-11-20");

        requestBody.put("firstname", "Volkan");
        requestBody.put("lastname", "Konak");
        requestBody.put("totalprice", 610);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", rezvTarihleri);
        requestBody.put("additionalneeds", "Goklerde Kartal Gibiydim");
        //System.out.println("Request Body: " + requestBody.toString());

        //2 - Expected Data hazirlama
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingId", 61);
        expectedData.put("booking", requestBody);
        //System.out.println("Expected Data: " + expectedData.toString());


        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .post(url);
        response.prettyPrint();


        //4 - Assertion
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking")
                .get("firstname"), responseJsonPath.get("booking.firstname"));
        System.out.println("First Name: " + responseJsonPath.getString("booking.firstname"));

        assertEquals(expectedData.getJSONObject("booking")
                .get("lastname"), responseJsonPath.get("booking.lastname"));
        System.out.println("Last Name: " + responseJsonPath.getString("booking.lastname"));

        assertEquals(expectedData.getJSONObject("booking")
                .get("totalprice"), responseJsonPath.get("booking.totalprice"));
        System.out.println("Total Price: " + responseJsonPath.getInt("booking.totalprice"));

        assertEquals(expectedData.getJSONObject("booking")
                .get("depositpaid"), responseJsonPath.get("booking.depositpaid"));
        System.out.println("Deposidpaid: " + responseJsonPath.getBoolean("booking.depositpaid"));

        assertEquals(expectedData.getJSONObject("booking")
                .get("additionalneeds"), responseJsonPath.get("booking.additionalneeds"));
        System.out.println("Additionalneeds: " + responseJsonPath.getString("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking")
                .getJSONObject("bookingdates").get("checkin"), responseJsonPath
                .get("booking.bookingdates.checkin"));
        System.out.println("Checkin: " + responseJsonPath.getString("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking")
                .getJSONObject("bookingdates").get("checkout"), responseJsonPath
                .get("booking.bookingdates.checkout"));
        System.out.println("Checkout: " + responseJsonPath.getString("booking.bookingdates.checkout"));


    }
}
