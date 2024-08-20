package api.endpoints;
/*
 swaggar URI- https://petstore.swagger.io
 
 create user=Post-https://petstore.swagger.io/v2/user
 https://petstore.swagger.io/v2/user
 Get user=Get-https://petstore.swagger.io/v2/user/{username}
 
 Update user=put- https://petstore.swagger.io/v2/user/{username}
 
Delete user= Delete-https://petstore.swagger.io/v2/user/{username}
 */
// It contains all urls

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	//create user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//store module
	  //here will create store module url
	
	//pet module 
	  // here will create pet module url
}
