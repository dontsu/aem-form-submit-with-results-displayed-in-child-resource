package com.demoformsubmit.core.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DemoService {

    public JSONObject search(String emailParam) throws JSONException {
        return new JSONObject().append("data", new JSONArray().put(emailParam + " " + 1).put(emailParam + " " + 4).put(9));
    }
}
