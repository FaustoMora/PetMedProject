/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sjronqui
 */
public class Panel_tratamiento extends JPanel {
    DefaultTableModel tabla;
        final JTable dtm;
    public Panel_tratamiento(){
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_descripcion= new JLabel("Descripcion:");
        JTextArea txt_descripcion=new JTextArea();
        txt_descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(4);       
        
        String columNames[] = {"Fármaco","Cantidad","Detalle"};
        
        tabla = new DefaultTableModel(columNames,10);
        
        dtm = new JTable(tabla);
        dtm.setPreferredScrollableViewportSize(new Dimension(350,100));
        JScrollPane scroll = new JScrollPane(dtm);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=GridBagConstraints.REMAINDER;
        gbc.anchor=GridBagConstraints.WEST;
        
        gbc.gridx=0;
        gbc.gridy=0;
        this.add(lbl_descripcion,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.anchor=GridBagConstraints.CENTER;
        this.add(txt_descripcion,gbc);
        
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(panel,gbc);
    }
    
}
