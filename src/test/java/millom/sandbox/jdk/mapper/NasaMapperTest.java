package millom.sandbox.jdk.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import millom.sandbox.jdk.CustomException.InvalidWeatherException;
import millom.sandbox.jdk.Utility.JsonUtility;
import millom.sandbox.jdk.record.NasaWeather;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class NasaMapperTest {

  private final static NasaMapper nasaMapper = new NasaMapper();


  @Test
  void deserializeWeatherStringAsEmpty() {
    assertThatThrownBy(() -> nasaMapper.deserializeWeather("")).isInstanceOf(
            InvalidWeatherException.class)
        .hasMessageStartingWith("Error while parsing the Json");
  }

  @Test
  @DisplayName("TEST JSON STRING AS NULL")
  void deserializeWeatherStringAsNull() {
    assertThatThrownBy(() -> nasaMapper.deserializeWeather(null)).isInstanceOf(
            InvalidWeatherException.class)
        .hasMessageStartingWith("Content is null");
  }

  @Test
  @DisplayName("TEST FOR JSON PROPERTY NAME MISMATCH")
  void deserializeWeatherPropertyNameMisMatch() throws InvalidWeatherException, IOException {
    NasaWeather response = nasaMapper.deserializeWeather(
        JsonUtility.getSampleResponse("propertyMismatchResponse.json"));
    assertThat(response).extracting("descriptions").isNull();
    assertThat(response).extracting("soles").isNotNull();
  }

  @Test
  @DisplayName("TEST FOR JSON PROPERTY MISSING")
  void deserializeWeatherPropertyMissing() throws InvalidWeatherException, IOException {
    NasaWeather response = nasaMapper.deserializeWeather(
        JsonUtility.getSampleResponse("missingJsonPropertyResponse.json"));
    assertThat(response).extracting("descriptions").isNull();
    assertThat(response).extracting("soles").isNotNull();
  }
}