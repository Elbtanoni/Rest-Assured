package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestsExa {
	@Test
	public void test_1() {
	  Response response = get("https://reqres.in/api/users?page=2");
	  long x = response.getTime();
	  int y = response.getStatusCode();
	  System.out.println(y);
	  System.out.println(x);
	  
	  Assert.assertEquals(y,200);	
	  
	}
	
	@Test
	public void Test_2() {
	   baseURI = "https://reqres.in/api";
	   given().
	       get("/users?page=2").
	   then().
	       statusCode(200).
	       body("data[1].id",equalTo(8));
	}

}
