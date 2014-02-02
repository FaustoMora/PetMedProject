/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Date;

/**
 *
 * @author sjronqui
 */
public class Panel_cliente extends JPanel implements FrameInternal{
        JLabel lbl_fecha ;
        JLabel lbl_nombre;
        JLabel lbl_apellido;
        JLabel lbl_direccion ;
        JLabel lbl_telefono ;
        JButton btn_cancelar ;
        JButton btn_guardar ;
        JButton btn_modificar;
        JTextField txt_nombre;
        JTextField txt_apellido ;
        JTextField txt_direccion ;
        JTextField txt_telefono ;
        
        //Revisar:
        Date fecha;
    
    public Panel_cliente (int m){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        fecha=new Date();
        
        lbl_nombre = new JLabel("Nombre:");
        lbl_apellido = new JLabel("Apellido:");
        lbl_direccion = new JLabel("Dirección:");
        lbl_telefono = new JLabel("Teléfono:");
        
                
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
        txt_apellido = new JTextField(20);
        txt_apellido.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        txt_direccion = new JTextField(25);
        txt_direccion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]+[a-zA-Z0-9\\.*\\s*]{3.}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        txt_telefono = new JTextField(10);
        txt_telefono.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[0-9]{7}|[0-9]{10}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_modificar=new JButton("Modificar");
        
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        //this.add(lbl_fecha,gbc);
        
        //gbc.gridwidth=GridBagConstraints.REMAINDER;
        //this.add(txt_fecha,gbc);
        
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
        
        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_telefono,gbc);
        
        gbc.gridx=1;
        gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        if(m==1){ pnl_boton.add(btn_modificar);}
        else {pnl_boton.add(btn_guardar);}
        this.add(pnl_boton,gbc);
        this.setPreferredSize(new Dimension(400,200));
    }

    @Override
    public JButton getSaveButton() {
        return btn_guardar;
    }
    
}
