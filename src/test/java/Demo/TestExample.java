package Demo;

import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class TestExample {

    @Test
    @Ignore
    public void Test1(){

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status Code : "+response.getStatusCode());
        System.out.println("Time : "+response.getTime());


    }

}
