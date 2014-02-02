/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.DAO.*;
import com.petmed.DAO.*;
import com.petmed.models.DataConexion;
import com.petmed.models.Validacion;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Panel_cliente extends JPanel{
	ClienteDAO clienteDAO = new ClienteDAO();
	JButton btn_guardar;
	JButton btn_cancelar;
	JTextField txt_telefono;
	JTextField txt_nombre;
	Calendar calendario;
	JTextField txt_apellido;
	JTextField txt_direccion;
	
	public final static String MESSAGEINFO = "Panel_Cliente";
	
    public Panel_cliente (){
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
        
        txt_nombre = new JTextField(20);
        txt_apellido = new JTextField(20);
        txt_direccion = new JTextField(25);
        txt_telefono = new JTextField(10);

        
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        
        btn_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom, apell, dir, tlf;

				// TODO Auto-generated method stub
				nom = Panel_cliente.this.txt_nombre.getText();
				apell =Panel_cliente.this.txt_apellido.getText();
				dir = Panel_cliente.this.txt_direccion.getText();
				tlf = Panel_cliente.this.txt_telefono.getText();
				
				//Panel_cliente.this.clienteDAO.modificarCliente(nom, apell, dir, tlf);
				Panel_cliente.this.clienteDAO.insertarCliente(nom, apell, dir, tlf);
				Panel_cliente.this.borrarCampos();
				
			
			}
		});
        
        btn_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Panel_cliente.this.borrarCampos();
			}
		});
        
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
    
    public void borrarCampos(){
		this.txt_apellido.setText("");
		this.txt_nombre.setText("");
		this.txt_direccion.setText("");
		this.txt_telefono.setText("");
    }
    
    public String getMessage(){
    	return this.MESSAGEINFO;
    }
    
}
