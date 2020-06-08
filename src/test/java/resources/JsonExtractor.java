package resources;

import io.restassured.path.json.JsonPath;

public class JsonExtractor {

	
	public static int jsonIntExtractor(String response , String key) {

		JsonPath js = new JsonPath(response);
		int value = js.getInt(key);
		return value;

	}

	public static String jsonStringExtractor(String response , String key) {

		JsonPath js = new JsonPath(response);
		String value = js.getString(key);
		return value;

	}

}
