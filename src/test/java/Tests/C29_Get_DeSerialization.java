package Tests;

import TestDatalari.TestDataDummyExample;
import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {
    /*
    {
    "status": "success",
    "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
     */

    @Test
    public void get29() {

        //1 - Request Body ve End-Point hazirlama.
        specDummyExample.pathParams("first", "employee", "second", 3);

        //2 - Expected Data hazirlama.
        Map<String, Object> expectedData = TestDataDummyExample.mapBodyOlustur();
        //System.out.println("Expected Data:" + expectedData);

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given(specDummyExample).when().get("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion.
        Map<String, Object> responseMap = response.as(HashMap.class);
        //System.out.println("Actual Data: " + responseMap);

        assertEquals(TestDataDummyExample.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataDummyExample.contentType, response.contentType());

        assertEquals(expectedData.get("message"), responseMap.get("message"));
        assertEquals(expectedData.get("status"), responseMap.get("status"));
        assertEquals(((Map) expectedData.get("data")).get("profile_image"),
                ((Map) responseMap.get("data")).get("profile_image"));
        assertEquals(((Map) expectedData.get("data")).get("employee_name"),
                ((Map) responseMap.get("data")).get("employee_name"));
        assertEquals(((Map) expectedData.get("data")).get("employee_salary"),
                ((Map) responseMap.get("data")).get("employee_salary"));
        assertEquals(((Map) expectedData.get("data")).get("id"),
                ((Map) responseMap.get("data")).get("id"));
        assertEquals(((Map) responseMap.get("data")).get("employee_age"),
                ((Map) responseMap.get("data")).get("employee_age"));


    }

}
