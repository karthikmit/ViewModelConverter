package com.makemytrip.vmconv.utils;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by karthik on 12/07/17.
 */
public class JSONUtils {

    public static String getJSON(Object objectIn) {
        return new Gson().toJson(objectIn);
    }

    public static Map<String, Object> convertObjectToMap(Object objectIn) {
        Map value = new Gson().fromJson(getJSON(objectIn), Map.class);

        return value;
    }
}
