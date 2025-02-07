package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
	@Test(priority = 1, dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostUser(String UserID,String UserName,String FirstName, String LastName,String Email,String Password,String Phone) {
		User userpayLoad = new User();
		userpayLoad.setId(Integer.parseInt(UserID));
		userpayLoad.setUsername(UserName);
		userpayLoad.setFirstName(FirstName);
		userpayLoad.setLastName(LastName);
		userpayLoad.setEmail(Email);
		userpayLoad.setPassword(Password);
		userpayLoad.setPhone(Phone);
		
		Response response = UserEndPoints.createUser(userpayLoad);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass= DataProviders.class)
	public void testDeleteUserByName(String Username) {
		Response response=UserEndPoints.deleteUser(Username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
