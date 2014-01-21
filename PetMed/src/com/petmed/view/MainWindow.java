/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rbalda
 */
public class MainWindow extends JFrame{
    private JPanel toolbar;
    private JPanel content;
    private ArrayList <JButton> options;
    
    private void addingListeners(){
        options.get(1).addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               content= new CreateCitas();
               //getContentPane().add(content,BorderLayout.CENTER);
               getContentPane().repaint();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    private void loadOptions(){
        options.add(new JButton("Clientes"));
        options.add(new JButton("Citas"));        
        options.add(new JButton("Consultas Medicas"));
        options.add(new JButton("Vacunas"));
        options.add(new JButton("Fisiologia de Mascotas"));
        options.add(new JButton("Perfiles"));
        options.add(new JButton("Usuarios"));
        
        for(JButton b:options)
            toolbar.add(b);
    }
    
    private void init(){
        options = new ArrayList<JButton>();
        toolbar = new JPanel();
        toolbar.setLayout(new FlowLayout());
        content = new JPanel();
    }
    
    public MainWindow(){
        super("Sistema de Administracion Veterinaria");
        init();
        loadOptions();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(toolbar,BorderLayout.NORTH);
        c.add(content,BorderLayout.CENTER);
        setVisible(true);
        pack();
    }
    
    
}
