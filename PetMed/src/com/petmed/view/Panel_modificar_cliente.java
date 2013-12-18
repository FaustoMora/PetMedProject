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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class Panel_modificar_cliente extends JPanel{
     DefaultTableModel tabla;
        final JTable dtm;
        
    public Panel_modificar_cliente(){
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_nombre= new JLabel("Nombre del Cliente:");
        
        JTextField txt_nombre=new JTextField(15);
        txt_nombre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
                 
        String columNames[] = {"Nombre","Dirección","Nombre Mascota" ,"Especie" ,"Fecha de registro"};
        
        tabla = new DefaultTableModel(columNames,12);
        
        dtm = new JTable(tabla);
        dtm.setPreferredScrollableViewportSize(new Dimension(550,200));
        JScrollPane scroll = new JScrollPane(dtm);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
        JPanel pnl_entrada= new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl_entrada.add(lbl_nombre);
        pnl_entrada.add(txt_nombre);
        
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
