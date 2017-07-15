package apiTestingForNasa;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 * This is the RestAPI testing Documents. It will take (GET) method and
 * validate.Here, I am using Jayway libraries for RestAssured and For
 * RestResponse
 * 
 * Please check jsonpath file for response
 */

public class GETApiForNasa {
	
	/**
	 * Here in Para I am passing param which is "q", "limit" and "MyAuthorizationKey" which I generated from NASA API website
	 */
	
	
	@Test(priority=1)
	public void statusCodeValidation() {

		// Making one object for response
		Response res = given().param("q", "").param("limit", "10")
				.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
				.get("https://api.nasa.gov/planetary/sounds");

		System.out.println(res.getStatusCode());
		if (res.getStatusCode() == 200) {
			System.out.println("API is having 200 Response code");								//Validate Status Code
		} else {
			System.out.println("Error in API status code");
		}
	}
	
	@Test(priority=2)
	public void wrongStatusCodeValidation() {

		// Making one object for response
		Response res = given().param("q", "").param("limit", "10")
				.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQc").when()				// Here, Passing wrong API Key. So it will throw 401 status code error
				.get("https://api.nasa.gov/planetary/sounds");

		System.out.println(res.getStatusCode());
		if (res.getStatusCode() == 401) {
			System.out.println("API is having 401 Response code");
		} else {
			System.out.println("Error in API status code");
		}
	}
	
	
	@Test(priority=3)
	public void validateForArray1description() {
		String resultForFirstArray = given().param("q", "").param("limit", "10")
				.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
				.get("https://api.nasa.gov/planetary/sounds").then().contentType(ContentType.JSON).extract()
				.path("results[0].description");
	
		System.out.println(
				"It will display Result For First Array result's license which is cc-by-nc: " + resultForFirstArray);   		//Here, use basic validation for validating string value which is in Array1, String2=license value

		if (resultForFirstArray.equalsIgnoreCase("Courtesy of United Launch Alliance")) {
			System.out.println("All good");

		} else {
			System.out.println("not good");
		}

	}
	
	 @Test(priority=4)
	    public void validateDurationForAll() throws Exception {
		 
			given().param("q", "").param("limit", "10")
			.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
			.get("https://api.nasa.gov/planetary/sounds").	
			then().assertThat().body("results[0,1,2,3,4,5,6,7,8,9].duration",hasItems(18365,30095,5903,3760,1515,7497,2560,5641,3187,2429));			//Here, Validating Duration from all array together
																																						//Validating size of an array here. So we can be sure we don't have limit more than 10
	  	
	 }
	 
	 @Test(priority=5)
	    public void validateLast_modifiedForAll() throws Exception {
		 
			given().param("q", "").param("limit", "10")
			.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
			.get("https://api.nasa.gov/planetary/sounds").	
			then().assertThat().body("results[0,1,2,3,4,5,6,7,8,9].last_modified",hasItems("2014/12/16 22:34:23 +0000","2014/10/24 02:16:33 +0000","2014/10/16 19:29:13 +0000","2014/10/16 19:29:12 +0000","2014/10/16 19:29:12 +0000","2014/10/16 19:29:12 +0000","2014/10/16 19:29:12 +0000","2014/10/16 19:29:11 +0000","2014/10/16 19:29:11 +0000","2014/10/16 19:29:10 +0000"));
																						
	  	
	 }
	 
	 
	 @Test(priority=6)
	    public void validateTag_listForAll() throws Exception {
		 
			given().param("q", "").param("limit", "10")
			.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
			.get("https://api.nasa.gov/planetary/sounds").	
			then().assertThat().body("results[0,1,2,3,4,5,6,7,8,9].tag_list",hasItems("Space","Space","Space","Space","Space","Space","Space","Space","Space","Space"));							//Here, Validating tag_list from all array together
																																																	//Validating size of an array here. So we can be sure we don't have limit more than 10
	  	
	 }
	 
	 
	@Test(priority=7)
	public void validatenullForAll() throws Exception {

		Response response = given().param("q", "").param("limit", "10")
				.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
				.get("https://api.nasa.gov/planetary/sounds");
		
		response.then().assertThat()
				.body("results[0,1,2,3,4,5,6,7,8,9].id", hasItems(181835738, 173578614, 172463130, 172463129, 172463128,
						172463126, 172463124, 172463122, 172463117, 172463116));

	}
	
	 @Test(priority=8)
	    public void validateLicenceForAll() throws Exception {
					 given().param("q", "").param("limit", "10")
			.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
			.get("https://api.nasa.gov/planetary/sounds").then().assertThat().body("results[0,1,2,3,4,5,6,7,8,9].license",hasItems("cc-by-nc-sa","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc","cc-by-nc"));
	  	
	 }
	 
	 @Test(priority=9)
	    public void validateDownloadURLForAll() throws Exception {
					 given().param("q", "").param("limit", "10")
			.param("api_key", "wkbqTSuajmKguQUbvlPgWmCZIwBl3wm0hIRLSQci").when()
			.get("https://api.nasa.gov/planetary/sounds").then().assertThat().body("results[0,1,2,3,4,5,6,7,8,9].download_url",hasItems("https://api.soundcloud.com/tracks/181835738/download","https://api.soundcloud.com/tracks/173578614/download","https://api.soundcloud.com/tracks/172463130/download","https://api.soundcloud.com/tracks/172463129/download","https://api.soundcloud.com/tracks/172463128/download","https://api.soundcloud.com/tracks/172463126/download","https://api.soundcloud.com/tracks/172463122/download","https://api.soundcloud.com/tracks/172463117/download","https://api.soundcloud.com/tracks/172463116/download"));
	  	
	 }
	 
	
	 
	

}
	
	





