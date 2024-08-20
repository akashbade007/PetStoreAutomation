package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



//it contains CRUD implementation
//it uses to perform Create , Read, Update and Delete request to the user API

public class UserEndpoints {
	
	public static Response CreateUser(UserPOJO payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
	    .post(Routes.post_url);
		return response;
	}
	
	public static Response ReadUser(String Username)
	{
		
		Response response=given()
				
		.pathParam("username",Username)
		.when()
	    .get(Routes.get_url);
		return response;
	}
	
	public static Response UpdateUser(String Username, UserPOJO payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", Username)
		.body(payload)
		.when()
	    .put(Routes.put_url);
		return response;
	}
	public static Response DeleteUser(String Username)
	{
		Response response=given()
		.pathParam("username", Username)
		.when()
	    .delete(Routes.delete_url);
		return response;
	}
	

}
