package org.salawat.samples.homeaway.json.requests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.salawat.samples.homeaway.commons.BeforeAfterSuiteClass;
import org.salawat.samples.homeaway.commons.RestAssuredHelper;
import org.salawat.samples.homeaway.json.response.NearestStationResponse;
import org.salawat.samples.homeaway.json.response.StationIdResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;

public class NRELTransportationRequestFactory {
	private final String baseUri = BeforeAfterSuiteClass.getProperties().getProperty("restAssured.base.url");
	private RestAssuredHelper restHelper = new RestAssuredHelper(baseUri);
	private final String format = "json";
	String api_key = BeforeAfterSuiteClass.getProperties().getProperty("api.key");
	private ObjectMapper om=new ObjectMapper();
	
	
	public NRELTransportationRequestFactory() {
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	// Nearest
	public class NearestStationRequest {

		private String service = "alt-fuel-stations/v1/nearest.";

		String location = null;
		String ev_network = null;
		String city = null;
		String state = null;

		public NearestStationRequest(String city, String state, String network) {
			this.city = city;
			this.state = state;
			this.ev_network=network;
		}

		public NearestStationResponse doNearestStationRequest() {
			Map<String,Object> queryParams=new HashMap<String,Object>();
			queryParams.put("location", city+"+"+state);
			queryParams.put("api_key", api_key);
			queryParams.put("ev_network", ev_network);
			NearestStationResponse nsr=null;
			Response resp=null;
			resp=restHelper.doGetRequest(service+format, queryParams);
			try {
				nsr=om.readValue(resp.asString(),NearestStationResponse.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return nsr;
		}
	}
	
	public class StationIdRequest {
		private String service="alt-fuel-stations/v1/";
		private int id=0;
		
		public StationIdRequest(int id) {
			this.id=id;
		}
		
		public StationIdResponse doGetStationByIdRequest() {
			StationIdResponse stationResponse=null;
			Response resp=null;
			Map<String,Object> queryParams=new HashMap<String,Object>();
			queryParams.put("api_key", api_key);
			resp=restHelper.doGetRequest(service+id+"."+format, queryParams);
			try {
				stationResponse=om.readValue(resp.asString(),StationIdResponse.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return stationResponse;
			
		}
		
	}
}
