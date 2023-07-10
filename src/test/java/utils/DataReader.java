package utils;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import java.io.File;
import models.FilePathHolder;

@Data
public class DataReader {

    public static <T> T getData(Class<T> clazz) {
        try {
            File file = new File(FilePathHolder.INPUT_DATA_FILE_PATH);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read data file: " + FilePathHolder.INPUT_DATA_FILE_PATH, e);
        }
    }
}
