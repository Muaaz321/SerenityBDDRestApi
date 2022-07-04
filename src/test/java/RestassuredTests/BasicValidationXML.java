package RestassuredTests;


import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
*
* Verifing Single content in XML response
* Verifing Multiple contents in XML response
* Verifing all the content in XML response in one go
* Xpath with text() function
* Find values using XML path in XML response
*
* */


import io.cucumber.java.en.Then;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Alphanumeric;

@RunWith(SerenityRunner.class)
@OrderWith(Alphanumeric.class)
public class BasicValidationXML {

    // Verifing Single content in XML response

    @Test
    public void testSingleContent(){
        given()
                .when()
                    .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                    .body("CUSTOMER.ID",equalTo("15"))
                .log().all();
    }

    // Verifing Multiple content in XML response

    @Test
    public void multipleSingleContent(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body("CUSTOMER.ID",equalTo("15"))
                .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
                .body("CUSTOMER.LASTNAME",equalTo("Clancy"))
                .body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
                .body("CUSTOMER.CITY",equalTo("Seattle"))
                .log().all();
    }


   //  Verifing all the content in XML response in one go / Xpath with text() function

    @Test
    public void multipleSingleContentOnego(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"))
                .log().all();
    }


    //Find values using XML path in XML response

    @Test
    public void testUsingXpath1(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                .then()
                .body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
                .body(hasXPath("/CUSTOMER/LASTNAME",containsString("Clancy")))
                .body(hasXPath("/CUSTOMER/STREET",containsString("319 Upland Pl.")))
                .body(hasXPath("/CUSTOMER/CITY",containsString("Seattle")))
                .log().all();
    }

    @Test
    public void testUsingXpath2(){
        given()
                .when()
                .get("http://thomas-bayer.com/sqlrest/INVOICE/")
                .then()
                .body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
                .log().all();
    }




}
