package com.example.vaadin_phonecat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PhoneController {

	public static List<Phone> getPhones() throws JSONException, IOException {
		JSONArray phonesJson = new JSONArray(
				IOUtils.toString(PhoneController.class
						.getResourceAsStream("phones.json")));

		List<Phone> phones = new ArrayList<Phone>();
		for (int i = 0; i < phonesJson.length(); i++) {
			JSONObject phoneJson = phonesJson.getJSONObject(i);
			Phone phone = new Phone(phoneJson.getString("name"),
					phoneJson.getString("snippet"), phoneJson.getInt("age"));
			phone.setImage(phoneJson.getString("imageUrl"));
			phone.setId(phoneJson.getString("id"));
			phones.add(phone);
		}
		return phones;
	}

	public static PhoneDetails getPhoneDetails(String phoneId) throws JSONException, IOException {
		JSONObject phoneDetailsJson = new JSONObject(
				IOUtils.toString(PhoneController.class
						.getResourceAsStream("phones/"+phoneId+".json")));
		return new PhoneDetails(phoneDetailsJson);

	}

}