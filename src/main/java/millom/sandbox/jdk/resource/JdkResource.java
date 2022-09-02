package millom.sandbox.jdk.resource;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import millom.sandbox.jdk.CustomException.JdkException;
import millom.sandbox.jdk.service.JdkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/openjdk")
public class JdkResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(JdkResource.class);

  @Inject
  private JdkService jdkService;

  @Path("/releases/")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getJdkReleaseNames(@QueryParam("architecture") String architecture)
      throws JdkException {
    if (architecture == null || !architecture.matches(
        "x64|x86|x32|ppc64|ppc64le|s390x|aarch64|arm|sparcv9|riscv64")) {
      return Response.
          status(Status.BAD_REQUEST)
          .entity("The input parameter is not valid for architecture.")
          .build();
    }
    try {
      LOGGER.info(
          String.format(
              "Task-5: Success message from open jdk API -- %s class and  get method: %s()",
              Thread.currentThread().getStackTrace()[1].getClassName(),
              Thread.currentThread().getStackTrace()[1].getMethodName()));
      return Response.
          status(Status.OK)
          .entity(jdkService.getReleaseNamesMapping(architecture))
          .build();
    } catch (JdkException e) {
      LOGGER.info(String.format("Task-5: Exception occurred in -- %s class and  get method: %s()",
          Thread.currentThread().getStackTrace()[1].getClassName(),
          Thread.currentThread().getStackTrace()[1].getMethodName()));
      return Response.
          status(Status.INTERNAL_SERVER_ERROR)
          .entity(e.getMessage())
          .build();
    }
  }

}


