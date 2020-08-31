package utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseDynamicJson {
	static Object ResponseValue; 
	
	public static Object parseObject(JSONObject json, String key) {
		return json.get(key);
		
	}

	public static Object getKey(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {

					if (json.get(nextKeys) instanceof JSONObject) {

						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}

					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSOn = new JSONObject(jsonarrayString);

							if (exists == false) {
								ResponseValue = getKey(innerJSOn, key);
							}

						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		} else {
			ResponseValue = parseObject(json, key);
		}
		return ResponseValue;

	}

}