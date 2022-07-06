package es.udc.redes.tutorial.tcp.server;
import java.io.*;
import java.net.*;

/** Thread that processes an echo server connection. */

public class ServerThread extends Thread {

  private final Socket socket;

  public ServerThread(Socket s) {
    this.socket = s;
  }

  BufferedReader iuChannel = null;
  PrintWriter ouChannel = null;

  public void run(){

    try {
      // Set the input channel
      iuChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      // Set the output channel
      ouChannel = new PrintWriter(socket.getOutputStream(),true);
      // Receive the message from the client
      String message = iuChannel.readLine(); //recibido mensaje y guarda mensaje
      System.out.println("SERVER: Received " + message + "to" +
              socket.getInetAddress().toString() + ":" + socket.getPort());
      // Sent the echo message to the client
      ouChannel.println(message); //Envia de vuelta el mensaje
      System.out.println("SERVER: Sending " + message + " to " +
              socket.getInetAddress().toString() + ":" + socket.getPort());
      // Close the streams
      iuChannel.close();
      ouChannel.close();
    }
    catch (SocketTimeoutException e) {
      System.err.println("Nothing received in 300 secs");
    }
    catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
    finally {
	    // Close the socket
      try {
        socket.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}