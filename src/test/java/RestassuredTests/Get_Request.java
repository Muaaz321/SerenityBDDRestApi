package RestassuredTests;

import io.cucumber.junit.Cucumber;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


/**
 * given()
 *      set cookies , add auth , add param , set headers info etc ...
 * when()
 *      get , post , put , delete
 *
 * then()
 *      validate status code , extract response , extract headers cookies and response body
 */

@RunWith(SerenityRunner.class)
public class Get_Request {

    @Test
    public void getEmployeeDetails(){
            given()
                    .when().get("https://reqres.in/api/users/2")
                        .then()
                            .statusCode(200)
                            .statusLine("HTTP/1.1 200 OK")
                            .assertThat()
                    .body("data.email",equalTo("janet.weaver@reqres.in"))
                    .body("data.id",equalTo(2))
                    .body("data.first_name",equalTo("Janet"))
                    .body("data.last_name",equalTo("Weaver"))
                    .body("data.avatar",equalTo("https://reqres.in/img/faces/2-image.jpg"))
                    .body("support.url",equalTo("https://reqres.in/#support-heading"))
                    .body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                    .header("Content-Type","application/json; charset=utf-8");
    }
}
