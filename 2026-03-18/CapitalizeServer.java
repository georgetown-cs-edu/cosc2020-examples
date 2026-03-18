import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class CapitalizeServer {
  
  public static void main(String[] args) {

    final int port = 40000;
    ServerSocket listener = null;
    Socket client = null;
    int clientNumber = 0;

    // Establish ServerSocket
    try {
      listener = new ServerSocket(port);
      System.out.println("ServerSocket established on port " + port);

      while (true) {
        try {
          System.out.println("Listening for connection...");
          client = listener.accept();
          System.out.println("Connection established to client " + clientNumber + ": " + client);

          BufferedReader in = new BufferedReader(new InputStreamReader(
              client.getInputStream()));
          PrintWriter out = new PrintWriter(client.getOutputStream(), true);

          out.println("Type \".\" to disconnect");
          boolean done = false;
          while (!done) {
            String input = in.readLine();
            if (input == null || input.equals(".")) {
              done = true;
              System.out.println("Done");
            }
            if (input != null) {
              String output = input.toUpperCase();
              out.println(output);
              System.out.println("Sent \"" + output + "\" to client " + clientNumber);
            }
          } // End while (!done)

        } // End try on client
        catch (IOException e) {
          System.out.println("Error with socket");
        } finally {
          if (client != null) {
            try {
              client.close();
            } catch (Exception e) {
            }
          }
        }
        System.out.println("Disconnected from client " + clientNumber);
        clientNumber++;
      } // End while(true)

    } // End try on listener
    catch (IOException e) {
      System.out.println("Error with listener");
    } finally {
      if (listener != null) {
        try {
          listener.close();
        } catch (Exception e) {
        }
      }
    }

    return;
  } // End main
}
