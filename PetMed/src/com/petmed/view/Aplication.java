/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author rbalda
 */
public class Aplication extends JFrame{
    private static Aplication aplication;
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

        c.add(panel_superior,BorderLayout.NORTH);
        c.add(new Panel_opciones(), BorderLayout.WEST);
        c.add(new Panel_inferior(),BorderLayout.CENTER);
      

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(750,550);
        this.setLocationRelativeTo(null);
    }
    
    public static void main(String args[]){
        aplication = new Aplication();
        new Login();
        //Conexion();
        
        
    }
    
    private static void Conexion(){
        
        String connectionUrl="jdbc:mysql://localhost:3306/test";
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql="select * from Empleados;";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(connectionUrl, "root", "root");
            
            stm= con.createStatement();
            rs=stm.executeQuery(sql);
                System.out.println("    Id         Nombre");
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
