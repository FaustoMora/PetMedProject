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
public class Panel_cita extends JPanel{
    public Panel_cita(){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_fecha = new JLabel("Fecha de cita:");
        JLabel lbl_hora = new JLabel("Hora:");
        JLabel lbl_medico = new JLabel("Médico:");
        
        Date fecha= new Date();
        JTextField txt_fecha = new JTextField(fecha.toString());
        JTextField txt_nombre = new JTextField(20);
        JTextField txt_hora = new JTextField(5);
        JTextField txt_medico = new JTextField(20);
        
        JButton btn_cancelar = new JButton("Cancelar");
        JButton btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_medico,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_medico,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_fecha,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_fecha,gbc);  
        
        gbc.gridwidth=1;
        this.add(lbl_hora,gbc);
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_hora,gbc);       
        
        gbc.gridx=1;
        gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        
        this.setPreferredSize(new Dimension(400,200));
    }
    
}
