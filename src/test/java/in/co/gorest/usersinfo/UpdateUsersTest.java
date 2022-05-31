package in.co.gorest.usersinfo;

import in.co.gorest.model.UsersPojo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUsersTest  extends TestBase {
    @Test
    public void updateUser() {
        UsersPojo usersPojo = new UsersPojo();
        usersPojo.setName("testing my name");
        usersPojo.setEmail("testingmail@gmail.com");
        usersPojo.setStatus("active");
        usersPojo.setGender("female");

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .body(usersPojo)
                .pathParam("id", "3646")
                .when()
                .patch("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}


