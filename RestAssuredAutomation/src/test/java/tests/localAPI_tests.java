package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class localAPI_tests {
//@Test
	public void get() {
	baseURI = "http://localhost:3000";
	given().
	  get("/users").
	then().
	  statusCode(200).log().all();
	}
//@Test
public void post() {
	baseURI = "http://localhost:3000";
     JSONObject request = new JSONObject();
      request.put("firstName","Karem");
      request.put("lastName","Ali");
      request.put("subject",2);
      given().
        contentType(ContentType.JSON).
        accept(ContentType.JSON).
        body(request.toJSONString()).
      when().
         post("/users").
      then().
         statusCode(201).log().all();
}
//@Test
public void put() {
	baseURI = "http://localhost:3000";
	JSONObject request = new JSONObject();
	request.put("firstName","KHaled");
	request.put("lastName","Ali");
	request.put("subject",2);
	given().
	   contentType(ContentType.JSON).
	   accept(ContentType.JSON).
	   body(request.toJSONString()).
	when().
	    put("/users/4").
	then().
	    statusCode(200).log().all();
};

//@Test
public void patch() {
	baseURI = "http://localhost:3000";
	JSONObject request = new JSONObject();
	request.put("lastName","Saleh");
	given().
	   contentType(ContentType.JSON).
	   accept(ContentType.JSON).
	   body(request.toJSONString()).
	when().
	   patch("/users/4").
	then().
	   statusCode(200).log().all();	
};
@Test
public void delete() {
	baseURI = "http://localhost:3000";
	JSONObject request = new JSONObject();
	given().
	   body(request.toJSONString()).
	   delete("/users/4").
	then().
	   statusCode(200);
	
	   
	
}
}
