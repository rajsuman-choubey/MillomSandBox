 package millom.sandbox.pojo;
import  com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaWeather {
  @JsonProperty("descriptions")
  private Descriptions descriptions;
  @JsonProperty("soles")
  private List<Sol> soles;
  private NasaWeather(){
  }

  private NasaWeather(NasaWeatherBuilder nasaWeatherBuilder){
    this.descriptions = nasaWeatherBuilder.descriptions;
    this.soles = nasaWeatherBuilder.soles;
  }

  public Descriptions getDescriptions() {
    return descriptions;
  }

  public List<Sol> getSoles() {
    return soles;
  }

  public static class NasaWeatherBuilder{
    // builder code
    private Descriptions descriptions;
    private List<Sol> soles;
    public NasaWeatherBuilder(Descriptions descriptions,  List<Sol> soles){
      this.descriptions = descriptions;
      this.soles = soles;
    }
    public  NasaWeather build() {
      return new NasaWeather(this);
    }
  }

}
