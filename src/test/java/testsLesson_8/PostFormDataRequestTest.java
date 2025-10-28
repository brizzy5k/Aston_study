package testsLesson_8;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostFormDataRequestTest {

    @Test
    public void testPostRequest(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .when()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .post("/post")
                .then()
                .log()
                .body()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }
}
