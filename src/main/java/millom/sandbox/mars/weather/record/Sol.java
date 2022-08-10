package millom.sandbox.mars.weather.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public record Sol(String id, String terrestrialDate, String sol, String ls, String season,
                  String minTemp, String maxTemp, String pressure, String absHumidity,
                  String pressureString, String wind_speed, String windDirection,
                  String atmoOpacity, String sunrise, String sunset, String localUvIrradianceIndex,
                  String maxGtsTemp) {

  public static class Builder {

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

    public Builder(String id) {
      this.id = id;
    }

    public Builder terrestrialDate(String terrestrialDate) {
      this.terrestrialDate = terrestrialDate;
      return this;
    }

    public Builder sol(String sol) {
      this.sol = sol;
      return this;
    }

    public Builder ls(String ls) {
      this.ls = ls;
      return this;
    }

    public Builder season(String season) {
      this.season = season;
      return this;
    }

    public Builder minTemp(String minTemp) {
      this.minTemp = minTemp;
      return this;
    }

    public Builder maxTemp(String maxTemp) {
      this.maxTemp = maxTemp;
      return this;
    }

    public Builder pressure(String pressure) {
      this.pressure = pressure;
      return this;
    }

    public Builder absHumidity(String absHumidity) {
      this.absHumidity = absHumidity;
      return this;
    }

    public Builder windSpeed(String windSpeed) {
      this.windSpeed = windSpeed;
      return this;
    }

    public Builder pressureString(String pressureString) {
      this.pressureString = pressureString;
      return this;
    }

    public Builder windDirection(String windDirection) {
      this.windDirection = windDirection;
      return this;
    }

    public Builder atmoOpacity(String atmoOpacity) {
      this.atmoOpacity = atmoOpacity;
      return this;
    }

    public Builder sunrise(String sunrise) {
      this.sunrise = sunrise;
      return this;
    }

    public Builder sunset(String sunset) {
      this.sunset = sunset;
      return this;
    }

    public Builder localUvIrradianceIndex(String localUvIrradianceIndex) {
      this.localUvIrradianceIndex = localUvIrradianceIndex;
      return this;
    }

    public Builder minGtsTemp(String minGtsTemp) {
      this.minGtsTemp = minGtsTemp;
      return this;
    }

    public Builder maxGtsTemp(String maxGtsTemp) {
      this.maxGtsTemp = maxGtsTemp;
      return this;
    }

    public Sol build() {
      return new Sol(id, terrestrialDate, ls, season, minTemp, maxTemp, pressure, pressureString,
          absHumidity, windSpeed, windDirection, atmoOpacity, sunrise, sunset,
          localUvIrradianceIndex, minGtsTemp, maxGtsTemp);
    }
  }
}




































































































