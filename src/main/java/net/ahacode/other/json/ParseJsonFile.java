package net.ahacode.other.json;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class ParseJsonFile {
    public static void main(String[] args) {
        String resourceName = "/json-example.json";
        InputStream is = ParseJsonFile.class.getResourceAsStream(resourceName);
        if(is == null){
            throw new NullPointerException(String.format("Cannot find resource file %s", resourceName));
        }

        JSONTokener tokener = new JSONTokener(is);
        JSONObject object = new JSONObject(tokener);
        System.out.println(object.toString(3));
    }
}
