package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuappApi {
    protected RequestSpecification specHerokuapp;

    @Before
    public void setup() {
        specHerokuapp = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setContentType(ContentType.JSON).build();

    }

}
