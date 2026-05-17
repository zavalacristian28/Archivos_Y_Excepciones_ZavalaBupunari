package org.example.archivos;

import javafx.application.Application;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
        EditorDeNotas.launch(args);
        //ClonadorDeImagenes.launch(args);
    }

}
