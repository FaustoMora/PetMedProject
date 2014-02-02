/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_farmaco extends JPanel{
    public Panel_farmaco(){
        this.setPreferredSize(new Dimension(550,300));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_nombre= new JLabel("Nombre del fármaco:");
        JLabel lbl_presentacion= new JLabel("Presentación:");
        JLabel lbl_dosis=new JLabel("Dosis:");
        JLabel lbl_auxiliar = new JLabel("por cada");
        
        JTextField txt_nombre=new JTextField(15);
        
        
        JTextField txt_cantidad= new JTextField(4);
 
        
        Choice ch_presentacion=new Choice();
        ch_presentacion.add("Jarabe");
        ch_presentacion.add("Cápsula");
        ch_presentacion.add("Píldora");
        ch_presentacion.add("Gel");
        
        Choice ch_unidad= new Choice();
        ch_unidad.add("g");
        ch_unidad.add("ml");
        ch_unidad.add("oz");
        
        Choice ch_unidad2= new Choice();
        ch_unidad2.add("g");
        ch_unidad2.add("Kg");
        ch_unidad2.add("lb");
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        this.add(txt_nombre,gbc);
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=1;
        this.add(lbl_presentacion,gbc);
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(ch_presentacion,gbc);
        gbc.gridwidth=1;
        this.add(lbl_dosis,gbc);
        this.add(txt_cantidad,gbc);
        this.add(ch_unidad,gbc);
        this.add(lbl_auxiliar,gbc);
        this.add(ch_unidad2,gbc);
        
        
    }
}
