package org.salawat.samples.homeaway.commons;

import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
public class RestAssuredHelper {
	private RestAssured restAssured;
	
	public RestAssuredHelper(String baseURI) {
		this.restAssured=new RestAssured();
		RestAssured.baseURI=baseURI;
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	public Response doGetRequest(String service, Map<String,Object> queryParams) {
		String servicePath=RestAssured.baseURI+service;
		
		Response response =	given().queryParameters(queryParams).get(servicePath);
		String stringResponse=response.asString();
		System.out.println(stringResponse);
		restAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		return response;
	}

}
