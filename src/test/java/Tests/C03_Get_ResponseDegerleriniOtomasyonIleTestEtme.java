package Tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniOtomasyonIleTestEtme {

    @Test
    public void test02() {
        /*
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'un,
    Status Code'un 200,
    ve Content Type'inin application/json; charset=utf-8,
    ve Server isimli Header'in degerinin Cowboy,
    ve Status Line'i HTTP/1.1 200 OK,
    ve Response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
    */

        //1 - Request Body ve End-Point hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected Data hazirlama

        //3 - Request gonderip, donen Response'i kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        //4 - Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");

    }
}
