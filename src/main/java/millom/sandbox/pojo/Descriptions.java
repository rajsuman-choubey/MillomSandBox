package millom.sandbox.pojo;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Descriptions {
  @JsonProperty("disclaimer_en")
  private String disclaimerEn;

  @JsonProperty("disclaimer_es")
  private String disclaimerEs;

  @JsonProperty("sol_desc_en")
  private String sol_desc_en;

  @JsonProperty("sol_desc_es")
  private String sol_desc_es;

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

  private Descriptions(){
  }

  public Descriptions(DescriptionsBuilder descriptionsBuilder) {
    this.disclaimerEn = descriptionsBuilder.disclaimerEn;
    this.disclaimerEs = descriptionsBuilder.disclaimerEs;
    this.sol_desc_en = descriptionsBuilder.sol_desc_en;
    this.sol_desc_es = descriptionsBuilder.sol_desc_es;
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
    return sol_desc_en;
  }

  public String getSol_desc_es() {
    return sol_desc_es;
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
  public static class DescriptionsBuilder{
    private String disclaimerEn;
    private String disclaimerEs;
    private String sol_desc_en;
    private String sol_desc_es;
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

    public DescriptionsBuilder(String disclaimerEn, String disclaimerEs, String sol_desc_en,
        String sol_desc_es, String terrestrialDateDescEn, String terrestrialDateDescEs,
        String tempDescEn, String tempDescEs, String pressureDescEn, String pressureDescEs,
        String absHumidityDescEn, String absHumidityDescEs, String windDescEn, String windDescEs,
        String gtsTempDescEn, String gtsTempDescEs, String localUvIrradianceIndexDescEn,
        String localUvIrradianceIndexDescEs, String atmoOpacityDescEn, String atmoOpacityDescEs,
        String lsDescEn, String lsDescEs, String seasonDescEn, String seasonDescEs,
        String sunriseSunsetDescEn, String sunriseSunsetDescEs) {
      this.disclaimerEn = disclaimerEn;
      this.disclaimerEs = disclaimerEs;
      this.sol_desc_en = sol_desc_en;
      this.sol_desc_es = sol_desc_es;
      this.terrestrialDateDescEn = terrestrialDateDescEn;
      this.terrestrialDateDescEs = terrestrialDateDescEs;
      this.tempDescEn = tempDescEn;
      this.tempDescEs = tempDescEs;
      this.pressureDescEn = pressureDescEn;
      this.pressureDescEs = pressureDescEs;
      this.absHumidityDescEn = absHumidityDescEn;
      this.absHumidityDescEs = absHumidityDescEs;
      this.windDescEn = windDescEn;
      this.windDescEs = windDescEs;
      this.gtsTempDescEn = gtsTempDescEn;
      this.gtsTempDescEs = gtsTempDescEs;
      this.localUvIrradianceIndexDescEn = localUvIrradianceIndexDescEn;
      this.localUvIrradianceIndexDescEs = localUvIrradianceIndexDescEs;
      this.atmoOpacityDescEn = atmoOpacityDescEn;
      this.atmoOpacityDescEs = atmoOpacityDescEs;
      this.lsDescEn = lsDescEn;
      this.lsDescEs = lsDescEs;
      this.seasonDescEn = seasonDescEn;
      this.seasonDescEs = seasonDescEs;
      this.sunriseSunsetDescEn = sunriseSunsetDescEn;
      this.sunriseSunsetDescEs = sunriseSunsetDescEs;
    }
    public Descriptions build() {
      return new Descriptions(this);
    }
  }
}

