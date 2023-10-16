package tests;

import org.apache.commons.logging.Log;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostEXa {
@Test
	public void TestGet() {
	baseURI = "https://reqres.in/api/";	
	given().
	   get("users?page=2").
	then().
	 statusCode(200).
	 body("data[2].first_name",equalTo("Tobias")).
	 body("data.last_name",hasItems("Ferguson","Edwards"));
	}
@Test
public void TestPost() {
	  Map<String,Object> map = new HashMap<String,Object>();
	  
	//   map.put("name","ahmed");  
    //   map.put("job","tester");	
    //   System.out.println(map);
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
          post("users").
          then().
          statusCode(201).log().all();
}
}
