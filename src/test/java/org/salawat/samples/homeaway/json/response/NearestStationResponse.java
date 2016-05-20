package org.salawat.samples.homeaway.json.response;

import java.util.List;

import org.salawat.samples.homeaway.json.response.bean.Fuel_Stations;
import org.salawat.samples.homeaway.json.response.bean.PrecisionRecord;

public class NearestStationResponse {

	int total_results;
	int offset;

	String station_locator_url;

	double latitude;
	double longitude;
	PrecisionRecord precision;
	List<Fuel_Stations> fuel_stations;

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getStation_locator_url() {
		return station_locator_url;
	}

	public void setStation_locator_url(String station_locator_url) {
		this.station_locator_url = station_locator_url;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public PrecisionRecord getPrecision() {
		return precision;
	}

	public void setPrecision(PrecisionRecord precision) {
		this.precision = precision;
	}

	public List<Fuel_Stations> getfuel_stations() {
		return fuel_stations;
	}

	public void setFuel_Stations(List<Fuel_Stations> fuel_stations) {
		this.fuel_stations = fuel_stations;
	}
}
