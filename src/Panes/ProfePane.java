/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author jeffer
 */
public class ProfePane {
    private static BorderPane root;
    
    public ProfePane(){
       root = new BorderPane();
       root.setTop( Metodos.logoEscuela() );
       root.setBottom( Metodos.botonCerrarSession(root));
       root.setCenter(profeCenter());
    }
    
    private Pane profeCenter(){
        //Opcion Actualizar Datos
        Image act = new Image(getClass().getResourceAsStream(Constantes.ruta+"actualizar.png"),200,200,true,true);
        ImageView actualizar = new ImageView(act);
        Label Lact = new Label("Actualizar datos"); Lact.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox va = new VBox(actualizar, Lact); va.setAlignment(Pos.CENTER);
        
        //Opcion Marcar Asistencia
        Image asist = new Image(getClass().getResourceAsStream(Constantes.ruta+"marcar.png"),200,200,true,true);
        ImageView asistencia = new ImageView(asist);
        Label Lasist = new Label("Marcar Asistencia"); Lasist.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vas = new VBox(asistencia, Lasist); vas.setAlignment(Pos.CENTER);
        vas.setOnMouseClicked((event) ->{
            AsistenciaPane asistencia_pane = new AsistenciaPane();
            root.getChildren().clear();
            root.setCenter( asistencia_pane.getRoot() );
        });
        
        HBox hb = new HBox(va,vas);
        hb.setSpacing(80);
        hb.setAlignment(Pos.CENTER);
        Label opcion = new Label("Escoja una Opcion:"); opcion.setFont(Font.font("Arial", FontWeight.BOLD, 30)); opcion.setTranslateX(150);
        VBox vb = new VBox(opcion, hb); vb.setAlignment(Pos.CENTER_LEFT); vb.setSpacing(50);
        return vb;
    }
    
    
    public Pane getRoot(){
        return root;
    }
    
}
