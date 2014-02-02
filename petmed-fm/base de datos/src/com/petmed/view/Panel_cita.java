/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;


import com.petmed.DAO.CitaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_cita extends JPanel{
        
        JTextField txt_nombre;
        JTextField txt_hora;     
        JButton btn_cancelar;
        JButton btn_guardar;
        Choice listaHoras;
    
    
    public Panel_cita(){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_fecha = new JLabel("Fecha de cita:");
        JLabel lbl_hora = new JLabel("Hora:");
        
        
        
        JDateChooser txt_fecha = new JDateChooser();
        txt_nombre = new JTextField(20);        
        txt_hora = new JTextField(6);        
        

        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        this.listaHoras=new Choice();
        this.crearChoice();
        
        
        
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
        
        
        gbc.gridwidth=1;
        this.add(lbl_fecha,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_fecha,gbc);  
        
        gbc.gridwidth=1;
        this.add(lbl_hora,gbc);
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(this.listaHoras,gbc);       
        
        gbc.gridx=1;
        gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        
        this.setPreferredSize(new Dimension(400,200));
        
        
        this.btn_cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_cita.this.borrarCampos();
            }
        });
        
        this.btn_guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               String hora, nombre;
               Date fecha_cita = new Date();
               
               hora=Panel_cita.this.listaHoras.getSelectedItem();
               nombre=Panel_cita.this.txt_nombre.getText();
               
               
               new CitaDAO().ingresarCita(nombre, fecha_cita, hora);
               Panel_cita.this.borrarCampos();
            }
        });       
    }
    
    public void borrarCampos(){
        this.txt_hora.setText("");
        this.txt_nombre.setText("");
        this.listaHoras.select(0);
    }
    
    public void crearChoice(){
        this.listaHoras.add("08:00");this.listaHoras.add("08:30");this.listaHoras.add("09:00");this.listaHoras.add("09:30");
        this.listaHoras.add("10:00");this.listaHoras.add("10:30");this.listaHoras.add("11:00");this.listaHoras.add("11:30");
        this.listaHoras.add("12:00");this.listaHoras.add("12:30");this.listaHoras.add("13:00");this.listaHoras.add("13:30");
        this.listaHoras.add("14:00");this.listaHoras.add("14:30");this.listaHoras.add("15:00");this.listaHoras.add("15:30");
        this.listaHoras.add("16:00");this.listaHoras.add("16:30");
    }
}
