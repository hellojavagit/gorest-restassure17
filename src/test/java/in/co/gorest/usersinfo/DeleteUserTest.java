package in.co.gorest.usersinfo;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest extends TestBase {
    @Test
    public void deleteUser() {

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 57c4fad1064029dd06a46f13e636994a133c8f90239026665b53365529904944")
                .pathParam("id", "16322")
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();

    }
}