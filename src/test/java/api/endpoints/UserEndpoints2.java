package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



//it contains CRUD implementation
//it uses to perform Create , Read, Update and Delete request to the user API

public class UserEndpoints2 {
	// this will get the urls from properties file
	public static ResourceBundle getURL()
	{
		ResourceBundle routes=	ResourceBundle.getBundle("routes");
		return routes;
	}
	public static Response CreateUser(UserPOJO payload)
	{
		String post_url=getURL().getString("post_url");
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
	    .post(post_url);
		return response;
	}
	
	public static Response ReadUser(String Username)
	{
		String get_url=getURL().getString("get_url");
		
		Response response=given()
				
		.pathParam("username",Username)
		.when()
	    .get(get_url);
		return response;
	}
	
	public static Response UpdateUser(String Username, UserPOJO payload)
	{
		String put_url=getURL().getString("put_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", Username)
		.body(payload)
		.when()
	    .put(put_url);
		return response;
	}
	public static Response DeleteUser(String Username)
	{
		String delete_url=getURL().getString("delete_url");
		Response response=given()
		.pathParam("username", Username)
		.when()
	    .delete(delete_url);
		return response;
	}
	

}
