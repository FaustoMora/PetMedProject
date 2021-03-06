/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

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
    
    JDateChooser txt_nacimiento;
    JTextField txt_nombre;
    JTextField txt_raza;
    JButton btn_cancelar ;
    JButton btn_guardar ;
    JButton btn_modificar;
    ButtonGroup gp_sexo;
    Choice ch_especie;
    JRadioButton rb_macho ;
    JRadioButton rb_hembra ;
        
        
    public Panel_mascota(int m){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_nacimiento = new JLabel("Fecha de nacimiento:");
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_especie = new JLabel("Especie:");
        JLabel lbl_raza = new JLabel("Raza:");
        JLabel lbl_sexo = new JLabel("Sexo:");
        

        txt_nacimiento = new JDateChooser();
        txt_nombre = new JTextField(20);
        txt_nombre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        txt_raza = new JTextField(10);
        txt_raza.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        

        rb_macho = new JRadioButton("Macho");
        rb_macho.setActionCommand("M");
        rb_hembra = new JRadioButton("Hembra");
        rb_hembra.setActionCommand("H");
        
        ch_especie = new Choice();
        ch_especie.add("Canina");
        ch_especie.add("Felina");
        
        gp_sexo = new ButtonGroup();
        gp_sexo.add(rb_macho);
        gp_sexo.add(rb_hembra);
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_modificar=new JButton("Modificar");
        
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
        if(m==1){ pnl_boton.add(btn_modificar);}
        else {pnl_boton.add(btn_guardar);}
        this.add(pnl_boton,gbc);
        
        this.setPreferredSize(new Dimension(400,300));
    }
    
}
