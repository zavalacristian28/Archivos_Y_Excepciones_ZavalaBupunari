package org.example.archivos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class EditorDeNotas extends Application {

    @Override
    public void start(Stage stage) {
        VBox contenedor = new VBox();
        Scene escena = new Scene(contenedor, 500, 500);
        stage.setScene(escena);
        stage.setTitle("Editor de notas");

        // TextArea donde se escribira el texto
        TextArea textA = new TextArea();
        textA.setPromptText("Area de texto");

        // Botones
        Button botonAbrir = new Button("Abrir");
        Button botonGuardar = new Button("Guardar");

        HBox barraBotones = new HBox(15, botonAbrir, botonGuardar);
        contenedor.getChildren().addAll(barraBotones, textA);
        contenedor.setPadding(new Insets(10));
        VBox.setVgrow(textA, Priority.ALWAYS);

        botonAbrir.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Selecciona un archivo para abrir");
            File archivo = fc.showOpenDialog(stage);

            if (archivo != null) {
                try (FileReader fr = new FileReader(archivo);
                     BufferedReader br = new BufferedReader(fr)) {

                    StringBuilder contenido = new StringBuilder();
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        contenido.append(linea).append("\n");
                    }
                    textA.setText(contenido.toString());

                } catch (IOException ex) {
                    ex.printStackTrace();
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al abrir el archivo");
                    alerta.showAndWait();
                }
            }
        });


        botonGuardar.setOnAction(e -> {
            FileChooser fc = new FileChooser();
            fc.setTitle("Selecciona donde guardar el archivo");
            File archivo = fc.showSaveDialog(stage);

            if (archivo != null) {
                try (FileWriter fw = new FileWriter(archivo);
                     BufferedWriter bw = new BufferedWriter(fw)) {

                    bw.write(textA.getText());

                } catch (IOException ex) {
                    ex.printStackTrace();
                    Alert alerta = new Alert(Alert.AlertType.ERROR, "Error al guardar el archivo");
                    alerta.showAndWait();
                }
            }
        });

        stage.show();
    }
}