/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import escuela.Metodos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author JosueDavalos
 */
public class LoginPane {
    private BorderPane root;
    private Label warningMessage = new Label("");
    private TextField user;
    private PasswordField password;
    
    public LoginPane(){ 
        root = new BorderPane();  
        root.setTop(LoginTop());
        root.setBottom(LoginBottom());
        root.setCenter(LoginCenter());     
        //root.setStyle("-fx-background-image: url(/imagenes/escuela1.jpeg) ; -fx-background-repeat: stretch; -fx-background-size: 1400 800; -fx-background-position: center center;"); agrega fondo
    }
    
    private Pane LoginCenter(){
        user = new TextField();
        password = new PasswordField();
        Label Luser = new Label("Usuario:    ");
        Luser.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Luser.setTextFill(Color.BLACK);
        user.setMaxSize(400, 400);
        password.setMaxSize(400, 400);
        
        Label Lpassword = new Label("Contrasena:");
        Lpassword.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Lpassword.setTextFill(Color.BLACK);
        
        VBox vUser = new VBox(Luser,user); vUser.setAlignment(Pos.CENTER);
        VBox vPassword = new VBox(Lpassword,password); vPassword.setAlignment(Pos.CENTER);
        VBox gp = new VBox(vUser, vPassword);
        gp.setAlignment(Pos.CENTER);
        gp.setSpacing(20);
        return gp;
    }
    
    private Pane LoginTop(){
        Label inicioSesionL = new Label("Inicio de Sesion");
        inicioSesionL.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        inicioSesionL.setTextFill(Color.BLACK);
        Image sesion = new Image(getClass().getResourceAsStream(Constantes.ruta+"sesion.png"),200,200,true,true);
        ImageView img_sesion = new ImageView(sesion);
        VBox vb = new VBox(inicioSesionL,img_sesion);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);
        return vb;
    }
    
    
    private Pane LoginBottom(){
        VBox vb = new VBox();
        Button ingresar = new Button("Ingresar");
        Button salir = new Button("   Salir   ");
        ingresar.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        salir.setStyle("-fx-background-color: #000000;-fx-text-fill: white;-fx-font-size: 20;");
        
        
        ingresar.setOnMouseClicked((event) -> {
            String usuario = user.getText();
            String contra = user.getText();
            if(Metodos.esAdmin(usuario, contra)){
                AdminPane admin_pane = new AdminPane();
                Metodos.username = "admin"; Metodos.password = "admin";
                root.getChildren().clear();
                root.setCenter(admin_pane.getRoot());
            }else if(Metodos.esProfesor(usuario, contra)){
                ProfePane profe_pane = new ProfePane();
                root.getChildren().clear();
                root.setCenter(profe_pane.getRoot());
            }else{
                warningMessage.setText("Contraseña o correo INCORRECTO");
            }
            
        });
        
        salir.setOnMouseClicked((event) -> {
            System.exit(0);
        });
        
        HBox hb = new HBox(ingresar, salir);
        hb.setAlignment(Pos.CENTER); hb.setSpacing(50);
        warningMessage.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        warningMessage.setTextFill(Color.RED);
        warningMessage.setTranslateY(-30);
        vb.getChildren().addAll(hb,warningMessage);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(70);
        return vb;
    }
    
     public Pane getRoot(){
        return root;
    }
}
