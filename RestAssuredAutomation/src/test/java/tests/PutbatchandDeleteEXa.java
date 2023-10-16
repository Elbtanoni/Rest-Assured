package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutbatchandDeleteEXa {

@Test
public void Testput() {
	   baseURI = "https://reqres.in/api/";
       JSONObject request = new JSONObject();
       request.put ("name","ahmed");
       request.put("job","tester");
       System.out.println(request.toJSONString());
        given().
          header("Content-Type","Application/json").
          contentType(ContentType.JSON).
          accept(ContentType.JSON).
          body(request.toJSONString()).
          when().
          put("users/2").
          then().
          statusCode(200).log().all();
}
@Test
public void Testpatch() {
	   baseURI = "https://reqres.in/api/";
    JSONObject request = new JSONObject();
    request.put ("name","Ali");
    request.put("job","tester");
    System.out.println(request.toJSONString());
     given().
       header("Content-Type","Application/json").
       contentType(ContentType.JSON).
       accept(ContentType.JSON).
       body(request.toJSONString()).
       when().
       patch("users/2").
       then().
       statusCode(200).log().all();
}
@Test
public void TestDelete() {
	   baseURI = "https://reqres.in/api/";
    JSONObject request = new JSONObject();
    request.put ("name","Ali");
    request.put("job","tester");
    System.out.println(request.toJSONString());
     given().
       header("Content-Type","Application/json").
       contentType(ContentType.JSON).
       accept(ContentType.JSON).
       body(request.toJSONString()).
       when().
       delete("users/2").
       then().
       statusCode(204).log().all();
}

}
