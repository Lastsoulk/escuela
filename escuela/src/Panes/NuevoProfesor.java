/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author jeffer
 */
public class NuevoProfesor {
    private BorderPane root;
    private TextField Tcedula;
    private TextField Tnombre;
    private TextField Tapellido;
    private TextField Ttitulo;
    private ComboBox dia;
    private ComboBox mes;
    private ComboBox anio;
    private HBox Tfdn;
    private TextField Tnacionalidad;
    private ComboBox Testado_civil;
    private TextField Tsueldo;
    private ComboBox Tsexo;
    private TextField Tdireccion;
    private TextField Ttlf;
    private Calendar cal=Calendar.getInstance();;
    public NuevoProfesor(){
        root = new BorderPane();
        root.setTop( nuevoProfeTop());
        root.setCenter( nuevoProfeCenter() );
        root.setBottom( nuevoProfeBottom() );
       
    }
    
    private Pane nuevoProfeTop(){
        //Boton atras 
        ImageView atras = Metodos.botonAtras();
        atras.setOnMouseClicked( (event)-> {
            ProfeAdminPane admin_pane = new ProfeAdminPane(); 
            root.getChildren().clear();
            root.setCenter(admin_pane.getRoot());
        });
        
        Label title = new Label("Añadir/Modificar un profesor"); title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        HBox hb = new HBox(atras, title);
        hb.setSpacing(50); hb.setTranslateX(20); hb.setTranslateY(20);
        return hb;
    }
    
    private Pane nuevoProfeCenter(){
        //Informacion del profesor 
        GridPane gp = new GridPane();
        gp.setHgap(12);
        gp.setVgap(6);
        Label Lcedula = new Label("Cedula:"); Lcedula.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lnombre = new Label("Nombre:"); Lnombre.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lapellido = new Label("Apellido:"); Lapellido.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Ltitulo = new Label("Titulo:"); Ltitulo.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lfdn = new Label("Fecha Nacimiento:"); Lfdn.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lnacionalidad = new Label("Nacionalidad:"); Lnacionalidad.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lestado = new Label("Estado Civil:"); Lestado.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lsueldo = new Label("Sueldo:"); Lsueldo.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Lsexo = new Label("Sexo:"); Lsexo.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Ldireccion = new Label("Direccion:"); Ldireccion.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Label Ltelf = new Label("Telefono:"); Ltelf.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        Tcedula = new TextField();
        Tnombre = new TextField();
        Tapellido = new TextField();
        Ttitulo = new TextField();
        dia = new ComboBox();
        mes = new ComboBox();
        anio = new ComboBox();
        Tfdn = new HBox();
        Tfdn.getChildren().addAll(dia,new Label("   "),mes,new Label(" "),anio);
        Tnacionalidad = new TextField();
        Testado_civil = new ComboBox();
        Tsueldo = new TextField();
        Tsexo = new ComboBox();
        Tdireccion = new TextField();
        Ttlf = new TextField();
        Button buscar = Metodos.botonBuscar();
        llenarCombo();
        gp.addColumn(0, Lcedula,Lnombre,Lapellido,Ltitulo,Lfdn,Lnacionalidad,Lestado,Lsueldo,Lsexo,Ldireccion,Ltelf);
        gp.addColumn(1, Tcedula,Tnombre,Tapellido,Ttitulo,Tfdn,Tnacionalidad,Testado_civil,Tsueldo,Tsexo,Tdireccion,Ttlf);
        gp.addColumn(2, buscar);
        buscar.setOnAction((event)->{
            BusquedaPane profe_pane = new BusquedaPane("NuevoProfesor");
            root.getChildren().clear();
            root.setCenter(profe_pane.getRoot());
        });
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        return gp;
    }
    
    private void llenarCombo(){
        Tsexo.getItems().addAll("Masculino","Femenino");
        Testado_civil.getItems().addAll("Casado","Soltero","Divorciado");
        //llenar combo de dias
        for(int i=1;i<=31;i++){
            dia.getItems().add(i);
        }
        mes.getItems().addAll("01","02","03","04","05","06","07","08","09","10","11","12");
        //llenar combo de anios
        for(int i=cal.get(Calendar.YEAR)-65;i<=cal.get(Calendar.YEAR);i++){
            anio.getItems().add(i);
        }
    }
    
    private Pane nuevoProfeBottom(){
        Button guardar = new Button("Guardar"); 
        guardar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        Button eliminar = new Button("Eliminar");
        eliminar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        Label advertenciaL = new Label(); advertenciaL.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        VBox vb = new VBox();
        HBox hb = new HBox(guardar, eliminar);
        hb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(hb,advertenciaL);
        vb.setAlignment(Pos.CENTER); hb.setSpacing(30); //hb.setTranslateY(-50);
        guardar.setOnMouseClicked((event)->{
            advertenciaL.setText("");
            advertenciaL.setStyle("-fx-text-fill: red");
            if(Tcedula.getText().length() != 10)
                advertenciaL.setText("Cédula Incorrecta");
            else if(Tnombre.getText().length() > 45 || Tnombre.getText().length() < 5)
                advertenciaL.setText("Nombre muy largo");
            else if(Tapellido.getText().length() > 45 || Tapellido.getText().length() < 5)
                advertenciaL.setText("Apellido muy largo");
            else if(Ttitulo.getText().length() > 45 || Ttitulo.getText().length() < 5)
                advertenciaL.setText("Titulo inválido");
            else if(dia.getValue() == null || mes.getValue() == null || anio.getValue() == null)
                advertenciaL.setText("Fecha invalida");
            else if(Tnacionalidad.getText().length() > 45 || Tnacionalidad.getText().length() < 5)
                advertenciaL.setText("Nacionalidad invalida");
            else if(Testado_civil.getValue() == null)
                advertenciaL.setText("Estado civil invalido");
            else if(Tsueldo.getText().length() > 45 || Tsueldo.getText().length() == 0)
                advertenciaL.setText("Sueldo invalido");
            else if(Tsueldo.getText().length() <= 45){
                try{
                    Double.valueOf(Tsueldo.getText());
                }catch(NumberFormatException e){
                    advertenciaL.setText("Sueldo invalido (El sueldo debe estar en decimales)");
                }
            }else if(Tsexo.getValue() == null)
                advertenciaL.setText("Sexo invalido");
            else if(Tdireccion.getText().length() > 45 || Tdireccion.getText().length() < 5)
                advertenciaL.setText("Direccion invalida");
            else if(Ttlf.getText().length() > 13)
                advertenciaL.setText("Telf invalido");
            else if(Ttlf.getText().length() <= 13){
                try{
                    Integer.valueOf(Ttlf.getText());
                }catch(NumberFormatException e){
                    advertenciaL.setText("Telf invalido");
                }
            }else
                advertenciaL.setText("");
            
            String diaS = String.valueOf(dia.getValue());
            String mesS = String.valueOf(mes.getValue());
            String anioS = String.valueOf(anio.getValue());
            
            if(advertenciaL.getText().equals("")){
                try {
                    Metodos.doQuery("INSERT INTO profesor VALUES ('"+Tcedula.getText()+"','"+Tnombre.getText()+"','"+Tapellido.getText()+"','"+Ttitulo.getText()+"','"+anioS+"-"+mesS+"-"+diaS+"','"+Tnacionalidad.getText()+"','"+String.valueOf(Testado_civil.getValue())
                    +"','"+Tsueldo.getText()+"','"+String.valueOf(Tsexo.getValue())+"','"+Tdireccion.getText()+"')");
                    
                    Metodos.doQuery("INSERT INTO Teléfono_Profesor(profesor,teléfono) VALUES('"+Tcedula.getText()+"','"+Ttlf.getText()+"')");
                    advertenciaL.setStyle("-fx-text-fill: green");
                    advertenciaL.setText("Usuario Ingresado :D");
                } catch (SQLException ex) {
                    advertenciaL.setText("Ha ocurrido un error, revise la conexion a la DB o si el usuario ya existe");
                } catch (Exception ex) {
                    advertenciaL.setText("Ha ocurrido un error inesperado, contactar al departamento de sistemas");
                }
            }
            
        });
        
        eliminar.setOnMouseClicked((event)->{
            
        });
        
        return vb;
    }
    
    public Pane getRoot(){
        return root;
    }
    
    
}
