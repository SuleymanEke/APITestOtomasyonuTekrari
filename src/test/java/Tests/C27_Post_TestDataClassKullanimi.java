package Tests;

import TestDatalari.TestDataHerokuapp;
import baseUrl.BaseUrlHerokuappApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataClassKullanimi extends BaseUrlHerokuappApi {
    /*
    {
        "firstname": "Recep",
            "lastname": "Ivedik",
            "totalprice": 3169,
            "depositpaid": true,
            "bookingdates": {
        "checkin": "2018-06-06",
                "checkout": "2019-07-07"
    },
        "additionalneeds": "Ne var laaa?!"
    }
     */

    @Test
    public void get27() {

        //1 - Request Body ve End-Point hazirlama.
        //2 - Expected Data hazirlama.
        //3 - Request gonderip, donen Response'i kaydetme.
        //4 - Assertion.



    }
}
