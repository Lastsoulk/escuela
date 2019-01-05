/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import java.sql.SQLException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
 * @author jeffer
 */
public class NuevaAsignatura {
    private BorderPane root;
    private TextField asignatura;
    private TextArea descripcion;
    private TextArea syllabus;
    
    public NuevaAsignatura(){
        root = new BorderPane();
        root.setTop( AsigTop() );
        root.setBottom( AsigBottom() );
        root.setCenter( AsigCenter() );
    }  
    
    
    
    private Pane AsigTop(){
        ImageView atras = Metodos.botonAtras();
        Label Lclase = new Label("Crear/Modificar Asignatura"); Lclase.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        HBox vb = new HBox(atras, Lclase); vb.setSpacing(20);
        vb.setTranslateY(20); vb.setTranslateX(20);
        atras.setOnMouseClicked( (event)-> {
            AdminPane admin_pane = new AdminPane(); 
            root.getChildren().clear();
            root.setCenter(admin_pane.getRoot());
        });
        return vb;
    }
    
    private Pane AsigCenter(){
        GridPane gp = new GridPane();
        gp.setHgap(3);
        gp.setVgap(3);
        Button buscar = Metodos.botonBuscar();
        
        Label Lasignatura = new Label("Asignatura:"); Lasignatura.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Ldescripcion = new Label("Descripcion:"); Ldescripcion.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lsyllabus = new Label("Syllabus:"); Lsyllabus.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        asignatura = new TextField();
        descripcion = new TextArea();
        syllabus = new TextArea();
        gp.addColumn(0, Lasignatura, Ldescripcion ,Lsyllabus);
        gp.addColumn(1, asignatura, descripcion, syllabus);
        gp.addColumn(2, buscar);
        buscar.setOnAction((event)->{
            BusquedaPane profe_pane = new BusquedaPane("NuevaAsignatura");
            root.getChildren().clear();
            root.setCenter(profe_pane.getRoot());
        });
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    
    private Pane AsigBottom(){
        Button guardar = new Button("Guardar"); 
        guardar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        Button eliminar = new Button("Eliminar");
        eliminar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        Label advertenciaL = new Label(); advertenciaL.setFont(Font.font("Arial", FontWeight.BOLD, 25)); 
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        HBox hb = new HBox(guardar, eliminar);
        hb.setAlignment(Pos.CENTER); hb.setSpacing(30);
        vb.getChildren().addAll(hb,advertenciaL);
        
        guardar.setOnAction((event)->{
            advertenciaL.setText("");
            advertenciaL.setStyle("-fx-text-fill: red");
            if(asignatura.getText().length() == 0)
                advertenciaL.setText("ID de asignatura vacia");
            else if(asignatura.getText().length() != 0){
                try{
                    Integer.valueOf(asignatura.getText());
                }catch(NumberFormatException ex){
                    advertenciaL.setText("ID de asignatura invalida");
                }
            }else if(descripcion.getText().length() > 45 || descripcion.getText().length() < 3)
                advertenciaL.setText("Descripcion invalida");
            else if(syllabus.getText().length() > 45 || syllabus.getText().length() < 3)
                advertenciaL.setText("Syllabus invalido");
            else
                advertenciaL.setText("");
            
            if(advertenciaL.getText().equals("")){
                try {
                    Metodos.doQuery("INSERT INTO asignatura VALUES ("+asignatura.getText()+",'"+descripcion.getText()+"','"+syllabus.getText()+"')");
                    advertenciaL.setStyle("-fx-text-fill: green");
                    advertenciaL.setText("Asignatura ingresada :D");
                } catch (SQLException ex) {
                    advertenciaL.setText("Ha ocurrido un error, revise la conexion a la DB o si el usuario ya existe");
                } catch (Exception ex) {
                    advertenciaL.setText("Ha ocurrido un error inesperado, contactar al departamento de sistemas");
                }
            }
        });
        
        eliminar.setOnAction((event)->{
        });
        
        return vb;
    }
    
    public Pane getRoot(){
        return root;
    }
}
