package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPoints.java
//created for perform CRUD operations
//Here We are Getting the Urls from routes.properties file

public class UserEndPoints2 {
	//method created for getting URL's From propertie file
	public static ResourceBundle  getURLfromFile(){
		ResourceBundle routesObj = ResourceBundle.getBundle("routes"); // load properties file 
		return routesObj;
	}
	
	public static Response createUser(User payload) {
		String post_URL = getURLfromFile().getString("post_url");
		Response response = 
				given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(post_URL);

		return response;
	}

	public static Response readUser(String username) {
		String get_URL = getURLfromFile().getString("get_url");
		Response response = 
				given()
				.pathParam("username", username)
				.when()
				.get(get_URL);
		return response;
	}
	
	public static Response updateUser(String username,User payload) {
		String put_URL = getURLfromFile().getString("put_url");
		
		Response response = 
				given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(put_URL);

		return response;
	}
	
	public static Response deleteUser(String username) {
		String delete_URL = getURLfromFile().getString("delete_url");
		Response response = 
				given()
				.pathParam("username", username)
				.when()
				.delete(delete_URL);
		return response;
	}

}
