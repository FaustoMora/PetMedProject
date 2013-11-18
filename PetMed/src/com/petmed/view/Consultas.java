/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

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
public class Consultas extends JFrame{
    private static Consultas Consultas;
    JLabel text;
    JTextField campo;
    JButton b;
    Panel_interno p;
    
    public Consultas(){
        super("Aplicacion");
        text = new JLabel("Texto de Prueba");
        campo = new JTextField("escriba aqui");
        b = new JButton("Hazme Clic");
        p = new Panel_interno();
        Container c;
        c= getContentPane();
        c.setLayout(new BorderLayout());
        c.add(campo,BorderLayout.NORTH);
        c.add(text,BorderLayout.SOUTH);
        c.add(b,BorderLayout.EAST);
        c.add(p,BorderLayout.CENTER);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    public static void main(String args[]){
        Consultas =new Consultas();
    }
    
}
