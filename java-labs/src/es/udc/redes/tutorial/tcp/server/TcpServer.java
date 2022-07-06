package es.udc.redes.tutorial.tcp.server;
import java.io.*;
import java.net.*;

/** Multithread TCP echo server. */

public class TcpServer{

  public static void main(String[] argv) throws IOException {

    Socket aux = null;
    ServerSocket ss; //creacion del socket

    if (argv.length != 1) {
      System.err.println("Format: es.udc.redes.tutorial.tcp.server.TcpServer <port>");
      System.exit(-1);
    }
    try {
      // Create a server socket
      ss = new ServerSocket(Integer.parseInt(argv[0])); //asignacion del puerto al shocket

      // Set a timeout of 300 secs
      ss.setSoTimeout(300000);

      while (true) {
        // Wait for connections
        aux = ss.accept();
        // Create a ServerThread object, with the new connection as parameter
        ServerThread hilo = new ServerThread(aux);
        // Initiate thread using the start() method
        hilo.start();
      }
    }
    catch (SocketTimeoutException e) {
      System.err.println("Nothing received in 300 secs");
    }
    catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
     }
    finally{
        //Close the socket
        aux.close();
    }
  }
}