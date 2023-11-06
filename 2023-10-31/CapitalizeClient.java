import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CapitalizeClient {

  public static void main(String[] args) {

    final String hostname = "localhost";
    final int port = 40000;
    Socket server = null;

    try {
      server = new Socket(hostname, port);

      BufferedReader in = new BufferedReader(new InputStreamReader(
          server.getInputStream()));
      PrintWriter out = new PrintWriter(server.getOutputStream(), true);

      BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

      System.out.println(in.readLine());

      boolean done = false;
      while (!done) {
        String output = userIn.readLine();
        if (output.equals(".")) {
          done = true;
        }
        out.println(output);
        String response = in.readLine();
        System.out.println(response);
      }

    } 
    catch (IOException e) {
      System.out.println("Error with socket");
    } finally {
      if (server != null) {
        try {
          server.close();
        } catch (IOException e) { }
      }
    }

    return;
  }
}
