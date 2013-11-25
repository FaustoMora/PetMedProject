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
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_cliente extends JPanel{
    
    public Panel_cliente (){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_fecha = new JLabel("Fecha de registro:");
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_apellido = new JLabel("Apellido:");
        JLabel lbl_direccion = new JLabel("Dirección:");
        JLabel lbl_telefono = new JLabel("Teléfono:");
        
        Date fecha= new Date();
        JTextField txt_fecha = new JTextField(fecha.toString());
        JTextField txt_nombre = new JTextField(20);
        JTextField txt_apellido = new JTextField(20);
        JTextField txt_direccion = new JTextField(40);
        JTextField txt_telefono = new JTextField(10);
        
        txt_fecha.setColumns(50);
        txt_nombre.setColumns(30);
        
        JButton btn_cancelar = new JButton("Cancelar");
        JButton btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_fecha,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_fecha,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_apellido,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_apellido,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_direccion,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_direccion,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_telefono,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_telefono,gbc);
        
        gbc.gridx=1;
        gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        this.setPreferredSize(new Dimension(400,200));
    }
    
}
