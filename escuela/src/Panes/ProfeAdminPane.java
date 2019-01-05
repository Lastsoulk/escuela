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
public class ProfeAdminPane {
    private BorderPane root;
    
    public ProfeAdminPane(){
        root = new BorderPane();
        root.setCenter(profeCenter());
        root.setBottom( Metodos.botonCerrarSession(root) );
        root.setTop( profeTop() );
        
    }
    
    private Pane profeCenter(){
        //Opcion añadir o modificar un profesor 
        Image prof = new Image(getClass().getResourceAsStream(Constantes.ruta+"profesor.png"),200,200,true,true);
        ImageView img_prof = new ImageView(prof);
        Label Lprof = new Label("Añadir/Modificar un profesor"); Lprof.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vp = new VBox(img_prof,Lprof); vp.setAlignment(Pos.CENTER);
        vp.setOnMouseClicked((event)->{
            NuevoProfesor nuevoProf = new NuevoProfesor();
            root.getChildren().clear();
            root.setCenter( nuevoProf.getRoot() );
        });
        
        //Opcion multa
        Image multa = new Image(getClass().getResourceAsStream(Constantes.ruta+"multa.png"),200,200,true,true);
        ImageView img_multa = new ImageView(multa);
        Label Lmulta = new Label("Multa"); Lmulta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vm = new VBox(img_multa,Lmulta); vm.setAlignment(Pos.CENTER);
        vm.setOnMouseClicked((event) -> {
            MultaPane nuevoProf = new MultaPane();
            root.getChildren().clear();
            root.setCenter( nuevoProf.getRoot() );
        });
        
        
        HBox hb = new HBox(vp,vm);
        hb.setSpacing(80);
        hb.setAlignment(Pos.CENTER);
        return hb;
    }
    
    private Pane profeTop(){
        //Boton atras 
        ImageView atras = Metodos.botonAtras();
        atras.setOnMouseClicked( (event)-> {
            AdminPane admin_pane = new AdminPane(); 
            root.getChildren().clear();
            root.setCenter(admin_pane.getRoot());
        });
        Label title = new Label("Añadir/Modificar un profesor"); title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        HBox hb = new HBox(atras, title);
        hb.setSpacing(50); hb.setTranslateX(20); hb.setTranslateY(20);
        return hb;
    }
    
    
    public Pane getRoot(){
        return root;
    }
}
