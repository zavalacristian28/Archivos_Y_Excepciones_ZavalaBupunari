
package org.example.archivos;

import java.io.*;

public class EstadisticasTexto {

    public void Estadisticas(File archivo) {

        int lineas = 0;
        int contPalabras = 0;
        int caracteres = 0;

        try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas++;
                caracteres += linea.length() + 1;
                String [] palabras = linea.split(" ");

                if (!(palabras.length == 1 && palabras[0].isEmpty())) {
                    contPalabras += palabras.length;
                }
            }

            System.out.println("Líneas: " + lineas);
            System.out.println("Palabras: " + contPalabras);
            System.out.println("Caracteres: " + caracteres);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }
}