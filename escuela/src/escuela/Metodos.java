/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela;

import Panes.Constantes;
import Panes.LoginPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class Metodos {
    private static Connection con;
    private static Statement st;
    private static final String myIP = "192.168.43.203:3307";
    public static String usedDatabase = "raulmendozadb";
    public static String username;
    public static String password;
    
    public static boolean esAdmin(String user, String password){
        if(user.equals("admin") && password.equals("admin"))
            return true;
        return false;
    }
    
    public static boolean esProfesor(String user, String password){
        if(user.equals("prof") && password.equals("prof"))
            return true;
        return false;
    }
    
    public static ImageView botonAtras(){
        Image atras = new Image(Constantes.ruta+"atras.png",40,40,true,true);
        ImageView img_atras = new ImageView(atras);
        return img_atras;
    }
    
    public static Button botonBuscar(){
        Image buscar = new Image(Constantes.ruta+"lupa.png",30,30,true,true);
        ImageView img_buscar = new ImageView(buscar);
        Button button_buscar = new Button("",img_buscar);
        return button_buscar;  
    }
    
     public static Pane logoEscuela(){
        Image escuela = new Image(Constantes.ruta+"escuela.png",120,120,true,true);
        ImageView img_escuela = new ImageView(escuela);
        Label Lescuela = new Label("Unidad Educativa Dr. Raúl Mendoza Avilés"); Lescuela.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        VBox vb = new VBox(img_escuela, Lescuela); vb.setAlignment(Pos.CENTER); vb.setTranslateY(20);
        return vb;
    }
     
     public static Pane botonCerrarSession(BorderPane root){
        Image logout = new Image(Constantes.ruta+"logout.png",40,40,true,true);
        ImageView img_logout = new ImageView(logout);
        Label cerrar = new Label("Cerrar session"); cerrar.setFont(Font.font("Arial", FontWeight.BOLD, 25)); 
        HBox hb = new HBox(img_logout, cerrar); hb.setSpacing(20); hb.setTranslateX(50); hb.setTranslateY(-20);
        hb.setOnMouseClicked( (event) -> {
            LoginPane login = new LoginPane();
            root.getChildren().clear();
            root.setCenter( login.getRoot() );
        });
        return hb;
    }
     
     public static void doQuery(String query) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://"+myIP+"/"+usedDatabase,username,password);
        st = con.createStatement();
        st.executeUpdate(query);
    }
     
     public static void getResponseQuery(String query) throws SQLException{
        st = con.createStatement();
        String sql = ("SELECT * FROM posts ORDER BY id DESC LIMIT 1;");
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()) { 
            int id = rs.getInt("first_column_name"); 
            String str1 = rs.getString("second_column_name");
        }
     }
}
