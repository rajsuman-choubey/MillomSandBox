package millom.sandbox.mars.weather.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sol {

  private String id;
  @JsonProperty("terrestrial_date")
  private String terrestrialDate;
  private String sol;
  private String ls;
  private String season;
  @JsonProperty("min_temp")
  private String minTemp;

  @JsonProperty("max_temp")
  private String maxTemp;
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
  private String sunrise;
  private String sunset;
  @JsonProperty("local_uv_irradiance_index")
  private String localUvIrradianceIndex;
  @JsonProperty("min_gts_temp")
  private String minGtsTemp;
  @JsonProperty("max_gts_temp")
  private String maxGtsTemp;

  private Sol() {
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

  public static class SolBuilder {

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

    public SolBuilder(String id) {
      this.id = id;
    }

    public SolBuilder terrestrialDate(String terrestrialDate) {
      this.terrestrialDate = terrestrialDate;
      return this;
    }

    public SolBuilder sol(String sol) {
      this.sol = sol;
      return this;
    }

    public SolBuilder ls(String ls) {
      this.ls = ls;
      return this;
    }

    public SolBuilder season(String season) {
      this.season = season;
      return this;
    }

    public SolBuilder minTemp(String minTemp) {
      this.minTemp = minTemp;
      return this;
    }

    public SolBuilder maxTemp(String maxTemp) {
      this.maxTemp = maxTemp;
      return this;
    }

    public SolBuilder pressure(String pressure) {
      this.pressure = pressure;
      return this;
    }

    public SolBuilder absHumidity(String absHumidity) {
      this.absHumidity = absHumidity;
      return this;
    }

    public SolBuilder windSpeed(String windSpeed) {
      this.windSpeed = windSpeed;
      return this;
    }

    public SolBuilder pressureString(String pressureString) {
      this.pressureString = pressureString;
      return this;
    }

    public SolBuilder windDirection(String windDirection) {
      this.windDirection = windDirection;
      return this;
    }

    public SolBuilder atmoOpacity(String atmoOpacity) {
      this.atmoOpacity = atmoOpacity;
      return this;
    }

    public SolBuilder sunrise(String sunrise) {
      this.sunrise = sunrise;
      return this;
    }

    public SolBuilder sunset(String sunset) {
      this.sunset = sunset;
      return this;
    }

    public SolBuilder localUvIrradianceIndex(String localUvIrradianceIndex) {
      this.localUvIrradianceIndex = localUvIrradianceIndex;
      return this;
    }

    public SolBuilder minGtsTemp(String minGtsTemp) {
      this.minGtsTemp = minGtsTemp;
      return this;
    }

    public SolBuilder maxGtsTemp(String maxGtsTemp) {
      this.maxGtsTemp = maxGtsTemp;
      return this;
    }

    public Sol build() {
      return new Sol(this);
    }
  }

}
