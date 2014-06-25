package de.hawai.mps.transport;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server implements Runnable {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/mpstrans/";

    @Override
    public void run() {
        // create a resource config that scans for JAX-RS resources and providers
        // in de.hawai.mps.transport package
        final ResourceConfig rc = new ResourceConfig().packages("de.hawai.mps.transport");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);

        System.out.println(String.format("Jersey app started with WADL available at "
            + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpServer.stop();
    }
}
