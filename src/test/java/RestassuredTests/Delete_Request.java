package RestassuredTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@RunWith(SerenityRunner.class)
public class Delete_Request {

    @Test
    public void deleteEmployeeRecord(){

        RestAssured.baseURI = "https://reqres.in/api/";
        RestAssured.basePath = "/users/11";


        //placing response in to a variable
        Response response=
        given()
                .when()
                    .delete()
                .then()
                    .statusCode(204)
                    .statusLine("HTTP/1.1 204 No Content")
                    .log().all()
                    .extract().response();

       String jsonAsString =  response.asString();
       //Assert.assertEquals(jsonAsString.contains("successfully deleted records "),true);


    }

}
