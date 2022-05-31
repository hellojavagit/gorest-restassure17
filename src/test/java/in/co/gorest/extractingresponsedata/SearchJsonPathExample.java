package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
        //RestAssured.basePath = "users";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }


    // 1) Total records are 20
    @Test
    public void test001() {
      List<?> records = response.extract().path("");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of records are  : " + records.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //id 2670 has name = "id 2492 has name = "Fr. Gatik Ahluwalia""
    @Test
    public void test002() {
        List<?> name  = response.extract().path("findAll{it.id==2670}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 2670 name is : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    // 3.id 2483 has email = "birjesh_acharya@brown.net"
    @Test
    public void test003() {
      List<?> email = response.extract().path("findAll{it.id==2665}.email");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("id 2483 has email : " + email);
        System.out.println("------------------End of Test---------------------------");
    }

    // 4) All ID has status = "active"
    @Test
    public void test004() {

        List<?> status= response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Ids has status : " +status);
        System.out.println("------------------End of Test---------------------------");

    }

    // 5).id 2472 has gender = "female"
    @Test
    public void test005() {
        List<?> femgender = response.extract().path("findAll{it.id==2660}.gender");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("gender of id 2653 is  : " + femgender);
        System.out.println("------------------End of Test---------------------------");
    }

    // 6) id 2471 has gender = "male"
    @Test
    public void test006() {

        List<?> gender = response.extract().path("findAll{it.id==2661}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Gender of id 2652 is :  " + gender);
        System.out.println("------------------End of Test---------------------------");
    }



}
