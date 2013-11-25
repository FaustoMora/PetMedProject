/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Frame_autentificacion extends JFrame{
    JLabel user;
    JLabel password;
    JTextField campo;
    JButton aceptar;
    
    
    public Frame_autentificacion(){
        super("Pet Med");
        user = new JLabel("Usuario");
        password = new JLabel("Contraseña");
        JTextField txt_user = new JTextField(15);
        JPasswordField txt_password = new JPasswordField(15);
        
        Container c;
        c= getContentPane();
        c.setLayout(new BorderLayout());
        
        JPanel pnl_usuario = new JPanel(new GridLayout(0,2));
        pnl_usuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(1),"Identificación"));
        pnl_usuario.setPreferredSize(new Dimension(300,100));
        pnl_usuario.add(user);
        pnl_usuario.add(txt_user);
        pnl_usuario.add(password);
        pnl_usuario.add(txt_password);
        
        
        c.add( pnl_usuario,BorderLayout.WEST);
        c.add(new JButton("Ingresar"),BorderLayout.SOUTH);

        this.setBackground(Color.red);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,150);
//        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    
    
}
