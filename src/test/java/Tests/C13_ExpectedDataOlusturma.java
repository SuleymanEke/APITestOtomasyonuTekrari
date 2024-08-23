package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C13_ExpectedDataOlusturma {
    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        //2 - Expected Data hazirlama
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");
        expectedData.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", equalTo(3),
                        "id", equalTo(22),
                        "title", equalTo("dolor sint quo a velit explicabo quia nam"));

        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"), responseJsonPath.get("userId"));
        System.out.println("User Id: "+responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("id"), responseJsonPath.get("id"));
        System.out.println("Id: "+responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.get("title"), responseJsonPath.get("title"));
        System.out.println("Title: "+responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.get("body"), responseJsonPath.get("body"));
        System.out.println("Body: "+responseJsonPath.getString("body"));








    }
}
