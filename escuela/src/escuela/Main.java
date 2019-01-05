/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela;

import Panes.*;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author JosueDavalos
 */
public class Main extends Application {
   LoginPane pantalla = new LoginPane();
    
    
    @Override
    public void start(Stage primaryStage) {
         
        Scene scene = new Scene(pantalla.getRoot());
        primaryStage.setTitle("Escuela");
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(650);
        primaryStage.setMinWidth(650);
        primaryStage.setMaximized(true);
        File fi = new File("src\\imagenes\\escuela.png");
        primaryStage.getIcons().add(new Image(fi.toURI().toString()));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
