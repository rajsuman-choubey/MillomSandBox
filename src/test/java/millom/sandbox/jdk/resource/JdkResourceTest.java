package millom.sandbox.jdk.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import millom.sandbox.jdk.CustomException.JdkException;
import millom.sandbox.jdk.resource.JdkResource;
import millom.sandbox.jdk.service.JdkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class JdkResourceTest {

  @Mock
  private JdkService jdkServiceMock;
  @InjectMocks
  private JdkResource jdkesource;

  @BeforeEach
  private void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void getJdkReleaseNames() throws JdkException {
    List<String> releaseNames = Arrays.asList("jdk8u332-b09", "jdk8u322-b06", "jdk8u312-b07",
        "jdk8u302-b08", "jdk8u282-b08", "jdk8u275-b01", "jdk8u272-b10", "jdk8u265-b01",
        "jdk8u262-b10", "jdk8u252-b09", "jdk8u242-b08", "jdk8u232-b09", "jdk8u222-b10",
        "jdk8u212-b04", "jdk8u212-b03", "jdk8u202-b08");

    when(jdkServiceMock.getReleaseNamesMapping("sparcv9"))
        .thenReturn(releaseNames);
    Response response = jdkesource.getJdkReleaseNames("sparcv9");
    assertThat(response.getStatus()).isEqualTo(200);
    assertThat(response.getEntity()).isEqualTo(releaseNames);
    assertThat((List<String>) response.getEntity()).hasSize(16);
  }


  @ParameterizedTest
  @ValueSource(strings = {"x12", "abc"})
  @DisplayName("GET JDK RELEASE NAMES FOR A GIVEN PLATFORM IS MISMATCH")
  void getJdkReleaseNamesForInvalidPlatform(String input) throws JdkException {
    Response response = jdkesource.getJdkReleaseNames(input);
    assertThat(response.getStatus()).isEqualTo(400);
    assertThat(response.getEntity()).isEqualTo(
        "The input parameter is not valid for architecture.");
  }

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("GET JDK RELEASE NAMES FOR A GIVEN PLATFORM IS NULL OR EMPTY")
  void getJdkReleaseNamesForNullPlatform(String input) throws JdkException {
    Response response = jdkesource.getJdkReleaseNames(input);
    assertThat(response.getStatus()).isEqualTo(400);
    assertThat(response.getEntity()).isEqualTo(
        "The input parameter is not valid for architecture.");
  }
}
