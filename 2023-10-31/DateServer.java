import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class DateServer {
  public static void main(String[] args) {

    final int port = 30000;
    ServerSocket listener = null;
    Socket client = null;

    // Establish ServerSocket
    try {
      listener = new ServerSocket(port);
      System.out.println("ServerSocket established on port " + port);

      while (true) {
        try {
          System.out.println("Listening for connection...");
          client = listener.accept();
          System.out.println("Connection established: " + client);

          PrintWriter out = new PrintWriter(client.getOutputStream(), true);
          out.println("The date is now " + new Date().toString());

        } catch (IOException e) {
          System.out.println("Error with socket");
        } finally {
          if (client != null) {
            try {
              client.close();
            } catch (Exception e) {
              System.err.println( "Error closing client socket: " + e.getMessage() );
            }
          }
        }
      } 
    } catch (IOException e) {
      System.out.println("Error with listener");
    } finally {
      if (listener != null) {
        try {
          listener.close();
        } catch (Exception e) {
          System.err.println( "Error closing listener socket: " + e.getMessage() );
        }
      }
    }

    return;
  }
}
