/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author JosueDavalos
 */
public class AdminPane {
    private static BorderPane root;
    
    public AdminPane(){
        root = new BorderPane();
        root.setCenter(adminCenter());
        root.setTop( Metodos.logoEscuela() );
        root.setBottom( Metodos.botonCerrarSession(root) );
        //root.setStyle("-fx-background-image: url(/imagenes/escuela1.jpeg) ; -fx-background-repeat: stretch; -fx-background-size: 900 600; -fx-background-position: center center;");
            
    }
    
    private Pane adminCenter(){
        //Opcion Profesor
        Image prof = new Image(getClass().getResourceAsStream(Constantes.ruta+"profesor.png"),200,200,true,true);
        ImageView img_prof = new ImageView(prof);
        Label Lprof = new Label("Profesor"); Lprof.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vp = new VBox(img_prof,Lprof); vp.setAlignment(Pos.CENTER);
        vp.setOnMouseClicked( (event) -> {
            ProfeAdminPane profe_pane = new ProfeAdminPane();
            root.getChildren().clear();
            root.setCenter(profe_pane.getRoot());
        });
        
        //Opcion Estudiante
        Image est = new Image(getClass().getResourceAsStream(Constantes.ruta+"estudiante.png"),200,200,true,true);
        ImageView img_est = new ImageView(est);
        Label Lest = new Label("Estudiante"); Lest.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox ve = new VBox(img_est, Lest); ve.setAlignment(Pos.CENTER);
        
        //Opcion Salon de clases
        Image salon = new Image(getClass().getResourceAsStream(Constantes.ruta+"salon.png"),200,200,true,true);
        ImageView img_salon = new ImageView(salon);
        Label Lsalon = new Label("Salon"); Lsalon.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vs = new VBox(img_salon,Lsalon); vs.setAlignment(Pos.CENTER);
        
        
        //Opcion Asignatura
        Image asig = new Image(getClass().getResourceAsStream(Constantes.ruta+"asignatura.png"),200,200,true,true);
        ImageView img_asig = new ImageView(asig);
        Label Lasig = new Label("Asignatura"); Lasig.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox va = new VBox(img_asig, Lasig); va.setAlignment(Pos.CENTER);
        va.setOnMouseClicked((event)->{
            NuevaAsignatura clasePane = new NuevaAsignatura();
            root.getChildren().clear();
            root.setCenter(clasePane.getRoot());
        });
        
        
        HBox hb = new HBox(vp, ve, vs, va);
        hb.setSpacing(80);
        hb.setAlignment(Pos.CENTER);
        Label opcion = new Label("Escoja una Opcion:"); opcion.setFont(Font.font("Arial", FontWeight.BOLD, 30)); opcion.setTranslateX(150);
        VBox vb = new VBox(opcion, hb); vb.setAlignment(Pos.CENTER_LEFT); vb.setSpacing(50);
        return vb;
    }
        
    public BorderPane getRoot(){
        return root;
    }
    
}
