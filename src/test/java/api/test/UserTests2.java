package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;
//UserEndPoints2.java reading the values from 
public class UserTests2 {
	Faker faker ;
	User userPayLoad;
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		faker= new Faker();
		userPayLoad = new User();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		userPayLoad.setPassword(faker.internet().password(6,10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testCreateUser() {
		
		logger.info("****************Creating User*****************************");
		Response response= UserEndPoints2.createUser(userPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		logger.info("****************User Created*****************************");
	}
	
	@Test(priority = 2)
	public void testGetUserByName() {
		logger.info("****************Getting User*****************************");
		Response response = UserEndPoints2.readUser(this.userPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		logger.info("****************Retreived User*****************************");
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		//updating data using payload
		logger.info("****************Updating User*****************************");
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		
		Response response= UserEndPoints2.updateUser(this.userPayLoad.getUsername(),userPayLoad);
		response.then().log().all();
		//response.then().log().body().statusCode(200); --alternate
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		//checking data after update 
		Response responseAfterUpdate = UserEndPoints2.readUser(this.userPayLoad.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);	
		logger.info("****************User Details Updated*****************************");
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("****************Deleting User*****************************");
		Response response = UserEndPoints2.deleteUser(this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("****************User Deleted*****************************");
	}

}
