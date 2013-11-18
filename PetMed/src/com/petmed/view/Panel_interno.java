/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.GridLayout;
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
        setLayout(new GridLayout(3,1));
        add(text);
        add(campo);
        add(b);
    }
}
