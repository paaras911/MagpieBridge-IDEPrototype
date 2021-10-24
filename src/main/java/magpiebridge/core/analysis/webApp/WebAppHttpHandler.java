package magpiebridge.core.analysis.webApp;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import magpiebridge.core.MagpieServer;

public class WebAppHttpHandler implements HttpHandler {

  private MagpieServer magpieServer;
  private String serverAddress;
  private HttpExchange exchange;
  private boolean areResults;
  WebAppData data;

  public WebAppHttpHandler(MagpieServer magpieServer, String serverAddress) {
    this.magpieServer = magpieServer;
    this.serverAddress = serverAddress;
  }

  public WebAppHttpHandler(
      MagpieServer magpieServer, String serverAddress, Boolean areResults, WebAppData data) {

    this.magpieServer = magpieServer;
    this.serverAddress = serverAddress;
    this.areResults = areResults;
    this.data = data;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {

    // analysis results have arrived
    if (areResults) {
      this.exchange = exchange;
      OutputStream outputStream = exchange.getResponseBody();
      try {
        if ("GET".equals(exchange.getRequestMethod().toUpperCase())) {
          String htmlPage = WebAppGenerator.generateHTML(serverAddress, data, magpieServer);

          exchange.sendResponseHeaders(200, htmlPage.length());
          outputStream.write(htmlPage.getBytes());
          outputStream.flush();
          outputStream.close();
        }
      } finally {
        if (outputStream != null) outputStream.close();
      }
    }
    /* prototype is called without results when analysis starts */
    else {

      this.exchange = exchange;
      OutputStream outputStream = exchange.getResponseBody();
      try {
        if ("GET".equals(exchange.getRequestMethod().toUpperCase())) {
          String htmlPage = WebAppProgressGenerator.generateProgressHTML(this.serverAddress);

          exchange.sendResponseHeaders(200, htmlPage.length());
          outputStream.write(htmlPage.getBytes());
          outputStream.flush();
          outputStream.close();
        }

      } finally {
        if (outputStream != null) outputStream.close();
      }
    }
  }
}
