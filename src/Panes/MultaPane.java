/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import java.sql.SQLException;
import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
 * @author JosueDavalos
 */
public class MultaPane {
    Calendar fecha;
    private BorderPane root;
    private TextField cedula;
    private TextField valor;
    private TextArea descripcion; 
    private Label mensaje;
    private Label fechaActual;
    public MultaPane(){
        root = new BorderPane();
        mensaje = new Label("");
        root.setTop( multaTop() );
        root.setCenter( multaCenter() );
        root.setBottom( multaBottom() );
    }
    
    private Pane multaTop(){
        ImageView atras = Metodos.botonAtras();
        Label Lmulta = new Label("\tAgregar Multa"); Lmulta.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vb = new VBox(atras, Lmulta); vb.setSpacing(20);
        vb.setTranslateY(10); vb.setTranslateX(10);
        atras.setOnMouseClicked( (event)-> {
            ProfeAdminPane admin_pane = new ProfeAdminPane(); 
            root.getChildren().clear();
            root.setCenter(admin_pane.getRoot());
        });
        return vb;
    }
    
    private Pane multaCenter(){
        Button buscar = Metodos.botonBuscar();
        Label Lfecha = new Label("Fecha: "); Lfecha.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lnombre = new Label("Cedula: "); Lnombre.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lvalor = new Label("Valor: "); Lvalor.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Ldescripcion = new Label("Descripcion: "); Ldescripcion.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        fechaActual = fechaActual(); fechaActual.setFont(Font.font("Arial", 30));
        cedula = new TextField();
        valor = new TextField();
        descripcion = new TextArea();
        GridPane gp = new GridPane();
        gp.setVgap(5); gp.setHgap(5);
        gp.addColumn(0, Lfecha,Lnombre, Lvalor, Ldescripcion);
        gp.addColumn(1, fechaActual,cedula, valor, descripcion);
        gp.addColumn(2,new VBox(),buscar);
        gp.setAlignment(Pos.CENTER);
        //Bryan: Trabajando en buscar pane
        //buscar.setOnAction();
        return gp;
    }
    
    private Label fechaActual(){
        fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return new  Label(dia + "/" + (mes+1) + "/" + año); 
    }
    
    private Pane multaBottom(){
        Button guardar = new Button("Guardar");
        Button eliminar = new Button("Eliminar");
        guardar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        eliminar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        Label advertenciaL = new Label();
        advertenciaL.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        HBox hb = new HBox(guardar, eliminar);
        hb.setSpacing(200); hb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(hb,advertenciaL);
        guardar.setOnAction((event) -> {
            advertenciaL.setStyle("-fx-text-fill: red");
            if(cedula.getText().length() != 10)
                advertenciaL.setText("Cedula invalida");
            else if(valor.getText().length() == 0)
                advertenciaL.setText("Valor vacio");
            else if(valor.getText().length() != 0){
                try{
                    Double.valueOf(valor.getText());
                }catch(NumberFormatException ex){
                    advertenciaL.setText("Valor invalido");
                }
            }else if(descripcion.getText().length() > 45)
                advertenciaL.setText("Descripcion muy extensa");
            else
                advertenciaL.setText("");
            
            if(advertenciaL.getText().equals("")){
                try {
                    Metodos.doQuery("INSERT INTO multa(descripcion,valor) VALUES ('"+descripcion.getText()+"',"+valor.getText()+")");
                    Metodos.doQuery("INSERT INTO Asignación_Multa VALUES ()");//Como se cual es el autoincrement? Cambiar la cedula a varchar(10)
                    advertenciaL.setStyle("-fx-text-fill: green");
                    advertenciaL.setText("Asignatura ingresada :D");
                } catch (SQLException ex) {
                    advertenciaL.setText("Ha ocurrido un error, revise la conexion a la DB o si el usuario ya existe");
                } catch (Exception ex) {
                    advertenciaL.setText("Ha ocurrido un error inesperado, contactar al departamento de sistemas");
                }
            }
        });
        return vb;
    }
    
    public Pane getRoot(){
        return root;
    }
}
