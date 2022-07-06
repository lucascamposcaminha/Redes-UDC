package es.udc.redes.tutorial.udp.server;
import java.io.IOException;
import java.net.*;

/**
 * Implements a UDP echo sqerver.
 */
public class UdpServer { //java es.udc.redes.tutorial.udp.client.UdpClient <maquina_servidor> <puerto_servidor> <mensaje>

    public static void main(String[] argv) throws IOException {

        String puerto = argv[0]; //puerto servidor
        int puert = Integer.parseInt(puerto); //puerto servidor
        DatagramSocket ss = null; //creacion del socket y asignacion del puerto
        DatagramPacket DpReceive = null;
        DatagramPacket DpResponse = null;
        byte[] receive = new byte[1024];

        if (argv.length != 1) {
            System.err.println("Format: es.udc.redes.tutorial.udp.server.UdpServer <port_number>");
            System.exit(-1);
        }
        try {
            // Create a server socket
            ss = new DatagramSocket(puert);
            // Set max. timeout to 300 secs
            ss.setSoTimeout(300000);

            while (true) {
                // Prepare datagram for reception
                DpReceive = new DatagramPacket(receive, receive.length); //preparo respuesta
                ss.receive(DpReceive); //Recibo el datagrama
                //Despues de esto, ya hemos recibido la informacion del cliente

                // Receive the message
                System.out.println("SERVER: Received "
                        + new String(DpReceive.getData(), 0, DpReceive.getLength())
                        + " from " + DpReceive.getAddress().toString() + ":"
                        + DpReceive.getPort());
                
                // Prepare datagram to send response
                InetAddress address = DpReceive.getAddress(); //Obtengo direccion de origen
                int port = DpReceive.getPort(); //Obtengo puerto de origen (cliente)
                DpResponse = new DatagramPacket(receive, receive.length, address, port);

                // Send response
                ss.send(DpResponse);
                System.out.println("SERVER: Sending "
                        + new String(DpResponse.getData()) + " to "
                        + DpResponse.getAddress().toString() + ":"
                        + DpResponse.getPort());

            }

        // Uncomment next catch clause after implementing the logic
        }
        catch (SocketTimeoutException e) {
            System.err.println("No requests received in 300 secs ");
        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
        finally {
            // Close the socket
                ss.close();
        }
    }
}