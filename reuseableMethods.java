import io.restassured.path.json.JsonPath;

public class reuseableMethods {


    public static JsonPath rawToJson(String response){
        JsonPath js=new JsonPath(response);
        return js;
    }





}
