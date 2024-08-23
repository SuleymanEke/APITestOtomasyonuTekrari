package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceholderApi {
    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specJsonPlaceHolder.pathParams("first", "posts", "second", 22);

        //2 - Expected Data hazirlama
        JSONObject expectedData = TestDataJsonPlaceholder.responseBodyOlustur22();
        System.out.println("Expected data: "+expectedData);

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().spec(specJsonPlaceHolder).when().get("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion
        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(TestDataJsonPlaceholder.basariliSorguStatusCode, response.statusCode());
        assertEquals(expectedData.getInt("userId"), responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"), responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"), responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"), responseJsonPath.getString("body"));

    }


}
