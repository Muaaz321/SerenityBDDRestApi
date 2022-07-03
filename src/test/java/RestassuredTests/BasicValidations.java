package RestassuredTests;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.assertj.core.internal.bytebuddy.build.Plugin;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
*
* Test Status Code
* Log Response
* Verify Single content in Response body
* Verify Multiple content in response body
* Setting parameter & header
*
*
* */


@RunWith(SerenityRunner.class)
public class BasicValidations {

        // Test Status code
        @Test()
        public void testStatusCode(){

            given()
                    .when()
                        .get("https://reqres.in/api/users/9")
                    .then()
                        .statusCode(200);
                        //.log().all();


        }

        // Log response
        @Test
        public void testLogging()
        {
            given()
                    .when()
                    .get("https://reqres.in/api/unknown/1")
                    .then()
                    .statusCode(200)
                    .log().all();
        }


    // Verify Single content in Response body
    @Test
    public void testSingleContent()
    {
        given()
                .when()
                .get("https://reqres.in/api/unknown/1")
                .then()
                .statusCode(200)
                .body("data.name",equalTo("cerulean"));
    }

    // Verify Multiple content in response body
    @Test
    public void testMultipleContents()
    {
        given()
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .statusCode(200)
                .body("data.name",hasItems("cerulean","fuchsia rose","true red","aqua sky","tigerlily","blue turquoise"));
    }


    // Setting parameter & header
    @Test
    public void testParameterandHeader()
    {
        given().param("myName","Muaaz")
                .header("myHeader","SriLanka")
                .when()
                .get("https://reqres.in/api/unknown/")
                .then()
                .statusCode(200)
                .log().all();
                  }

}