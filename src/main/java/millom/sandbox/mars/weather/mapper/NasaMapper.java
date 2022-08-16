package millom.sandbox.mars.weather.mapper;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import millom.sandbox.mars.weather.CustomException.InvalidWeatherException;
import millom.sandbox.mars.weather.record.NasaWeather;
import pojos.Weather;

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
  }}
