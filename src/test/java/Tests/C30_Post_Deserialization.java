package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuappApi;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuappApi {
    /*
    {
        "bookingid": 8006,
            "booking": {
        "firstname": "Recep",
                "lastname": "Ivedik",
                "totalprice": 3169,
                "depositpaid": true,
                "bookingdates": {
            "checkin": "2024-06-06",
                    "checkout": "2023-07-07"
        },
        "additionalneeds": "Ekinler bas vermeden kor buzağı topallamaz!"
    }
     */

    @Test
    public void post30() {
        //1 - Request Body ve End-Point hazirlama.
        specHerokuapp.pathParam("first", "booking");
        Map<String, Object> requestBodyMap = TestDataHerokuapp.requestBodyMapOlustur();
        //System.out.println(requestBodyMap);

        //2 - Expected Data hazirlama.

        Map<String, Object> expectedData = TestDataHerokuapp.responseBodyMapOlustur();
        //System.out.println(expectedData);

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given(specHerokuapp).when().body(requestBodyMap).post("{first}");
        response.prettyPrint();

        //4 - Assertion.
        Map<String, Object> responseMap = response.as(HashMap.class);
        //System.out.println(responseMap);

        assertEquals(TestDataHerokuapp.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataHerokuapp.contentType, response.contentType());

        assertEquals(((Map) expectedData.get("booking")).get("firstname"), ((Map) responseMap.get("booking")).get("firstname"));
        assertEquals(((Map) expectedData.get("booking")).get("lastname"), ((Map) responseMap.get("booking")).get("lastname"));
        assertEquals(((Map) expectedData.get("booking")).get("totalprice"), ((Map) responseMap.get("booking")).get("totalprice"));
        assertEquals(((Map) expectedData.get("booking")).get("depositpaid"), ((Map) responseMap.get("booking")).get("depositpaid"));
        assertEquals(((Map) expectedData.get("booking")).get("additionalneeds"), ((Map) responseMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map) ((Map) expectedData.get("booking")).get("bookingdates")).get("checkin"),
                ((Map) ((Map) responseMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map) ((Map) expectedData.get("booking")).get("bookingdates")).get("checkout"),
                ((Map) ((Map) responseMap.get("booking")).get("bookingdates")).get("checkout"));


    }
}
