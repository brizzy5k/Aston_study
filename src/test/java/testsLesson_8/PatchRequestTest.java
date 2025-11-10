package testsLesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest {
    @Test
    public void testPatchRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log()
                .body()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
