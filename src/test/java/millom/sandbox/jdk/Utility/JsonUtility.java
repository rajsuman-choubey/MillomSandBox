<<<<<<< HEAD:src/test/java/millom/sandbox/jdk/Utility/JsonUtility.java
package millom.sandbox.jdk.Utility;
=======
package millom.sandbox.mars.weather.Utility;

>>>>>>> main:src/test/java/millom/sandbox/mars/weather/Utility/JsonUtility.java
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

public class JsonUtility {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public static String getSampleResponse(String fileName) throws IOException {
    try (InputStream inputStream = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream(fileName)) {
      JsonNode jsonNode = MAPPER.readValue(inputStream, JsonNode.class);
      return MAPPER.writeValueAsString(jsonNode);
    }
  }

  public static boolean isValidJson(String json) {
    try {
      MAPPER.readTree(json);
    } catch (JacksonException e) {
      return false;
    }
    return true;
  }
}


