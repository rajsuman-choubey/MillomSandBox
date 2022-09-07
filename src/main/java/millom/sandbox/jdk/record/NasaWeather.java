package millom.sandbox.jdk.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NasaWeather(Descriptions descriptions, List<Sol> soles) {

  public static class NasaWeatherBuilder {

    private Descriptions descriptions;
    private List<Sol> soles;

    public NasaWeatherBuilder descriptions(Descriptions descriptions) {
      this.descriptions = descriptions;
      return this;
    }

    public NasaWeatherBuilder sols(List<Sol> soles) {
      this.soles = soles;
      return this;
    }

    public NasaWeather build() {
      return new NasaWeather(descriptions, soles);
    }
  }

}