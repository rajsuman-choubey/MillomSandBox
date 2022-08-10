package millom.sandbox.mars.weather;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import millom.sandbox.mars.weather.mapper.NasaMapper;
import millom.sandbox.mars.weather.resource.NasaResource;
import millom.sandbox.mars.weather.service.NasaClientService;
import millom.sandbox.mars.weather.service.NasaWeatherService;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApp {

  public static final String BASE_URI = "http://localhost:8080/";

  // Starts Grizzly HTTP server
  public static HttpServer startServer() {

    // scan packages
    final ResourceConfig config = new ResourceConfig();
    final Client client = ClientBuilder.newClient();

    config.register(MyResource.class);
    config.register(NasaResource.class);

    config.register(new AbstractBinder() {
      @Override
      protected void configure() {
        bind(MessageServiceImpl.class).to(MessageService.class);
        bind(client).to(Client.class);
        bindAsContract(NasaMapper.class);
        bindAsContract(NasaClientService.class);
        bindAsContract(NasaWeatherService.class);
      }
    });

    final HttpServer httpServer =
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);

    return httpServer;

  }

  public static void main(String[] args) {

    try {

      final HttpServer httpServer = startServer();

      // add jvm shutdown hook
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        try {
          System.out.println("Shutting down the application...");
          httpServer.shutdownNow();

          System.out.println("Done, exit.");
        } catch (Exception e) {
          Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, e);
        }
      }));

      System.out.println(
          String.format("Application started and use CTRL+C to Stop the application"));

      // block and wait shut down signal, like CTRL+C
      Thread.currentThread().join();

    } catch (InterruptedException ex) {
      Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}

