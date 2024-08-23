package Tests;

import TestDatalari.TestDataJsonPlaceholder;
import baseUrl.BaseUrlJsonPlaceholderApi;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceholderApi {
    /*
    {
    "id": 70,
    "title": "Recep Ivedik",
    "body": "Ekinler bas vermeden kor buzağı topallamaz!",
    "userId": 3169
    }
     */

    @Test
    public void put() {
        //1 - Request Body ve End-Point hazirlama.
        specJsonPlaceHolder.pathParams("first", "posts", "second", 70);
        //TestDataJsonPlaceholder obj = new TestDataJsonPlaceholder();
        Map<String, Object> requestBodyMap = TestDataJsonPlaceholder.bodyOlusturMap(70, "Recep Ivedik",
                "Ekinler bas vermeden kor buzağı topallamaz!", 3169);

        //2 - Expected Data hazirlama.
        Map<String, Object> expectedData = TestDataJsonPlaceholder.bodyOlusturMap(70, "Recep Ivedik",
                "Ekinler bas vermeden kor buzağı topallamaz!", 3169);

        //3 - Request gonderip, donen Response'i kaydetme.
        Response response = given(specJsonPlaceHolder).when().body(requestBodyMap).put("{first}/{second}");
        response.prettyPrint();

        //4 - Assertion.
        Map<String, Object> responseMap = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(TestDataJsonPlaceholder.contentType, response.contentType());

        assertEquals(expectedData.get("id"), responseMap.get("id"));
        assertEquals(expectedData.get("title"), responseMap.get("title"));
        assertEquals(expectedData.get("body"), responseMap.get("body"));
        assertEquals(expectedData.get("userId"), responseMap.get("userId"));


    }

}
