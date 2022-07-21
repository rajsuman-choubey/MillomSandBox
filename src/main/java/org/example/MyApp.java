package org.example;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class MyApp {

  public static final String BASE_URI = "http://localhost:8080/";

  // Starts Grizzly HTTP server
  public static HttpServer startServer() {
    final ResourceConfig config = new ResourceConfig();

    config.register(MyResource.class);

    config.register(new AbstractBinder() {
      @Override
      protected void configure() {
        // map this service to this contract
        bind(MessageServiceImpl.class).to(MessageService.class);
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
          // System.out.println("Shutting down the application...");

          httpServer.shutdownNow();

          System.out.println("Done, exit.");
        } catch (Exception e) {
          Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, e);
        }
      }));

      Thread.currentThread().join();

    } catch (InterruptedException ex) {
      Logger.getLogger(MyApp.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}