/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.DAO.FarmacoDAO;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_farmaco extends JPanel{
    Choice ch_presentacion;
    Choice ch_unidad;
    Choice ch_unidad2;
    JTextField txt_nombre;
    JTextField txt_cantidad;
    JButton btn_cancelar;
    JButton btn_guardar;
    
    public Panel_farmaco(){
        this.setPreferredSize(new Dimension(550,300));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_nombre= new JLabel("Nombre del fármaco:");
        JLabel lbl_presentacion= new JLabel("Presentación:");
        JLabel lbl_dosis=new JLabel("Dosis:");
        JLabel lbl_auxiliar = new JLabel("por cada");
        
        txt_nombre=new JTextField(15);
        txt_cantidad= new JTextField(4);
 
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        
        
        ch_presentacion=new Choice();
        ch_presentacion.add("");
        ch_presentacion.add("Jarabe");
        ch_presentacion.add("Capsula");
        ch_presentacion.add("Pildora");
        ch_presentacion.add("Gel");
        ch_presentacion.add("Vacuna");
        
        ch_unidad= new Choice();
        ch_unidad.add("g");
        ch_unidad.add("ml");
        ch_unidad.add("oz");
        
        ch_unidad2= new Choice();
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
        
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        
        
        this.btn_cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_farmaco.this.borrarCampos();
            }
        });
        
        this.btn_guardar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                String nom,pres,concen, concen2, dosis,cant;
					
                nom = txt_nombre.getText();
                pres= ch_presentacion.getSelectedItem();
                cant = txt_cantidad.getText();
                concen = ch_unidad.getSelectedItem();
                concen2 = ch_unidad2.getSelectedItem();
                
                new FarmacoDAO().ingresarFarmaco(nom, pres, cant, concen, concen2);
                Panel_farmaco.this.borrarCampos();
            }
        });
        
    }

    void borrarCampos() {
        this.txt_cantidad.setText("");
        this.txt_nombre.setText("");
        this.ch_presentacion.select(0);
        this.ch_unidad.select(0);
        this.ch_unidad2.select(0);
    }
}
