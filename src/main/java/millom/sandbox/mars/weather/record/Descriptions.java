package millom.sandbox.mars.weather.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public record Descriptions
    (String disclaimerEn, String disclaimerEs, String solDescEn, String solDescEs,
     String terrestrialDateDescEn, String terrestrialDateDescEs, String tempDescEn,
     String tempDescEs, String pressureDescEn, String pressureDescEs, String absHumidityDescEn,
     String absHumidityDescEs, String windDescEn, String windDescEs, String gtsTempDescEn,
     String gtsTempDescEs, String localUvIrradianceIndexDescEn, String localUvIrradianceIndexDescEs,
     String atmoOpacityDescEn, String atmoOpacityDescEs, String lsDescEn, String lsDescEs,
     String seasonDescEn, String seasonDescEs, String sunriseSunsetDescEn,
     String sunriseSunsetDescEs) {

  public static class Builder {

    private String disclaimerEn;
    private String disclaimerEs;
    private String solDescEn;
    private String solDescEs;
    private String terrestrialDateDescEn;
    private String terrestrialDateDescEs;
    private String tempDescEn;
    private String tempDescEs;
    private String pressureDescEn;
    private String pressureDescEs;
    private String absHumidityDescEn;
    private String absHumidityDescEs;
    private String windDescEn;
    private String windDescEs;
    private String gtsTempDescEn;
    private String gtsTempDescEs;
    private String localUvIrradianceIndexDescEn;
    private String localUvIrradianceIndexDescEs;
    private String atmoOpacityDescEn;
    private String atmoOpacityDescEs;
    private String lsDescEn;
    private String lsDescEs;
    private String seasonDescEn;
    private String seasonDescEs;
    private String sunriseSunsetDescEn;
    private String sunriseSunsetDescEs;

    public Builder disclaimerEn(String disclaimerEn) {
      this.disclaimerEn = disclaimerEn;
      return this;
    }

    public Builder disclaimerEs(String disclaimerEs) {
      this.disclaimerEs = disclaimerEs;
      return this;
    }

    public Builder solDescEn(String solDescEn) {
      this.solDescEn = solDescEn;
      return this;
    }

    public Builder solDescEs(String solDescEs) {
      this.solDescEs = solDescEs;
      return this;
    }

    public Builder terrestrialDateDescEn(String terrestrialDateDescEn) {
      this.terrestrialDateDescEn = terrestrialDateDescEn;
      return this;
    }

    public Builder terrestrialDateDescEs(String terrestrialDateDescEs) {
      this.terrestrialDateDescEs = terrestrialDateDescEs;
      return this;
    }

    public Builder tempDescEn(String tempDescEn) {
      this.tempDescEn = tempDescEn;
      return this;
    }

    public Builder tempDescEs(String tempDescEs) {
      this.tempDescEs = tempDescEs;
      return this;
    }

    public Builder pressureDescEn(String pressureDescEn) {
      this.pressureDescEn = pressureDescEn;
      return this;
    }

    public Builder pressureDescEs(String pressureDescEs) {
      this.pressureDescEs = pressureDescEs;
      return this;
    }

    public Builder absHumidityDescEn(String absHumidityDescEn) {
      this.absHumidityDescEn = absHumidityDescEn;
      return this;
    }

    public Builder absHumidityDescEs(String absHumidityDescEs) {
      this.absHumidityDescEs = absHumidityDescEs;
      return this;
    }

    public Builder windDescEn(String windDescEn) {
      this.windDescEn = windDescEn;
      return this;
    }

    public Builder windDescEs(String windDescEs) {
      this.windDescEs = windDescEs;
      return this;
    }

    public Builder gtsTempDescEn(String gtsTempDescEn) {
      this.gtsTempDescEn = gtsTempDescEn;
      return this;
    }

    public Builder gtsTempDescEs(String gtsTempDescEs) {
      this.gtsTempDescEs = gtsTempDescEs;
      return this;
    }

    public Builder localUvIrradianceIndexDescEn(String localUvIrradianceIndexDescEn) {
      this.localUvIrradianceIndexDescEn = localUvIrradianceIndexDescEn;
      return this;
    }

    public Builder localUvIrradianceIndexDescEs(String localUvIrradianceIndexDescEs) {
      this.localUvIrradianceIndexDescEs = localUvIrradianceIndexDescEs;
      return this;
    }

    public Builder atmoOpacityDescEn(String atmoOpacityDescEn) {
      this.atmoOpacityDescEn = atmoOpacityDescEn;
      return this;
    }

    public Builder atmoOpacityDescEs(String atmoOpacityDescEs) {
      this.atmoOpacityDescEs = atmoOpacityDescEs;
      return this;
    }

    public Builder lsDescEn(String lsDescEn) {
      this.lsDescEn = lsDescEn;
      return this;
    }

    public Builder lsDescEs(String lsDescEs) {
      this.lsDescEs = lsDescEs;
      return this;
    }

    public Builder seasonDescEn(String seasonDescEn) {
      this.seasonDescEn = seasonDescEn;
      return this;
    }

    public Builder seasonDescEs(String seasonDescEs) {
      this.seasonDescEs = seasonDescEs;
      return this;
    }

    public Builder sunriseSunsetDescEn(String sunriseSunsetDescEn) {
      this.sunriseSunsetDescEn = sunriseSunsetDescEn;
      return this;
    }

    public Builder sunriseSunsetDescEs(String sunriseSunsetDescEs) {
      this.sunriseSunsetDescEs = sunriseSunsetDescEs;
      return this;
    }

    public Descriptions build() {
      return new Descriptions(disclaimerEn, disclaimerEs, solDescEn, solDescEs,
          terrestrialDateDescEn, terrestrialDateDescEs, tempDescEn, tempDescEs, pressureDescEn,
          pressureDescEs, absHumidityDescEn, absHumidityDescEs, windDescEn, windDescEs,
          gtsTempDescEn, gtsTempDescEs, localUvIrradianceIndexDescEn, localUvIrradianceIndexDescEs,
          atmoOpacityDescEn, atmoOpacityDescEs, lsDescEn, lsDescEs, seasonDescEn, seasonDescEs,
          sunriseSunsetDescEn, sunriseSunsetDescEs);

    }
  }

}