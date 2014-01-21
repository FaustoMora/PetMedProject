/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.models.ClienteDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sjronqui
 */
public class Panel_cliente extends JPanel{
    ClienteDAO cd;
    public Panel_cliente (){
        cd=new ClienteDAO();
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        this.setLayout(layout);
        
        JLabel lbl_fecha = new JLabel("Fecha de registro: ");
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_apellido = new JLabel("Apellido:");
        JLabel lbl_direccion = new JLabel("Dirección:");
        JLabel lbl_telefono = new JLabel("Teléfono:");
        
        Calendar calendario = new GregorianCalendar();
        JLabel txt_fecha = new JLabel(""+calendario.get(Calendar.DAY_OF_MONTH)+"/"+calendario.get(Calendar.MONTH)+"/"+calendario.get(Calendar.YEAR));
        
        final JTextField txt_nombre = new JTextField(20);
        txt_nombre.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");                    
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        final JTextField txt_apellido = new JTextField(20);
        txt_apellido.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        final JTextField txt_direccion = new JTextField(25);
        txt_direccion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]+[a-zA-Z0-9\\.*\\s*]{3.}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        final JTextField txt_telefono = new JTextField(10);
        txt_telefono.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[0-9]{7}|[0-9]{10}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        
        JButton btn_cancelar = new JButton("Cancelar");
        JButton btn_guardar = new JButton("Guardar");
        btn_guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {               
                Date d=new Date(100000);
                cd.storage("HOLA","MUNDO",12345567, d );
            }
        });
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
        
        gbc.fill=GridBagConstraints.NONE;
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
