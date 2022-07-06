package es.udc.redes.tutorial.tcp.server;
import java.net.*;
import java.io.*;

/**
 * MonoThread TCP echo server.
 */
public class MonoThreadTcpServer {

    public static void main(String[] argv) throws IOException {

        ServerSocket ss = null;
        Socket aux = null;
        BufferedReader iuChannel = null;
        PrintWriter ouChannel = null;

        if (argv.length != 1) {
            System.err.println("Format: es.udc.redes.tutorial.tcp.server.MonoThreadTcpServer <port>");
            System.exit(-1);
        }
        try {
            // Create a server socket
            ss = new ServerSocket(Integer.parseInt(argv[0])); //creacion del socket y asignacion del puerto
            // Set a timeout of 300 secs
            ss.setSoTimeout(300000); //se da en msecs

            while (true) {
                // Wait for connections
                aux = ss.accept();
                // Set the input channel
                iuChannel = new BufferedReader(new InputStreamReader(aux.getInputStream()));
                // Set the output channel
                ouChannel = new PrintWriter(aux.getOutputStream(),true);
                // Receive the client message
                String DpReceive = iuChannel.readLine();
                System.out.println("SERVER: Received "
                        + DpReceive + " from " + aux.getInetAddress().toString() + ":" + aux.getPort());
                // Send response to the client
                ouChannel.println(DpReceive);
                System.out.println("SERVER: Sending " + DpReceive + " to "
                        + aux.getInetAddress().toString() + ":" + aux.getPort());
                // Close the streams
                iuChannel.close();
                ouChannel.close();
            }
        // Uncomment next catch clause after implementing the logic            
        }
        catch (SocketTimeoutException e) {
            System.err.println("Nothing received in 300 secs ");
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
	        //Close the socket
            ss.close();
        }
    }
}