package millom.sandbox.mars.weather.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import org.glassfish.jersey.client.JerseyInvocation;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import java.io.IOException;
import millom.sandbox.mars.weather.CustomException.JdkException;
import millom.sandbox.mars.weather.Utility.JsonUtility;
import org.glassfish.jersey.client.JerseyInvocation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class JdkClintServiceTest {

  private JerseyInvocation.Builder builder;
  @Mock
  private Client client;
  @InjectMocks
  private JdkClintService jdkClintService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    WebTarget target = Mockito.mock(WebTarget.class);
    builder = Mockito.mock(JerseyInvocation.Builder.class);
    when(target.request(anyString())).thenReturn(builder);
    when(client.target(anyString())).thenReturn(target);
  }


  @Test
  void getJdkJsonReleaseNames() throws JdkException, IOException {
    when(builder.get(String.class)).thenReturn(
        JsonUtility.getSampleResponse("releaseNamesArmPage0.json"));
    String releaseNamesAsString = jdkClintService.getJdkJsonReleaseNames("arm", 0);
    assertThat(releaseNamesAsString).isNotNull();
    assertThat(JsonUtility.isValidJson(releaseNamesAsString)).isTrue();
    assertThat(releaseNamesAsString).contains("releases");
  }

  @Test
  void getJdkJsonReleaseNamesIncorrectURI() throws IOException, JdkException {
    when(builder.get(String.class)).thenReturn("{\"releases\":[]}");
    String weatherAsString = jdkClintService.getJdkJsonReleaseNames("arm", 0);
    assertThat(weatherAsString).isNotNull().isEqualTo("{\"releases\":[]}");
    assertThat(weatherAsString).isNotEqualTo(
        JsonUtility.getSampleResponse("releaseNamesArmPage0.json"));
  }

  @Test
  void getApiQueryParams() {
    assertThat(jdkClintService.getApiQueryParams("arm", 1)).isNotNull();
    assertThat(jdkClintService.getApiQueryParams("arm", 1)).
        isEqualTo(
            "?architecture=arm&heap_size=normal&image_type=jdk&page=1&page_size=10&project=jdk&release_type=ga&sort_method=DEFAULT&sort_order=DESC&vendor=adoptopenjdk");
  }

  @Test
  void getApiQueryParamsInvalidString() {
    assertThat(jdkClintService.getApiQueryParams("", 0)).
        isNotEqualTo(
            "?architecture=arm&heap_size=normal&image_type=jdk&page=0&page_size=10&project=jdk&release_type=ga&sort_method=DEFAULT&sort_order=DESC&vendor=adoptopenjdk");
  }
}