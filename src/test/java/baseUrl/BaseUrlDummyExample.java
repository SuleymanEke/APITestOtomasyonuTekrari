package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlDummyExample {
    protected RequestSpecification specDummyExample;

    @Before
    public void setup() {
        specDummyExample = new RequestSpecBuilder()
                .setBaseUri("https://dummy.restapiexample.com/api/v1")
                .setContentType(ContentType.JSON).build();

    }

}
