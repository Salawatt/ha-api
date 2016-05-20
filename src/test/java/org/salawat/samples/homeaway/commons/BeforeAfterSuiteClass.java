package org.salawat.samples.homeaway.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeforeAfterSuiteClass {

	private static Properties sysProps = new Properties();

	public static void loadProperties() {

		File apiProps = new File("./src/test/resources/api.properties");
		InputStream is = null;
		try {
			is = new FileInputStream(apiProps);
			sysProps.load(is);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifySystemProps();
	}

	static void verifySystemProps() {
		String api_key = sysProps.getProperty("api.key");
		System.out.println("Api_key is " + api_key);
		String restAssuredBaseUri = sysProps.getProperty("restassured.base.url");
		System.out.println(restAssuredBaseUri);
	}

	public static Properties getProperties() {
		return sysProps;
	}
}
