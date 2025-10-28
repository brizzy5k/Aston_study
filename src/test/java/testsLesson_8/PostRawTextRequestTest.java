package testsLesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostRawTextRequestTest {

    @Test
    public void testPostRequest(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .body("This is expected to be sent back as part of response body.")
                .post("/post")
                .then()
                .log()
                .body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
