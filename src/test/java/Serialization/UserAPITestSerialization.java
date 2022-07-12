package Serialization;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

@RunWith(SerenityRunner.class)
public class UserAPITestSerialization {


    @Test
    public void createNewEmployeeSerialization(){

        UserAPIemployee employee = new UserAPIemployee();
        employee.setId(101);
        employee.setFirstName("Muaaz");
        employee.setLastName("Mohideen");
        employee.setEmail("test@gmail.com");
        employee.setProgramme("Programme employee");

        /*
        *  for json sub object
        *
        * ArrayList<String> courseList = new ArrayList<String>();
        * courseList.add("Java")
        * courseList.add("selenium")
        *
        * setting above array to the Object
        * employee.setCourses(courseList);
        *
        * */


        given()
                .contentType(ContentType.JSON)
                .body(employee)
                    .when()
                            .post("https://dummy.restapiexample.com/api/v1/employee/")
                                    .then()
                                            .statusCode(201)
                                            .assertThat().body("msg",equalTo("Employee added"));
    }

    @Test
    public void getEmployeeDeserilization(){

        UserAPIemployee employee =
                get("https://dummy.restapiexample.com/api/v1/employees/101").as(UserAPIemployee.class);

        System.out.println(employee.getEmployeeRecord());
        Long empId = Long.valueOf(101);

        Assert.assertEquals(employee.getId(),empId);



    }

}
