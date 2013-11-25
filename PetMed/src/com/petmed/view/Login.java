/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


/**
 *
 * @author rbalda
 */
public class Login extends JFrame {
    private JLabel usernamelbl;
    private JLabel passwordlbl;
    private JTextField usernametxt;
    private JPasswordField passwordtxt;
    private JButton accept;
    private JButton cancel;
    
    private void init(){        
        usernamelbl = new JLabel("Usuario");
        passwordlbl = new JLabel("Contraseña");
        usernametxt = new JTextField();
        passwordtxt = new JPasswordField(); 
        accept = new JButton("Ingresar");
        cancel = new JButton("Cancelar");
    }
    
    public Login(){
        this.init();
        Container c = getContentPane();
        JPanel panel = new JPanel(new GridLayout(2,2));
        JPanel panel2 = new JPanel(new FlowLayout());
        c.setLayout(new BorderLayout());
        panel.add(usernamelbl);
        panel.add(usernametxt);
        panel.add(passwordlbl);        
        panel.add(passwordtxt);
        panel2.add(accept);
        panel2.add(cancel);
        c.add(panel,BorderLayout.CENTER);
        c.add(panel2,BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    
    }
    
    
    
    
    
}
