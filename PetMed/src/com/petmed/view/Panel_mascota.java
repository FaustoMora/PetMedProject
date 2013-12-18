/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_mascota extends JPanel{
    public Panel_mascota(){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_nacimiento = new JLabel("Fecha de nacimiento:");
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_especie = new JLabel("Especie:");
        JLabel lbl_raza = new JLabel("Raza:");
        JLabel lbl_sexo = new JLabel("Sexo:");
        

        JDateChooser txt_nacimiento = new JDateChooser();
        JTextField txt_nombre = new JTextField(20);
        txt_nombre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        JTextField txt_raza = new JTextField(10);
        txt_raza.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        

        JRadioButton rb_macho = new JRadioButton("Macho");
        JRadioButton rb_hembra = new JRadioButton("Hembra");
        
        Choice ch_especie = new Choice();
        ch_especie.add("Canina");
        ch_especie.add("Felina");
        
        ButtonGroup gp_sexo = new ButtonGroup();
        gp_sexo.add(rb_macho);
        gp_sexo.add(rb_hembra);
        
        JButton btn_cancelar = new JButton("Cancelar");
        JButton btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        /*gbc.ipadx=10;
        gbc.ipady=5;*/
        gbc.insets=new Insets(5,10,0,5);
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_nacimiento,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nacimiento,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_sexo,gbc);
        
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=1;
        this.add(rb_macho,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(rb_hembra,gbc);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=1;
        gbc.anchor=GridBagConstraints.EAST;
        this.add(lbl_especie,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(ch_especie,gbc);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=1;
        gbc.anchor=GridBagConstraints.EAST;
        this.add(lbl_raza,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_raza,gbc);
        
        gbc.gridx=1;
        //gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        
        this.setPreferredSize(new Dimension(400,300));
    }
    
}
