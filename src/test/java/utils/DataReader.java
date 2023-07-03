package utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

  private static final String FILE_NAME = "src/data/testdata.json";

  public static String getUserEmail() {
    return getData().get("userEmail").getAsString();
  }

  public static String getUserPassword() {
    return getData().get("userPassword").getAsString();
  }

  public static String getUrl() {
    return getData().get("url").getAsString();
  }

  private static JsonObject getData() {
    try {
      return JsonParser.parseReader(new FileReader(FILE_NAME)).getAsJsonObject();
    } catch (IOException e) {
      throw new RuntimeException("Failed to read test data file", e);
    }
  }
}
