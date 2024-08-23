package Tests;

import Pojos.PojoDummyExample.PojoDummyExampleData;
import Pojos.PojoDummyExample.PojoDummyExampleResponse;
import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C33_Get_Pojo extends BaseUrlDummyExample {

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
    public void test33() {
        //1 - Request url ve body olustur
        specDummyExample.pathParams("pp1", "employee", "pp2", "3");


        //2 - Soruda varsa expected data olustur
        PojoDummyExampleData dataPojo = new PojoDummyExampleData(3, "Ashton Cox", 86000, 66, "");
        PojoDummyExampleResponse expectedResponsePojo = new PojoDummyExampleResponse("success", dataPojo, "Successfully! Record has been fetched.");

        //3 - Response olustur, request gonderip sonucu response'i ata
        Response response = given(specDummyExample).when().get("{pp1}/{pp2}");
        response.prettyPrint();

        //4 - Assertion
//        PojoDummyExampleResponse responsePojo = response.as(PojoDummyExampleResponse.class);

        JsonPath responseJP = response.jsonPath();

        assertEquals(expectedResponsePojo.getStatus(), responseJP.getString("status"));
        assertEquals(expectedResponsePojo.getMessage(), responseJP.getString("message"));
        assertEquals(expectedResponsePojo.getData().getId(), responseJP.getInt("data.id"));
        assertEquals(expectedResponsePojo.getData().getEmployee_name(), responseJP.getString("data.employee_name"));
        assertEquals(expectedResponsePojo.getData().getEmployee_salary(), responseJP.getInt("data.employee_salary"));
        assertEquals(expectedResponsePojo.getData().getEmployee_age(), responseJP.getInt("data.employee_age"));
        assertEquals(expectedResponsePojo.getData().getProfile_image(), responseJP.getString("data.profile_image"));

    }
}
