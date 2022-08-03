package millom.sandbox.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sol {
  @JsonProperty("id")
  private String id;
  @JsonProperty("terrestrial_date")
  private String terrestrialDate;
  @JsonProperty("sol")
  private String sol;
  @JsonProperty("ls")
  private String ls;
  @JsonProperty("season")
  private String season;
  @JsonProperty("min_temp")
  private String minTemp;

  @JsonProperty("max_temp")
  private String maxTemp;
  @JsonProperty("pressure")
  private String pressure;
  @JsonProperty("pressure_string")
  private String pressureString;
  @JsonProperty("abs_humidity")
  private String absHumidity;
  @JsonProperty("wind_speed")
  private String windSpeed;
  @JsonProperty("wind_direction")
  private String windDirection;
  @JsonProperty("atmo_opacity")
  private String atmoOpacity;
  @JsonProperty("sunrise")
  private String sunrise;
  @JsonProperty("sunset")
  private String sunset;
  @JsonProperty("local_uv_irradiance_index")
  private String localUvIrradianceIndex;
  @JsonProperty("min_gts_temp")
  private String minGtsTemp;
  @JsonProperty("max_gts_temp")
  private String maxGtsTemp;

  private Sol(){
  }

  private Sol(SolBuilder solBuilder) {
    this.id = solBuilder.id;
    this.terrestrialDate = solBuilder.terrestrialDate;
    this.sol = solBuilder.sol;
    this.ls = solBuilder.ls;
    this.season = solBuilder.season;
    this.minTemp = solBuilder.minTemp;
    this.maxTemp = solBuilder.maxTemp;
    this.pressure = solBuilder.pressure;
    this.pressureString = solBuilder.pressureString;
    this.absHumidity = solBuilder.absHumidity;
    this.windSpeed = solBuilder.windSpeed;
    this.windDirection = solBuilder.windDirection;
    this.atmoOpacity = solBuilder.atmoOpacity;
    this.sunrise = solBuilder.sunrise;
    this.sunset = solBuilder.sunset;
    this.localUvIrradianceIndex = solBuilder.localUvIrradianceIndex;
    this.minGtsTemp = solBuilder.minGtsTemp;
    this.maxGtsTemp = solBuilder.maxGtsTemp;
  }

  public String getId() {
    return id;
  }

  public String getTerrestrialDate() {
    return terrestrialDate;
  }

  public String getSol() {
    return sol;
  }

  public String getLs() {
    return ls;
  }

  public String getSeason() {
    return season;
  }

  public String getMinTemp() {
    return minTemp;
  }

  public String getMaxTemp() {
    return maxTemp;
  }

  public String getPressure() {
    return pressure;
  }

  public String getPressureString() {
    return pressureString;
  }

  public String getAbsHumidity() {
    return absHumidity;
  }

  public String getWindSpeed() {
    return windSpeed;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public String getAtmoOpacity() {
    return atmoOpacity;
  }

  public String getSunrise() {
    return sunrise;
  }

  public String getSunset() {
    return sunset;
  }

  public String getLocalUvIrradianceIndex() {
    return localUvIrradianceIndex;
  }

  public String getMinGtsTemp() {
    return minGtsTemp;
  }

  public String getMaxGtsTemp() {
    return maxGtsTemp;
  }
  public static class SolBuilder{
    private String id;
    private String terrestrialDate;
    private String sol;
    private String ls;
    private String season;
    private String minTemp;
    private String maxTemp;
    private String pressure;
    private String pressureString;
    private String absHumidity;
    private String windSpeed;
    private String windDirection;
    private String atmoOpacity;
    private String sunrise;
    private String sunset;
    private String localUvIrradianceIndex;
    private String minGtsTemp;
    private String maxGtsTemp;

    public SolBuilder(String id, String terrestrialDate, String sol, String ls, String season,
        String minTemp, String maxTemp, String pressure, String pressureString, String absHumidity,
        String windSpeed, String windDirection, String atmoOpacity, String sunrise, String sunset,
        String localUvIrradianceIndex, String minGtsTemp, String maxGtsTemp) {
      this.id = id;
      this.terrestrialDate = terrestrialDate;
      this.sol = sol;
      this.ls = ls;
      this.season = season;
      this.minTemp = minTemp;
      this.maxTemp = maxTemp;
      this.pressure = pressure;
      this.pressureString = pressureString;
      this.absHumidity = absHumidity;
      this.windSpeed = windSpeed;
      this.windDirection = windDirection;
      this.atmoOpacity = atmoOpacity;
      this.sunrise = sunrise;
      this.sunset = sunset;
      this.localUvIrradianceIndex = localUvIrradianceIndex;
      this.minGtsTemp = minGtsTemp;
      this.maxGtsTemp = maxGtsTemp;
    }
    public Sol build() {
      return new Sol(this);
    }
  }
}
