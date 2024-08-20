package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;
	UserPOJO userpojo;
	public Logger logger;
	@BeforeClass
	public void setup()
	{
//		logger.info("data setup started");
		faker=new Faker();
		userpojo=new UserPOJO();
		userpojo.setId(faker.idNumber().hashCode());
		userpojo.setUsername(faker.name().username());
		userpojo.setFirstName(faker.name().firstName());
		userpojo.setLastName(faker.name().lastName());
		userpojo.setEmail(faker.internet().emailAddress());
		userpojo.setPassword(faker.internet().password());
		userpojo.setPhone(faker.phoneNumber().cellPhone());
	//	userpojo.getUserStatus(faker.);
//		logger.info("data setup completed");
		logger=LogManager.getLogger(this.getClass());
	
	}
	@Test(priority=1)
	public void testCreateUser()
	{
		logger.debug("user is creating");
		
		Response response=UserEndpoints.CreateUser(userpojo);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.debug("user is created");
	}
	@Test(priority=2)
	public void testGetUser()
	{
		logger.info("Reading the user");
		
		Response response=UserEndpoints2.ReadUser(this.userpojo.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("user info is displayed");
	}
	@Test(priority=3)
	public void testUpdateUser()
	{
		//updating user here
		
		logger.info("updating the user");
		
		userpojo.setFirstName(faker.name().firstName());
		userpojo.setLastName(faker.name().lastName());
		userpojo.setEmail(faker.internet().emailAddress());
		
		Response response=UserEndpoints2.UpdateUser(this.userpojo.getUsername(), userpojo);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info(" user is updated");
		//checking after updating user
		
		Response responseafterUpdate=UserEndpoints2.ReadUser(this.userpojo.getUsername());
		responseafterUpdate.then().log().all();
		Assert.assertEquals(responseafterUpdate.getStatusCode(), 200);
		
	}
	@Test(priority=4)
	public void testDeleteUser()
	{
		logger.info("Deleting the user");
		
		Response response=UserEndpoints2.DeleteUser(this.userpojo.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("user is deleted");
	}

}
