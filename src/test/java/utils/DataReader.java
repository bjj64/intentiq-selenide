package utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.File;
import java.io.IOException;

@Data
public class DataReader {
    @JsonProperty("url")
    private String url;

    @JsonProperty("userEmail")
    private String userEmail;

    @JsonProperty("userPassword")
    private String userPassword;

    public static <T> T getData(Class<T> clazz) {
        try {
            File file = new File("src/data/testdata.json");
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data file: src/data/testdata.json" , e);
        }
    }
}
