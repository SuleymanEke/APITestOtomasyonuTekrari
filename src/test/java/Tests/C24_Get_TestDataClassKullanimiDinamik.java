package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Get_TestDataClassKullanimiDinamik extends BaseUrlJsonPlaceholderApi {
    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        specJsonPlaceHolder.pathParams("first", "posts", "second", 40);

        //2 - Expected Data hazirlama
        JSONObject expectedData = TestDataJsonPlaceholder.jsonBodyOlustur(4, 40, "enim quo cumque", "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

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
