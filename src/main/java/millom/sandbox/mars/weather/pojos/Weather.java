package millom.sandbox.mars.weather.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

  private Descriptions descriptions;
  private List<Sol> soles;

  private Weather() {
  }

  private Weather(WeatherBuilder weatherBuilder) {
    this.descriptions = weatherBuilder.descriptions;
    this.soles = weatherBuilder.soles;
  }

  public Descriptions getDescriptions() {
    return descriptions;
  }

  public List<Sol> getSoles() {
    return soles;
  }

  public static class WeatherBuilder {

    private Descriptions descriptions;
    private List<Sol> soles;

    public WeatherBuilder descriptions(Descriptions descriptions) {
      this.descriptions = descriptions;
      return this;
    }

    public WeatherBuilder sols(List<Sol> soles) {
      this.soles = soles;
      return this;
    }

    public Weather build() {
      return new Weather(this);
    }
  }

}

