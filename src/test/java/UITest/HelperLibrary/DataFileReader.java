package UITest.HelperLibrary;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class DataFileReader {
    String fileName;

    public DataFileReader(String fileName){
        this.fileName = fileName;
    }

    public JsonNode getData(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        JsonNode json = null;
        try {
            json = mapper.readTree(new File(
                    System.getProperty("user.dir") + "/src/test/resources/UITest/DataFiles/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public JsonNode getEnvironmentData(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        JsonNode json = null;
        try {
            json = mapper.readTree(new File(
                    System.getProperty("user.dir") + "/src/test/resources/UITest/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
