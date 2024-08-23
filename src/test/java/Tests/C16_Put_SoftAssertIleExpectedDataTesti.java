package Tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody = new JSONObject();
        JSONObject dataBilgileriJson = new JSONObject();

        dataBilgileriJson.put("name", "Ahmet");
        dataBilgileriJson.put("salary", "1230");
        dataBilgileriJson.put("age", "44");
        dataBilgileriJson.put("id", 40);

        requestBody.put("status", "success");
        requestBody.put("data", dataBilgileriJson);

        System.out.println("Request Body: " + requestBody.toString());
        System.out.println("xxxxxxxxxxxxxxxxxxxx Request Body xxxxxxxxxxxxxxxxxxxx");

        //2 - Expected Data hazirlama
        JSONObject expedtedData = new JSONObject();
        expedtedData.put("status", "success");
        expedtedData.put("data", requestBody);
        expedtedData.put("message", "Successfully! Record has been updates.");

        System.out.println("Expected Data: " + expedtedData.toString());
        System.out.println("xxxxxxxxxxxxxxxxxxxx Expected Data xxxxxxxxxxxxxxxxxxxx");

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().contentType(ContentType.JSON).when().body(requestBody.toString()).put(url);
        response.prettyPrint();
        System.out.println("xxxxxxxxxxxxxxxxxxxx Response xxxxxxxxxxxxxxxxxxxx");

        //4 - Assertion

        JsonPath responseJsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"), expedtedData.get("status"));
        System.out.println("Status: " + responseJsonPath.getString("status"));

        softAssert.assertEquals(responseJsonPath.get("message"), expedtedData.get("message"));
        System.out.println("Message: " + responseJsonPath.getString("message"));

        softAssert.assertEquals(responseJsonPath.get("data.status"), expedtedData.getJSONObject("data").get("status"));
        System.out.println("Data Status: " + responseJsonPath.getString("data.status"));

        softAssert.assertEquals(responseJsonPath.get("data.data.name"), expedtedData.getJSONObject("data").getJSONObject("data").get("name"));
        System.out.println("Data Name: " + responseJsonPath.getString("data.data.name"));

        softAssert.assertEquals(responseJsonPath.get("data.data.id"), expedtedData.getJSONObject("data").getJSONObject("data").get("id"));
        System.out.println("Data Id: " + responseJsonPath.getInt("data.data.id"));

        softAssert.assertEquals(responseJsonPath.get("data.data.salary"), expedtedData.getJSONObject("data").getJSONObject("data").get("salary"));
        System.out.println("Data Salary: " + responseJsonPath.getString("data.data.salary"));

        softAssert.assertEquals(responseJsonPath.get("data.data.age"), expedtedData.getJSONObject("data").getJSONObject("data").get("age"));
        System.out.println("Data Age: " + responseJsonPath.getString("data.data.age"));

        softAssert.assertAll(); //Hata veriyor.


    }
}
