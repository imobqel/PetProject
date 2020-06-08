package test;

import static io.restassured.RestAssured.given;
import org.junit.Assert;
import org.testng.annotations.Test;

import helpers.DataReader;
import io.restassured.RestAssured;
import resources.JsonExtractor;
import resources.Payloads;

public class PetSmokeTest {

	// Classes Objects
	DataReader data = new DataReader();
	Payloads payloads = new Payloads();

	// Variables
	String actualPostedName;
	String actualUpdatedName;	
	int petID;

	
	
/////////////////////// Below test is for ADDING a new pet using POST API ///////////////////////

	@Test(priority = 0)
	public void AddPet() {

		RestAssured.baseURI = data.dataReader().getProperty("BaseURL");
				
		String addPetResponse = given().header("Content-Type", "application/json").log().all()
				.body(payloads.addPetPayload()).header("Content-Type", "application/json").when().post("/pet").then()
				.assertThat().statusCode(200).extract().asString();

		actualPostedName = JsonExtractor.jsonStringExtractor(addPetResponse, "name");
		petID = JsonExtractor.jsonIntExtractor(addPetResponse, "id");

		Assert.assertEquals(data.dataReader().getProperty("expectedPostedName"), actualPostedName);

	}
	
	

/////////////////////// Below test is for UPDATING an existing pet using PUT API ///////////////////////

	@Test(priority = 1)
	public void UpdatePet() {

		String updatePetResponse = given().header("Content-Type", "application/json").log().all()
				.body(payloads.updatePetPayload()).header("Content-Type", "application/json").when().put("/pet").then()
				.assertThat().statusCode(200).extract().asString();

		actualUpdatedName = JsonExtractor.jsonStringExtractor(updatePetResponse, "name");

		Assert.assertEquals(data.dataReader().getProperty("expectedUpdatedName"), actualUpdatedName);
	}
	
	
	
/////////////////////// Below test is for GETTING a pet using GET API BY ID ///////////////////////


	@Test(priority = 2)
	public void GetPet() {

		String getPetResponse = given().log().all().when().get("/pet/10").then().assertThat().statusCode(200).log()
				.all().extract().asString();

		String nameValue = JsonExtractor.jsonStringExtractor(getPetResponse, "name");

		Assert.assertEquals(actualUpdatedName, nameValue);
	}
	
	
	
/////////////////////// Below test is for DELETING a pet using DELETE API BY ID ///////////////////////


	@Test(priority = 3)
	public void DeletePet() {

		given().header("Content-Type", "application/json").when().delete("/pet/" + petID + "").then().assertThat()
				.statusCode(200);

	}
}