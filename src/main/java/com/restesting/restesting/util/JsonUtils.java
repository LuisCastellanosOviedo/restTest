package com.restesting.restesting.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


@Component
public class JsonUtils {

    public  JsonNode getJsonNode(String conf) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(conf);
    }

    public  String readJsonConf(String fileUrl) {
        Path path = Paths.get(fileUrl);
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){


            String currentLine = null;
            while((currentLine = reader.readLine()) != null){//while there is content on the current line
                stringBuilder.append(currentLine);
            }
        }catch(IOException ex){
            ex.printStackTrace(); //handle an exception here
        }

        return stringBuilder.toString();
    }





    public  Map<String,String> getValuesAsMap(JsonNode setupData){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(setupData, Map.class);
    }
}
