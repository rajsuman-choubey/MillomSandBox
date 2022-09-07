package millom.sandbox.jdk.service;

import static net.bytebuddy.implementation.MethodDelegation.to;
import static org.assertj.core.api.Assertions.assertThat;

import millom.sandbox.jdk.service.NasaClientService;
import millom.sandbox.jdk.service.NasaWeatherService;
import millom.sandbox.jdk.mapper.NasaMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class NasaWeatherServiceTest {

  @Mock
  private NasaClientService nasaClientService;
  @Mock
  private NasaMapper nasaMapper;
  @InjectMocks
  private NasaWeatherService nasaWeatherService;

  @BeforeEach
  private void setUp() {
    MockitoAnnotations.initMocks(this);
  }
}
