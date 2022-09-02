package millom.sandbox.jdk.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;
import millom.sandbox.jdk.CustomException.JdkException;
import millom.sandbox.jdk.Utility.JsonUtility;
import millom.sandbox.jdk.record.ReleaseNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JdkMapperTest {

  private final static JdkMapper jdkMapper = new JdkMapper();

  @Test
  @DisplayName("TEST JSON STRING MAPPING CORRECT TO THE RELEASE NAMES OBJECT")
  void deserializeReleaseNames() throws JdkException, IOException {
    ReleaseNames response = jdkMapper.deserializeReleaseNames(
        JsonUtility.getSampleResponse("releaseNamesArmPage0.json"));
    assertThat(response).isNotNull();
    assertThat(response.releases()).hasSize(10);
    assertThat(response.releases().get(2)).isEqualTo("jdk-18+36");
  }

  @Test
  void deserializeWeatherStringAsEmpty() {
    assertThatThrownBy(() -> jdkMapper.deserializeReleaseNames("")).isInstanceOf(
            JdkException.class)
        .hasMessageStartingWith("Error while mapping the Json");
  }

  @Test
  @DisplayName("TEST JSON STRING AS NULL")
  void deserializeWeatherStringAsNull() {
    assertThatThrownBy(() -> jdkMapper.deserializeReleaseNames(null)).isInstanceOf(
            JdkException.class)
        .hasMessageStartingWith("Content is null");


  }


}