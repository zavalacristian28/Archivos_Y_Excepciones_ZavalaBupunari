package org.example.archivos;

import java.io.*;
public class MascaraXOR {

    public void procesarArchivoXOR(File archivoInicial, File archivoFinal, byte mascara) {
        try (FileInputStream fis = new FileInputStream(archivoInicial);
             FileOutputStream fos = new FileOutputStream(archivoFinal)) {

            int b;
            while ((b = fis.read())!= -1) {
                fos.write(b ^ mascara);
            }

        }catch(FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
