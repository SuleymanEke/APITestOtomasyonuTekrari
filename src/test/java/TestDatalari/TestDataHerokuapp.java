package TestDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {
    public static int basariliSorguStatusCode = 200;
    public static String contentType = "application/json; charset=utf-8";
    public static String headerConnecion = "keep-alive";

    public static JSONObject jsonRequestBodyOlustur() {

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDatesBody = new JSONObject();

        bookingDatesBody.put("checkin", "2021-06-06");
        bookingDatesBody.put("checkout", "2021-07-07");

        requestBody.put("firstname", "Recep");
        requestBody.put("lastname", "Ivedik");
        requestBody.put("totalprice", 3169);
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", bookingDatesBody);
        requestBody.put("additionalneeds", "Ne var laaa?!");

        return requestBody;
    }

    public static JSONObject jsonResponseBodyOlustur() {
        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur();

        responseBody.put("bookingid", 30863);
        responseBody.put("booking", bookingBody);

        return responseBody;
    }

    public static Map<String, Object> requestBodyMapOlustur() {

        Map<String, Object> requestBodyMap = new HashMap<>();

        requestBodyMap.put("firstname", "Recep");
        requestBodyMap.put("lastname", "Ivedik");
        requestBodyMap.put("totalprice", 3169);
        requestBodyMap.put("depositpaid", true);
        requestBodyMap.put("bookingdates", bookingDatesMapOlustur());
        requestBodyMap.put("additionalneeds", "Ekinler bas vermeden kor buzağı topallamaz!");

        return requestBodyMap;
    }

    public static Map<String, String> bookingDatesMapOlustur() {

        Map<String, String> bookingDatesMap = new HashMap<>();

        bookingDatesMap.put("checkin", "2024-06-06");
        bookingDatesMap.put("checkout", "2023-07-07");

        return bookingDatesMap;
    }

    public static Map<String, Object> responseBodyMapOlustur() {

        Map<String, Object> responseBodyMap = new HashMap<>();

        responseBodyMap.put("bookingid", 8006);
        responseBodyMap.put("booking", requestBodyMapOlustur());

        return responseBodyMap;
    }


}
