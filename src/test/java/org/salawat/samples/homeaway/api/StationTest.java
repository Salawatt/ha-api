package org.salawat.samples.homeaway.api;

import java.util.List;

import org.salawat.samples.homeaway.commons.BeforeAfterSuiteClass;
import org.salawat.samples.homeaway.json.requests.NRELTransportationRequestFactory;
import org.salawat.samples.homeaway.json.requests.NRELTransportationRequestFactory.NearestStationRequest;
import org.salawat.samples.homeaway.json.requests.NRELTransportationRequestFactory.StationIdRequest;
import org.salawat.samples.homeaway.json.response.NearestStationResponse;
import org.salawat.samples.homeaway.json.response.StationIdResponse;
import org.salawat.samples.homeaway.json.response.bean.Fuel_Stations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class StationTest {

	private static final String city = "Austin";
	private static final String state = "TX";
	private static final String network = "ChargePoint Network";

	private static final String stationName = "HYATT AUSTIN";
	private static int stationId = 0;
	//this should be Barton Springs Rd. 
	private static final String expected_street_address = "208 Barton Springs Rd";
	private static final String expectedCity = "Austin";
	private static final String expectedState = "TX";
	private static final String expectedZip = "78704";

	@BeforeClass
	void setUpClass() {
		BeforeAfterSuiteClass.loadProperties();
	}

	@Test(priority = 1)
	public void getNearestStation() {
		NearestStationResponse response = null;
		NRELTransportationRequestFactory rqFac = new NRELTransportationRequestFactory();
		
		NearestStationRequest nsr = rqFac.new NearestStationRequest(city, state, network);
		response = nsr.doNearestStationRequest();

		List<Fuel_Stations> stations = response.getfuel_stations();
		Assert.assertTrue(isStationWithNamePresent(stationName, stations));
	}

	/**
	 * Assuming a small dataset here. This would probably cry due to O(n), but
	 * simplicity wins the day for starters.
	 * 
	 * @param name
	 * @param stations
	 * @return
	 */

	private boolean isStationWithNamePresent(String name, List<Fuel_Stations> stations) {
		for (Fuel_Stations fsr : stations) {
			if (name.equals(fsr.getStation_name())) {
				stationId = fsr.getId();
				return true;
			}
		}
		return false;
	}

	@Test(priority = 2)
	public void verifyAddressOfHyattAustin() {
		StationIdResponse response = null;
		NRELTransportationRequestFactory rqFac = new NRELTransportationRequestFactory();
		StationIdRequest stationWithIdRequest = rqFac.new StationIdRequest(stationId);
		response = stationWithIdRequest.doGetStationByIdRequest();

		Assert.assertEquals(expected_street_address, response.getStreet_address());
		Assert.assertEquals(expectedCity, response.getCity());
		Assert.assertEquals(expectedState, response.getState());
		Assert.assertEquals(expectedZip, response.getZip());
	}

}
