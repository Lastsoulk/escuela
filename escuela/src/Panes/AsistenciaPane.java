/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
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
public class AsistenciaPane {
    private BorderPane root;
    private Label nombreProfesor;
    private Label cedula;
    private Label nivel;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private Label Lfecha;
    
    
    public AsistenciaPane(){
        nombreProfesor = new Label();
        cedula = new Label();
        nivel = new Label();
        root = new BorderPane();
        root.setTop(asistenciaTop());
        root.setCenter( asistenciaCenter() );
        root.setBottom( Metodos.botonCerrarSession(root) );
    }
    
    private Pane asistenciaTop(){
        Label asistencia = new Label("Asistencia: ");
        LocalDateTime fecha = LocalDateTime.now();
        Lfecha = new Label("\t\t\t\t\t\tFecha: " +String.valueOf(fecha));
        asistencia.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Lfecha.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        ImageView atras = Metodos.botonAtras();atras.setOnMouseClicked((event)->{
            ProfePane profe_pane = new ProfePane();
            root.getChildren().clear();
            root.setCenter(profe_pane.getRoot());
        });

        HBox hb = new HBox(atras, asistencia, Lfecha);
        hb.setAlignment(Pos.CENTER); hb.setSpacing(20); hb.setTranslateY(20);
        return hb;
    }
    
    private Pane asistenciaCenter(){
        //Datos del profesor
        GridPane gp = new GridPane();
        gp.setVgap(2);
        gp.setHgap(4);
        Label Lnombre = new Label("\t\tNombre: "); Lnombre.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lcedula = new Label("\t\tCedula: "); Lcedula.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lnivel = new Label("\t\tNivel: "); Lnivel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gp.addColumn(0, Lnombre, Lcedula, Lnivel);
        gp.addColumn(1, nombreProfesor, cedula, nivel);
        gp.setAlignment(Pos.CENTER_LEFT);
        
        //Marcaje
        Label marcar = new Label("\t\t\tMarcar:"); marcar.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lentrada = new Label("Entrada"); Lentrada.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label Lsalida = new Label("Salida"); Lsalida.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Image entrada = new Image(getClass().getResourceAsStream(Constantes.ruta+"entrada.png"),200,200,true,true);
        Image salida = new Image(getClass().getResourceAsStream(Constantes.ruta+"salida.png"),200,200,true,true);
        ImageView img_entrada = new ImageView(entrada);
        ImageView img_salida = new ImageView(salida);
        VBox vb_entrada = new VBox(img_entrada, Lentrada); vb_entrada.setAlignment(Pos.CENTER);
        VBox vb_salida = new VBox(img_salida, Lsalida); vb_salida.setAlignment(Pos.CENTER);
        HBox hb = new HBox(vb_entrada, vb_salida); hb.setAlignment(Pos.CENTER); hb.setSpacing(350);
        VBox vb = new VBox(gp, marcar, hb); vb.setAlignment(Pos.CENTER_LEFT); vb.setSpacing(20);
        return vb;
    }
    
    
    
    public Pane getRoot(){
        return root;
    }
}
