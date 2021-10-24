package magpiebridge.core.analysis.webApp;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import magpiebridge.core.MagpieServer;

public class WebAppHttpServer {

  InetSocketAddress socket;
  HttpServer server;
  HttpContext context;
  WebAppHttpHandler handler;

  public String createAndStartLocalHttpServer(MagpieServer magpieServer) {
    try {
      if (magpieServer.getClient() != null) setupServerConfiguration(magpieServer);

      context.setHandler(handler);
      server.start();
      return new URI("http", server.getAddress().toString() + "/prototype", null)
          .toURL()
          .toString();
    } catch (IOException | URISyntaxException e) {

      e.printStackTrace();
      return null;
    }
  }

  public String updateHttpServer(MagpieServer magpieserver, Boolean areResults, WebAppData data) {
    this.context = server.createContext("/prototype-results");
    this.handler =
        new WebAppHttpHandler(magpieserver, server.getAddress().toString(), areResults, data);
    context.setHandler(handler);

    try {
      return new URI("http", server.getAddress().toString() + "/prototype-results", null)
          .toURL()
          .toString();
    } catch (MalformedURLException e) {

      e.printStackTrace();
      return null;
    } catch (URISyntaxException e) {
      e.printStackTrace();
      return null;
    }
  }

  private void setupServerConfiguration(MagpieServer magpieServer) throws IOException {
    this.socket = new InetSocketAddress("localhost", 8080);
    this.server = HttpServer.create(socket, 0);
    this.context = server.createContext("/prototype");
    this.handler = new WebAppHttpHandler(magpieServer, server.getAddress().toString());
  }
}
