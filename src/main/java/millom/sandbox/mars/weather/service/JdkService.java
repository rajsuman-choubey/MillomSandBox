package millom.sandbox.mars.weather.service;

import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import millom.sandbox.mars.weather.CustomException.JdkException;
import millom.sandbox.mars.weather.mapper.JdkMapper;
import millom.sandbox.mars.weather.record.ReleaseNames;

public class JdkService {

  @Inject
  private JdkClintService jdkClintService;
  @Inject
  private JdkMapper jdkMapper;

  public List<String> getReleaseNamesMapping(String architecture) throws JdkException {
    List<String> allPagesReleaseNames = new ArrayList<>();
    String marsWeatherAsString = "";

    for (int page = 0; marsWeatherAsString != null; page++) {
      marsWeatherAsString = jdkClintService.getJdkJsonReleaseNames(architecture, page);

      if (marsWeatherAsString != null) {
        ReleaseNames eachPageReleaseNames = jdkMapper.deserializeReleaseNames(marsWeatherAsString);
        for (String release : eachPageReleaseNames.releases()) {
          allPagesReleaseNames.add(release);
        }
      }
    }
    return allPagesReleaseNames;
  }
}

