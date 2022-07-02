package RestassuredTests;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class Post_Request {

        public static HashMap map= new HashMap();

        @BeforeClass
        public static void postData(){
                map.put("name",restUtils.getName());
                map.put("job",restUtils.getJob());
                RestAssured.baseURI = "https://reqres.in/api";
                RestAssured.basePath = "/users";
        }

        @Test
        public void testPost(){
                given()
                        .contentType("application/json")
                        .body(map)
                                .when()
                                        .post()
                        .then()
                                .statusCode(201)
                        .body("$",hasKey("createdAt"))
                        .and()
                        .body("$",hasKey("createdAt"));

                //.body("SuccessCode","OPERATION SUCCESS")
                //.body("Message" , "Success")
        }



}
