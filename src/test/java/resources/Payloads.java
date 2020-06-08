package resources;

import helpers.DataReader;

public class Payloads {

	DataReader data = new DataReader();

	public String addPetPayload() {

		return "{\n" + "  \"id\": 10,\n" + "  \"category\": {\n" + "    \"id\": 10,\n" + "    \"name\": \"dogs\"\n"
				+ "  },\n" + "  \"name\": \"" + data.dataReader().getProperty("expectedPostedName") + "\",\n"
				+ "  \"photoUrls\": [\n" + "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n"
				+ "      \"id\": 10,\n" + "      \"name\": \"tag10\"\n" + "    }\n" + "  ],\n"
				+ "  \"status\": \"available\"\n" + "}";

	}

	public String updatePetPayload() {

		return "{\n" + "  \"id\": 10,\n" + "  \"category\": {\n" + "    \"id\": 10,\n" + "    \"name\": \"dogs\"\n"
				+ "  },\n" + "  \"name\": \"" + data.dataReader().getProperty("expectedUpdatedName") + "\",\n"
				+ "  \"photoUrls\": [\n" + "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n"
				+ "      \"id\": 10,\n" + "      \"name\": \"tag10\"\n" + "    }\n" + "  ],\n"
				+ "  \"status\": \"available\"\n" + "}";

	}

}
