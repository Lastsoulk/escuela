/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author LastSoul
 */
public class BusquedaPane {
    //Bryan: Trabajando en busqueda pane
    private final BorderPane root;
    private TextField tbuscar;
    private ComboBox cpor;
    private ComboBox cordenar;
    public BusquedaPane(String anterior){
        root = new BorderPane();
        root.setTop( busquedaTop(anterior));
        root.setCenter(busquedaCenter());
       
    }
    
    private Pane busquedaTop(String anterior){
        //Boton atras 
        ImageView atras = Metodos.botonAtras();
        atras.setOnMouseClicked( (event)-> {
            if(anterior.equals("NuevoProfesor")){
                NuevoProfesor admin_pane = new NuevoProfesor(); 
                root.getChildren().clear();
                root.setCenter(admin_pane.getRoot());}
            if(anterior.equals("NuevaAsignatura")){
                NuevaAsignatura admin_pane = new NuevaAsignatura(); 
                root.getChildren().clear();
                root.setCenter(admin_pane.getRoot());
            }
        });
        
        Label title = new Label("Busqueda: "); title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        HBox hb = new HBox(atras, title);
        hb.setSpacing(50); hb.setTranslateX(20); hb.setTranslateY(20);
        return hb;
    }
    private Pane busquedaCenter(){
        GridPane gp = new GridPane();
        gp.setHgap(12);
        gp.setVgap(6);
        Label Lbuscar = new Label("Buscar:"); Lbuscar.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label LPor = new Label("Por:"); LPor.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label LOrdenar = new Label("Ordenar Por:"); LOrdenar.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        tbuscar = new TextField();
        cpor = new ComboBox();
        cordenar = new ComboBox();
        gp.addColumn(0, Lbuscar,LPor);
        gp.addColumn(1, tbuscar,cpor);
        gp.addColumn(2, LOrdenar);
        gp.addColumn(3, cordenar);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    
    private Pane busquedaBottom(){
        VBox vb = new VBox();
        return vb;
    }
    
    public Pane getRoot(){
        return root;
    }

}
