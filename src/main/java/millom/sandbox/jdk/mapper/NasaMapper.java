package millom.sandbox.jdk.mapper;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import millom.sandbox.jdk.CustomException.InvalidWeatherException;
import millom.sandbox.jdk.record.NasaWeather;

public class NasaMapper {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  static {
    MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
  }

  public NasaWeather deserializeWeather(String response) throws InvalidWeatherException {
    try {
      return MAPPER.readValue(response, NasaWeather.class);
    } catch (JsonProcessingException e) {
      throw new InvalidWeatherException("Error while parsing the Json" + e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new InvalidWeatherException("Content is null" + e.getMessage());
    }
  }

  public boolean isValidJson(String json) {
    try {
      MAPPER.readTree(json);
    } catch (JacksonException e) {
      return false;
    }
    return true;
  }

}

