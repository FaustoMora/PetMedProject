/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.DAO.*;
import com.petmed.models.DataConexion;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 *
 * @author rbalda
 */
public class Aplication extends JFrame{
    private static Aplication aplication;
    private static DataConexion Conexion = DataConexion.getInstance();
    
    JLabel text;
    JTextField campo;
    JButton b;
    Panel_superior panel_superior;
    
    public Aplication(){
        super("Pet Med");
        text = new JLabel("Texto de Prueba");
        panel_superior= new Panel_superior();
        Container c;
        c= getContentPane();
        c.setLayout(new BorderLayout());

        c.add(panel_superior,BorderLayout.CENTER);
        c.add(new Panel_opciones(), BorderLayout.WEST);

      

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLocationRelativeTo(null);
        
    this.addWindowListener(new WindowAdapter(){

        public void windowClosing(WindowEvent we){
           Aplication.Conexion.closeConnection();
           System.exit(0);
        }   

    });
    }
    
    public static void main(String args[]){
        System.out.println(Runtime.getRuntime().maxMemory());
        aplication = new Aplication();
        new Login();
        
    }

}
