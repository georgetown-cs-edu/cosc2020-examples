import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DateClient {

  public static void main(String[] args) {

    final String hostname = "localhost";
    final int port = 30000;
    Socket server = null;

    try {
      server = new Socket(hostname, port);

      BufferedReader in = new BufferedReader(new InputStreamReader(
          server.getInputStream()));
      String time = in.readLine();
      System.out.println(time);

    } catch (IOException e) {
      System.out.println("Error with socket");
    } finally {
      if (server != null) {
        try {
          server.close();
        } catch (IOException e) {
        }
      }
    }

    return;
  }
}
