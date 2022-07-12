package Serialization;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class UserAPITestNoSerialization {

    public HashMap employeeMap = new HashMap();


    // Post & Get Request without serialization and Deserialization
    @Test
    public void Postemloyee(){

        employeeMap.put("id",70);
        employeeMap.put("employee_name","muaazApi");
        employeeMap.put("employee_salary",75000);
        employeeMap.put("employee_age",38);
        employeeMap.put("profile_image","/src/image1.png");

        //if we have sub values in the object
        // create a Array list and put in the map

        /*
        ArrayList<String> courselist = new ArrayList<String>();
        courselist.add("Java");
        courselist.add("Selenium");
        employeeMap.put("Courses",courselist);
        */

        given()
                .contentType(ContentType.JSON)
                .body(employeeMap)
        .when()
                .post("https://dummy.restapiexample.com/api/v1/employee/")
                .then()
                .statusCode(201)
                .assertThat()
                .body("msg",equalTo("Student added"));
    }

    @Test
    public void Getemployee(){

        given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .statusCode(200)
                .assertThat()
                .body("id",equalTo(101));

    }





}
