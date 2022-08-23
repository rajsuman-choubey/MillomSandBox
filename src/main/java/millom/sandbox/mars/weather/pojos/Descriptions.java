package millom.sandbox.mars.weather.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Descriptions {

  @JsonProperty("disclaimer_en")
  private String disclaimerEn;

  @JsonProperty("disclaimer_es")
  private String disclaimerEs;

  @JsonProperty("sol_desc_en")
  private String solDescEn;

  @JsonProperty("sol_desc_es")
  private String solDescEs;

  @JsonProperty("terrestrial_date_desc_en")
  private String terrestrialDateDescEn;

  @JsonProperty("terrestrial_date_desc_es")
  private String terrestrialDateDescEs;

  @JsonProperty("temp_desc_en")
  private String tempDescEn;

  @JsonProperty("temp_desc_es")
  private String tempDescEs;

  @JsonProperty("pressure_desc_en")
  private String pressureDescEn;

  @JsonProperty("pressure_desc_es")
  private String pressureDescEs;

  @JsonProperty("abs_humidity_desc_en")
  private String absHumidityDescEn;

  @JsonProperty("abs_humidity_desc_es")
  private String absHumidityDescEs;

  @JsonProperty("wind_desc_en")
  private String windDescEn;

  @JsonProperty("wind_desc_es")
  private String windDescEs;

  @JsonProperty("gts_temp_desc_en")
  private String gtsTempDescEn;

  @JsonProperty("gts_temp_desc_es")
  private String gtsTempDescEs;

  @JsonProperty("local_uv_irradiance_index_desc_en")
  private String localUvIrradianceIndexDescEn;

  @JsonProperty("local_uv_irradiance_index_desc_es")
  private String localUvIrradianceIndexDescEs;

  @JsonProperty("atmo_opacity_desc_en")
  private String atmoOpacityDescEn;

  @JsonProperty("atmo_opacity_desc_es")
  private String atmoOpacityDescEs;

  @JsonProperty("ls_desc_en")
  private String lsDescEn;

  @JsonProperty("ls_desc_es")
  private String lsDescEs;

  @JsonProperty("season_desc_en")
  private String seasonDescEn;

  @JsonProperty("season_desc_es")
  private String seasonDescEs;

  @JsonProperty("sunrise_sunset_desc_en")
  private String sunriseSunsetDescEn;

  @JsonProperty("sunrise_sunset_desc_es")
  private String sunriseSunsetDescEs;

  private Descriptions() {
  }

  private Descriptions(DescriptionsBuilder descriptionsBuilder) {
    this.disclaimerEn = descriptionsBuilder.disclaimerEn;
    this.disclaimerEs = descriptionsBuilder.disclaimerEs;
    this.solDescEn = descriptionsBuilder.solDescEn;
    this.solDescEs = descriptionsBuilder.solDescEs;
    this.terrestrialDateDescEn = descriptionsBuilder.terrestrialDateDescEn;
    this.terrestrialDateDescEs = descriptionsBuilder.terrestrialDateDescEs;
    this.tempDescEn = descriptionsBuilder.tempDescEn;
    this.tempDescEs = descriptionsBuilder.tempDescEs;
    this.pressureDescEn = descriptionsBuilder.pressureDescEn;
    this.pressureDescEs = descriptionsBuilder.pressureDescEs;
    this.absHumidityDescEn = descriptionsBuilder.absHumidityDescEn;
    this.absHumidityDescEs = descriptionsBuilder.absHumidityDescEs;
    this.windDescEn = descriptionsBuilder.windDescEn;
    this.windDescEs = descriptionsBuilder.windDescEs;
    this.gtsTempDescEn = descriptionsBuilder.gtsTempDescEn;
    this.gtsTempDescEs = descriptionsBuilder.gtsTempDescEs;
    this.localUvIrradianceIndexDescEn = descriptionsBuilder.localUvIrradianceIndexDescEn;
    this.localUvIrradianceIndexDescEs = descriptionsBuilder.localUvIrradianceIndexDescEs;
    this.atmoOpacityDescEn = descriptionsBuilder.atmoOpacityDescEn;
    this.atmoOpacityDescEs = descriptionsBuilder.atmoOpacityDescEs;
    this.lsDescEn = descriptionsBuilder.lsDescEn;
    this.lsDescEs = descriptionsBuilder.lsDescEs;
    this.seasonDescEn = descriptionsBuilder.seasonDescEn;
    this.seasonDescEs = descriptionsBuilder.seasonDescEs;
    this.sunriseSunsetDescEn = descriptionsBuilder.sunriseSunsetDescEn;
    this.sunriseSunsetDescEs = descriptionsBuilder.sunriseSunsetDescEs;
  }

  public String getDisclaimerEn() {
    return disclaimerEn;
  }

  public String getDisclaimerEs() {
    return disclaimerEs;
  }

  public String getSol_desc_en() {
    return solDescEn;
  }

  public String getSol_desc_es() {
    return solDescEs;
  }

  public String getTerrestrialDateDescEn() {
    return terrestrialDateDescEn;
  }

  public String getTerrestrialDateDescEs() {
    return terrestrialDateDescEs;
  }

  public String getTempDescEn() {
    return tempDescEn;
  }

  public String getTempDescEs() {
    return tempDescEs;
  }

  public String getPressureDescEn() {
    return pressureDescEn;
  }

  public String getPressureDescEs() {
    return pressureDescEs;
  }

  public String getAbsHumidityDescEn() {
    return absHumidityDescEn;
  }

  public String getAbsHumidityDescEs() {
    return absHumidityDescEs;
  }

  public String getWindDescEn() {
    return windDescEn;
  }

  public String getWindDescEs() {
    return windDescEs;
  }

  public String getGtsTempDescEn() {
    return gtsTempDescEn;
  }

  public String getGtsTempDescEs() {
    return gtsTempDescEs;
  }

  public String getLocalUvIrradianceIndexDescEn() {
    return localUvIrradianceIndexDescEn;
  }

  public String getLocalUvIrradianceIndexDescEs() {
    return localUvIrradianceIndexDescEs;
  }

  public String getAtmoOpacityDescEn() {
    return atmoOpacityDescEn;
  }

  public String getAtmoOpacityDescEs() {
    return atmoOpacityDescEs;
  }

  public String getLsDescEn() {
    return lsDescEn;
  }

  public String getLsDescEs() {
    return lsDescEs;
  }

  public String getSeasonDescEn() {
    return seasonDescEn;
  }

  public String getSeasonDescEs() {
    return seasonDescEs;
  }

  public String getSunriseSunsetDescEn() {
    return sunriseSunsetDescEn;
  }

  public String getSunriseSunsetDescEs() {
    return sunriseSunsetDescEs;
  }

  public static class DescriptionsBuilder {

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

    public DescriptionsBuilder disclaimerEn(String disclaimerEn) {
      this.disclaimerEn = disclaimerEn;
      return this;
    }

    public DescriptionsBuilder disclaimerEs(String disclaimerEs) {
      this.disclaimerEs = disclaimerEs;
      return this;
    }

    public DescriptionsBuilder solDescEn(String solDescEn) {
      this.solDescEn = solDescEn;
      return this;
    }

    public DescriptionsBuilder solDescEs(String solDescEs) {
      this.solDescEs = solDescEs;
      return this;
    }

    public DescriptionsBuilder terrestrialDateDescEn(String terrestrialDateDescEn) {
      this.terrestrialDateDescEn = terrestrialDateDescEn;
      return this;
    }

    public DescriptionsBuilder terrestrialDateDescEs(String terrestrialDateDescEs) {
      this.terrestrialDateDescEs = terrestrialDateDescEs;
      return this;
    }

    public DescriptionsBuilder tempDescEn(String tempDescEn) {
      this.tempDescEn = tempDescEn;
      return this;
    }

    public DescriptionsBuilder tempDescEs(String tempDescEs) {
      this.tempDescEs = tempDescEs;
      return this;
    }

    public DescriptionsBuilder pressureDescEn(String pressureDescEn) {
      this.pressureDescEn = pressureDescEn;
      return this;
    }

    public DescriptionsBuilder pressureDescEs(String pressureDescEs) {
      this.pressureDescEs = pressureDescEs;
      return this;
    }

    public DescriptionsBuilder absHumidityDescEn(String absHumidityDescEn) {
      this.absHumidityDescEn = absHumidityDescEn;
      return this;
    }

    public DescriptionsBuilder absHumidityDescEs(String absHumidityDescEs) {
      this.absHumidityDescEs = absHumidityDescEs;
      return this;
    }

    public DescriptionsBuilder windDescEn(String windDescEn) {
      this.windDescEn = windDescEn;
      return this;
    }

    public DescriptionsBuilder windDescEs(String windDescEs) {
      this.windDescEs = windDescEs;
      return this;
    }

    public DescriptionsBuilder gtsTempDescEn(String gtsTempDescEn) {
      this.gtsTempDescEn = gtsTempDescEn;
      return this;
    }

    public DescriptionsBuilder gtsTempDescEs(String gtsTempDescEs) {
      this.gtsTempDescEs = gtsTempDescEs;
      return this;
    }

    public DescriptionsBuilder localUvIrradianceIndexDescEn(String localUvIrradianceIndexDescEn) {
      this.localUvIrradianceIndexDescEn = localUvIrradianceIndexDescEn;
      return this;
    }

    public DescriptionsBuilder localUvIrradianceIndexDescEs(String localUvIrradianceIndexDescEs) {
      this.localUvIrradianceIndexDescEs = localUvIrradianceIndexDescEs;
      return this;
    }

    public DescriptionsBuilder atmoOpacityDescEn(String atmoOpacityDescEn) {
      this.atmoOpacityDescEn = atmoOpacityDescEn;
      return this;
    }

    public DescriptionsBuilder atmoOpacityDescEs(String atmoOpacityDescEs) {
      this.atmoOpacityDescEs = atmoOpacityDescEs;
      return this;
    }

    public DescriptionsBuilder lsDescEn(String lsDescEn) {
      this.lsDescEn = lsDescEn;
      return this;
    }

    public DescriptionsBuilder lsDescEs(String lsDescEs) {
      this.lsDescEs = lsDescEs;
      return this;
    }

    public DescriptionsBuilder seasonDescEn(String seasonDescEn) {
      this.seasonDescEn = seasonDescEn;
      return this;
    }

    public DescriptionsBuilder seasonDescEs(String seasonDescEs) {
      this.seasonDescEs = seasonDescEs;
      return this;
    }

    public DescriptionsBuilder sunriseSunsetDescEn(String sunriseSunsetDescEn) {
      this.sunriseSunsetDescEn = sunriseSunsetDescEn;
      return this;
    }

    public DescriptionsBuilder sunriseSunsetDescEs(String sunriseSunsetDescEs) {
      this.sunriseSunsetDescEs = sunriseSunsetDescEs;
      return this;
    }

    public Descriptions build() {
      return new Descriptions(this);
    }
  }

}
