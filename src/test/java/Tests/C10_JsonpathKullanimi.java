package Tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonpathKullanimi {

    @Test
    public void method01() {
        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject adresBilgileriJsonObj = new JSONObject();

        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelefonuJsonObj = new JSONObject();
        JSONObject evTelefonuJsonObj = new JSONObject();

        adresBilgileriJsonObj.put("streetAddress", "Pine Street");
        adresBilgileriJsonObj.put("city", "Nara");
        adresBilgileriJsonObj.put("postalCode", "630-0192");

        cepTelefonuJsonObj.put("type", "iPohone");
        cepTelefonuJsonObj.put("number", "0123-4567-8888");
        evTelefonuJsonObj.put("type", "home");
        evTelefonuJsonObj.put("number", "0123-4567-8910");
        telefonBilgileriArr.put(cepTelefonuJsonObj);
        telefonBilgileriArr.put(evTelefonuJsonObj);

        kisiBilgileriJsonObj.put("firstName", "John");
        kisiBilgileriJsonObj.put("lastName", "Doe");
        kisiBilgileriJsonObj.put("age", 26);
        kisiBilgileriJsonObj.put("address", adresBilgileriJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers", telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);
        System.out.println("First Name: " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("Last Name: " + kisiBilgileriJsonObj.get("lastName"));
//        System.out.println("Cadde: " + kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
//        System.out.println("Cadde: " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));
//        System.out.println("Posta Kodu: " + kisiBilgileriJsonObj.getJSONObject("address").get("postalCode"));
//        System.out.println("Cep Telefonu: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
//        System.out.println("Ev Telefonu: "+kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));
        System.out.println("Adres Bilgileri: " + kisiBilgileriJsonObj.getJSONObject("address"));
        System.out.println("Cadde: " + kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("City: " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));
        System.out.println("Posta Kodu: " + kisiBilgileriJsonObj.getJSONObject("address").get("postalCode"));

        System.out.println("Cep Telefonu Turu: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Cep Telefonu Nosu: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Ev Telefonu Turu: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("Ev Telefonu: "+kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));



        //1 - Request Body ve End-Point hazirlama
        //2 - Expected Data hazirlama
        //3 - Request gonderip, donen Response'i kaydetme
        //4 - Assertion

    }
}
