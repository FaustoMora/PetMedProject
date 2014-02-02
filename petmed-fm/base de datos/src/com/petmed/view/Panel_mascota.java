/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;


import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.petmed.DAO.MascotaDAO;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author sjronqui
 */
public class Panel_mascota extends JPanel{
    JTextField txt_nombre;
    JTextField txt_raza;
    JTextField txt_dueño;
    JDateChooser txt_nacimiento;
    Choice ch_especie;
    JButton btn_cancelar;
    JButton btn_guardar;
    JRadioButton rb_hembra;
    JRadioButton rb_macho;
    ButtonGroup gp_sexo;
    String sex;
    
	
    public Panel_mascota(){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_nacimiento = new JLabel("Fecha de nacimiento:");
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_dueño = new JLabel("Cliente:");
        JLabel lbl_especie = new JLabel("Especie:");
        JLabel lbl_raza = new JLabel("Raza:");
        JLabel lbl_sexo = new JLabel("Sexo:");
        

        txt_nacimiento = new JDateChooser();
        txt_nombre = new JTextField(20);
        txt_raza = new JTextField(10);
        txt_dueño = new JTextField(45);

        rb_macho = new JRadioButton("M");
        rb_macho.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Panel_mascota.this.sex= Panel_mascota.this.rb_macho.getText();
			}
		});
        
        rb_hembra = new JRadioButton("F");
        rb_hembra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Panel_mascota.this.sex= Panel_mascota.this.rb_hembra.getText();
			}
		});
        
        ch_especie = new Choice();
        ch_especie.add("Canina");
        ch_especie.add("Felina");
        
        gp_sexo = new ButtonGroup();
        gp_sexo.add(rb_macho);
        gp_sexo.add(rb_hembra);
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        
        this.btn_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Panel_mascota.this.borrarCampos();
			}
		});
        
        this.btn_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom,esp,raza,sexo,dueño;
				Date fecha_nacimiento;
                                fecha_nacimiento= Panel_mascota.this.txt_nacimiento.getDate();
				
				nom=Panel_mascota.this.txt_nombre.getText();
				raza=Panel_mascota.this.txt_raza.getText();
				esp=Panel_mascota.this.ch_especie.getSelectedItem();
				sexo=Panel_mascota.this.sex;
                                dueño=Panel_mascota.this.txt_dueño.getText();
				// TODO Auto-generated method stub
                                new MascotaDAO().ingresarMascota(nom, esp, raza, fecha_nacimiento, sexo, dueño);
                                Panel_mascota.this.borrarCampos();
			}
		});
        
        
        
        /*gbc.ipadx=10;
        gbc.ipady=5;*/
        gbc.insets=new Insets(5,10,0,5);
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor= GridBagConstraints.EAST;
        gbc.gridwidth=1;
        
        this.add(lbl_dueño,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_dueño,gbc);
        
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
    
    public void borrarCampos(){
        this.txt_dueño.setText("");
    	this.txt_nombre.setText("");
    	this.txt_raza.setText("");
    	this.ch_especie.select("Canina");
    	this.gp_sexo.clearSelection();
    }
    
}
