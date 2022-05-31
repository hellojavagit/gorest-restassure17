package in.co.gorest.usersinfo;

import in.co.gorest.model.UsersPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest extends TestBase {
    @Test
    public void createUser() {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName("Tenali Ramakrishna");
        usersPojo.setEmail("tenali.ramakrishna111@gmail.com");
        usersPojo.setGender("female");
        usersPojo.setStatus("active");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .body(usersPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
