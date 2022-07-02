package RestassuredTests;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@RunWith(SerenityRunner.class)
public class Put_Request {

    public static HashMap map=new HashMap();


    public static String first_Name = "Emma";

    @BeforeClass
    public static void putData(){
        map.put("name",restUtils.getName());
        map.put("job",restUtils.getJob());

        baseURI = "https://reqres.in/api/";
        basePath = "users/update/"+first_Name;
    }


    @Test
    public void testPut(){
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all();
    }

}
