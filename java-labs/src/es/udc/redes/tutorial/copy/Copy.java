package es.udc.redes.tutorial.copy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy { //ejecucion: java es.udc.redes.tutorial.copy.Copy<fichero origen> <fichero destino>

    public static void main(String[] args) throws IOException{

        int i=0;
        String[] file = new String[2];
        FileInputStream entrada = null;
        FileOutputStream salida = null;

        for (String arg : args) { //para cada arg que estan en args, se hace una vuelta
            file[i] = arg;
            i++;
        }

        if (file[0] == null || file[1]==null)  System.out.println("Debes indicar dos archivos");

        else {

            try {
                entrada = new FileInputStream(file[0]); //archivo que queremos copiar
                salida = new FileOutputStream(file[1]); //archivo con la informacion copiada del archivo anterior
                int c;

                while ((c = entrada.read()) != -1) {
                    salida.write(c);
                }
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
                if (salida != null) {
                    salida.close();
                }
            }
        }
    }
}