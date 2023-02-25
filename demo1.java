import static io.restassured.RestAssured.*;
import  io.restassured.RestAssured;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;



public class demo1 {

    @Test
    public void ApiTest(){

        //Get method
        RestAssured.baseURI="https://reqres.in/";
        String response=given().log().all().when().get("/api/users/2").then().assertThat().statusCode(200).extract().asString();
        System.out.println(response);

        String placeId=reuseableMethods.rawToJson(response).getString("data.email");
        System.out.println(placeId);

        //post method
        String postResponse=given().log().all().body(payLoad.addName()).when().post("/api/users?page=2").then().assertThat().statusCode(201).extract().asString();

        //put method
        String putResponse=given().log().all().body(payLoad.updateJob()).when().put("/api/users/2").then().assertThat().statusCode(200).extract().asString();

    }
}
