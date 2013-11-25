/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sjronqui
 */
public class Panel_historial_mascota extends JPanel{
        DefaultTableModel tabla;
        final JTable dtm;
        
    public Panel_historial_mascota(){
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_de= new JLabel("Cliente:");
        JLabel lbl_hasta= new JLabel("Nombre de la mascota:");
        
        JTextField txt_cliente=new JTextField(20);
        JTextField txt_mascota=new JTextField(10);
                 
        String columNames[] = {"Fecha","Síntomas","Diagnostico" ,"Tratamiento"};
        
        tabla = new DefaultTableModel(columNames,30);
        
        dtm = new JTable(tabla);
        dtm.setPreferredScrollableViewportSize(new Dimension(550,300));
        JScrollPane scroll = new JScrollPane(dtm);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
        JPanel pnl_entrada= new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl_entrada.add(lbl_de);
        pnl_entrada.add(txt_cliente);
        pnl_entrada.add(lbl_hasta);
        pnl_entrada.add(txt_mascota);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.anchor=GridBagConstraints.WEST;
        
        gbc.weightx=GridBagConstraints.REMAINDER;
        this.add(pnl_entrada,gbc);
        
        gbc.anchor=GridBagConstraints.PAGE_END;
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(panel,gbc);
    }
    
}
