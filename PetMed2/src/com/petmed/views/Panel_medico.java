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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Lost Legion
 */
public class Panel_medico extends JPanel{
        JButton btn_guardar;
	JButton btn_cancelar;
        JButton btn_modificar;
	JTextField txt_telefono;
	JTextField txt_nombre;

	
	
    public Panel_medico (int m){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_nombre = new JLabel("Nombre:");
        JLabel lbl_telefono = new JLabel("Teléfono:");
        
        
        txt_nombre = new JTextField(45);
        txt_telefono = new JTextField(10);

        
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_modificar=new JButton("Modificar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        /*
        btn_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nom, apell,tlf;

				// TODO Auto-generated method stub
				nom = Panel_medico.this.txt_nombre.getText();
				apell =Panel_medico.this.txt_apellido.getText();
				tlf = Panel_medico.this.txt_telefono.getText();
				
				//Panel_medico.this.clienteDAO.modificarCliente(nom, apell, dir, tlf);
				new MedicoDAO().ingresarMedico(nom, apell, tlf);
				Panel_medico.this.borrarCampos();
				
			
			}
		});
        
        btn_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Panel_medico.this.borrarCampos();
			}
		});
        */
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        
        gbc.gridwidth=0;
        this.add(new JLabel("ADMINISTRACION PERSONAL MEDICO"),gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
             
        
        gbc.gridwidth=1;
        this.add(lbl_telefono,gbc);
        
//        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_telefono,gbc);
        
        gbc.gridx=1;
        gbc.gridy=5;
        pnl_boton.add(btn_cancelar);
        if(m==1){ pnl_boton.add(btn_modificar);}
        else {pnl_boton.add(btn_guardar);}
        this.add(pnl_boton,gbc);
        this.setPreferredSize(new Dimension(500,200));
    }
    
    public void borrarCampos(){
		this.txt_nombre.setText("");
		this.txt_telefono.setText("");
    }
}
