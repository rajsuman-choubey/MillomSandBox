package millom.sandbox.jdk.service;

import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import millom.sandbox.jdk.mapper.JdkMapper;
import millom.sandbox.jdk.record.ReleaseNames;
import millom.sandbox.jdk.CustomException.JdkException;

public class JdkService {

  @Inject
  private JdkClintService jdkClintService;
  @Inject
  private JdkMapper jdkMapper;

  public List<String> getReleaseNamesMapping(String architecture) throws JdkException {
    List<String> allPagesReleaseNames = new ArrayList<>();
    String pageContent= "";

    for (int page = 0; pageContent != null; page++) {
      pageContent = jdkClintService.getJdkJsonReleaseNames(architecture, page);

      if (pageContent != null) {
        ReleaseNames eachPageReleaseNames = jdkMapper.deserializeReleaseNames(pageContent);
        for (String release : eachPageReleaseNames.releases()) {
          allPagesReleaseNames.add(release);
        }
      }
    }
    return allPagesReleaseNames;
  }
}

