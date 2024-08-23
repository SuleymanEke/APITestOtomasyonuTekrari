package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceholderApi {

    @Test
    public void put25() {

        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolder.pathParams("first", "posts", "second", 70);
        JSONObject requestBody = TestDataJsonPlaceholder.jsonBodyOlustur(17, 70, "Recep Ivedik", "Konusma laaa !");

        //2 - Expected Data hazirlama.
        JSONObject expectedData = TestDataJsonPlaceholder.jsonBodyOlustur(17, 70, "Recep Ivedik", "Konusma laaa !");

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given(specJsonPlaceHolder).when().body(requestBody.toString()).put("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion.
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType, response.contentType());
        assertEquals(TestDataJsonPlaceholder.headerConnecion, response.getHeader("Connection"));

        assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));


    }
}
