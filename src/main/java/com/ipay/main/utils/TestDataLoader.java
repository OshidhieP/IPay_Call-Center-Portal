package com.ipay.main.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class TestDataLoader {

    public static JSONObject LoginTestData() {
        return loadTestData("src/main/resources/jsonFiles/login_testData.json");
    }

    private static JSONObject loadTestData(String filePath) {
        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(filePath);
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
