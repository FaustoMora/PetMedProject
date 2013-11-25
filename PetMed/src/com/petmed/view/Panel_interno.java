/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rbalda
 */
public class Panel_interno extends JPanel {
    JLabel text;
    JTextField campo;
    JButton b;    
    
    public Panel_interno(){
        text = new JLabel("Texto de Prueba Interno");
        campo = new JTextField("escriba aqui interno");
        b = new JButton("Hazme Clic interno");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("ha habido un clic"); //To change body of generated methods, choose Tools | Templates.
            }
        });
        setLayout(new GridLayout(3,1));
        add(text);
        add(campo);
        add(b);
    }
}
