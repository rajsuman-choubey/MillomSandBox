package millom.sandbox.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaWeather {

  private Descriptions descriptions;
  private List<Sol> soles;

  private NasaWeather() {
  }

  private NasaWeather(NasaWeatherBuilder nasaweatherBuilder) {
    this.descriptions = nasaweatherBuilder.descriptions;
    this.soles =  nasaweatherBuilder.soles;
  }

  public Descriptions getDescriptions() {
    return descriptions;
  }

  public List<Sol> getSoles() {
    return soles;
  }

  public static class NasaWeatherBuilder{

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
      return new NasaWeather(this);
    }
  }

}