package testsLesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRequestTest {

    @Test
    public void testGetRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .log()
                .body()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }
}