/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panes;

import javafx.scene.layout.Pane;

/**
 *
 * @author jeffer
 */
public class GeneralPane {
    private Pane root;
    private LoginPane login;
    
    
    public GeneralPane(){
        root = new Pane();
        login = new LoginPane();
        root.getChildren().addAll( login.getRoot() );
    }
    
    public Pane getRoot(){
        return root;
    }
}
