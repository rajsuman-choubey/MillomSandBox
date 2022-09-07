package millom.sandbox.jdk.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD:src/main/java/millom/sandbox/jdk/mapper/NasaMapper.java
import millom.sandbox.jdk.CustomException.InvalidWeatherException;
import millom.sandbox.jdk.record.NasaWeather;
=======
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import millom.sandbox.mars.weather.pojos.Weather;
>>>>>>> main:src/main/java/millom/sandbox/mars/weather/mapper/NasaMapper.java

public class NasaMapper {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public Weather deserializeWeather(String response) throws InvalidWeatherException {
    try {
      return MAPPER.readValue(response, Weather.class);
    } catch (JsonProcessingException e) {
      throw new InvalidWeatherException("Error while mapping the Json" + e.getMessage());
    } catch (IllegalArgumentException e) {
      throw new InvalidWeatherException("Content is null" + e.getMessage());
    }
  }
}
