package api.endpoints;

import org.testng.annotations.Listeners;

import com.aventstack.chaintest.plugins.ChainTestListener;

/*
 Swagger URL - https://petstore.swagger.io/ 
 Create User (Post) --> https://petstore.swagger.io/v2/user
 Get User (get) --> https://petstore.swagger.io/v2/user/{{username}}
 Update User (put)--> https://petstore.swagger.io/v2/user/{{username}}
 Delete User (delete)--> https://petstore.swagger.io/v2/user/{{username}}
 */

//@Listeners(ChainTestListener.class)

public class Routes {
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//user modeule
	public static String user_post_url = base_url+"/user";
	public static String user_get_url = base_url+"/user/{username}";
	public static String user_put_url = base_url+"/user/{username}";
	public static String user_delete_url = base_url+"/user/{username}";
	
	//StoreModule
	
	//PetModule

}
