package org.example.archivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class ManejoFlujoBytes {
    File nombreArchivo;


    public ManejoFlujoBytes(String nombreArchivo){
        this.nombreArchivo=new File(nombreArchivo);
    }

    public void escribirByte(int c){

    }
    public int leerByte(){
        int unByte=-1;
        FileInputStream in=null;
        try{
                in=new FileInputStream(nombreArchivo);
            if((unByte = in.read())!=-1){
                System.out.println(unByte);
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(in!=null){
                try{
                    in.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
            return unByte;
    }

    public ArrayList<Integer> leer8Bytes(){
        int unByte=-1;
        int cont=0;
        ArrayList<Integer> ochoBytes=new ArrayList<>();
        FileInputStream in=null;
        try{
            in=new FileInputStream(nombreArchivo);
            while((unByte = in.read())!=-1 && cont<=7){
                ochoBytes.add(unByte);
                System.out.println(unByte);
                cont++;
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(in!=null){
                try{
                    in.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return ochoBytes;
    }

    public String veriicarFormato(ArrayList<Integer> ochoBytes){
        String formato=" ";
        ArrayList<Integer> formatoPDF=new ArrayList<>();
        formatoPDF.add(Integer.parseInt("25",16));
        formatoPDF.add(Integer.parseInt("50",16));
        formatoPDF.add(Integer.parseInt("44",16));
        formatoPDF.add(Integer.parseInt("46",16));
        formatoPDF.add(Integer.parseInt("66",16));
        formatoPDF.add(Integer.parseInt("20",16));

        ArrayList<Integer> formatoJPEG=new ArrayList<>();
        formatoJPEG.add(Integer.parseInt("FF",16));
        formatoJPEG.add(Integer.parseInt("DB",16));
        formatoJPEG.add(Integer.parseInt("FF",16));
        formatoJPEG.add(Integer.parseInt("EB",16));
        formatoJPEG.add(Integer.parseInt("E1",16));

        int valor=ochoBytes.get(0);
        if(valor==formatoPDF.get(0)) formato="PDF";
        if(valor==formatoJPEG.get(0)) formato="JPEg";

        return formato;
    }
}
