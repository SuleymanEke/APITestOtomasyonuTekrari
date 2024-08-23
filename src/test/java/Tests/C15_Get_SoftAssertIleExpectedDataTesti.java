package Tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {
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
    public void test01() {

        //1 - Request Body ve End-Point hazirlama
        String url = "https://dummy.restapiexample.com/api/v1/employee/3";


        //2 - Expected Data hazirlama
        JSONObject expectedData = new JSONObject();
        JSONObject dataBilgileriJson = new JSONObject();

        dataBilgileriJson.put("id", 3);
        dataBilgileriJson.put("employee_name", "Ashton Cox");
        dataBilgileriJson.put("employee_salary", 86000);
        dataBilgileriJson.put("employee_age", 66);
        dataBilgileriJson.put("profile_image", "");

        expectedData.put("status", "success");
        expectedData.put("data", dataBilgileriJson);
        expectedData.put("message", "Successfully! Record has been fetched.");

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion

        JsonPath jsn = response.jsonPath();
        System.out.println("Id: " + jsn.getInt("data.id"));
        System.out.println("Employee Name: " + jsn.getString("data.employee_name"));
        System.out.println("Employee Salary: " + jsn.getString("data.employee_salary"));
        System.out.println("Employee Age: " + jsn.getString("data.employee_age"));
        System.out.println("Employee Profile Image: " + jsn.getString("data.profile_image"));
        System.out.println("Message: " + jsn.getString("message"));
        System.out.println("Status: " + jsn.getString("status"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(jsn.get("status"), expectedData.get("status"));
        softAssert.assertEquals(jsn.get("message"), expectedData.get("message"));

        softAssert.assertEquals(jsn.get("data.id"), expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(jsn.get("data.employee_name"), expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jsn.get("data.employee_salary"), expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jsn.get("data.employee_age"), expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(jsn.get("data.profile_image"), expectedData.getJSONObject("data").get("profile_image"));

        softAssert.assertAll();


    }
}
