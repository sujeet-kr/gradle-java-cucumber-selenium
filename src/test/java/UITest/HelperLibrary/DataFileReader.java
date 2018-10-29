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
            json = mapper.readTree(new File("./UI_Suite/src/main/resources/DataFiles/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    public JsonNode getEnvironmentData(){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        JsonNode json = null;
        try {
            json = mapper.readTree(new File("/Users/MacJae/MyProjects/flipp-project/gradle-automation-framework/src/test/resources/UITest/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
