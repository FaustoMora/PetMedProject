/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.DAO.CitaDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import com.petmed.DAO.ClienteDAO;
import com.petmed.DAO.FarmacoDAO;
import com.petmed.DAO.MascotaDAO;
import com.petmed.DAO.MedicoDAO;
import java.util.Date;

/**
 *
 * @author sjronqui
 */
public class Panel_opciones extends JPanel{
    JButton[] opciones = {new JButton("Crear Nuevo"),new JButton("Modificar"), new JButton("Eliminar")
                         , new JButton("Nuevos Clientes") , new JButton("Lista de Citas") , new JButton("Citas por\nCliente")
                          , new JButton("Lista de\nConsultas") , new JButton("Historial Médico") , new JButton("Consultas por Síntoma")
                         , new JButton("Consultas por Diagnóstico") , new JButton("Historial de Fisiología"), new JButton("Nuevos Clientes") 
                         , new JButton("Consultar Usuario") , new JButton("Consultas por Médico")};
    
    
    public Panel_opciones(){
        this.setLocation(0, 0);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.setBackground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(150,250));
        
        
        opciones[0].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[1].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[2].setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        this.add(opciones[0]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[1]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[2]);
                
       /* 
        opciones[3].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[4].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[5].setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        this.add(opciones[3]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[4]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[5]);/*
        
        /*opciones[6].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[6].setPreferredSize(new Dimension(150, 300));
        opciones[7].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[8].setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones[9].setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(Box.createRigidArea(new Dimension(0,40)));
        this.add(opciones[6]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[7]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[8]);
        this.add(Box.createRigidArea(new Dimension(0,30)));
        this.add(opciones[9]);*/
        
        //-------------------------MODIFICACIONES---------------------
        this.opciones[1].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				JPanel panel = (JPanel)Panel_superior.herramientas.getSelectedComponent();
                                
				if(panel instanceof Panel_cliente){
					String nom, apell, dir, tlf;
					Panel_cliente panel_cliente = (Panel_cliente)panel;
					
					nom = panel_cliente.txt_nombre.getText();
					apell = panel_cliente.txt_apellido.getText();
					dir = panel_cliente.txt_direccion.getText();
					tlf = panel_cliente.txt_telefono.getText();
					
					JOptionPane.showMessageDialog(null, nom + apell + dir +tlf);
					new ClienteDAO().modificarCliente(nom, apell, dir, tlf);
					panel_cliente.borrarCampos();
				}
                                
                                if(panel instanceof Panel_mascota){
					String nom, esp, raza, sexo, dueño;
                                        Date fecha;
					Panel_mascota panel_mascota = (Panel_mascota)panel;
					
					nom = panel_mascota.txt_nombre.getText();
					dueño = panel_mascota.txt_dueño.getText();
					esp = panel_mascota.ch_especie.getSelectedItem();
					raza = panel_mascota.txt_raza.getText();
                                        sexo = panel_mascota.sex;
                                        fecha = new Date();
					
                                        
					JOptionPane.showMessageDialog(null, nom + " " + dueño  + " " + esp + " " + raza + " " + sexo);
                                        new MascotaDAO().modificarMascota(nom, esp, raza,fecha,sexo,dueño);
					panel_mascota.borrarCampos();
				}
                                
                                if(panel instanceof Panel_cita){
                                    	String nom, hora;
                                        Date fecha;
					Panel_cita panel_cita = (Panel_cita)panel;
					
					nom = panel_cita.txt_nombre.getText();				
					hora = panel_cita.listaHoras.getSelectedItem();
                                        fecha = new Date();
					
                                        
					JOptionPane.showMessageDialog(null, nom + " " + hora + " " + fecha);
					new CitaDAO().modificarCita(nom, fecha, hora);
					panel_cita.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_farmaco){
                                    	String nom,pres,concen, concen2,cant;
					Panel_farmaco panel_farmaco = (Panel_farmaco)panel;
					
					nom = panel_farmaco.txt_nombre.getText();
					pres= panel_farmaco.ch_presentacion.getSelectedItem();
                                        cant = panel_farmaco.txt_cantidad.getText();
                                        concen = panel_farmaco.ch_unidad.getSelectedItem();
                                        concen2 = panel_farmaco.ch_unidad2.getSelectedItem();
                                        
                                        
					JOptionPane.showMessageDialog(null,nom + " " + pres + " " + cant + " " + concen + "/" + concen2);
                                        new FarmacoDAO().modificarFarmaco(nom,pres,cant,concen,concen2);
                                        panel_farmaco.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_medico){
                                    	String nom,apell, tlf;
					Panel_medico panel_medico = (Panel_medico)panel;
					
					nom = panel_medico.txt_nombre.getText();
                                        apell = panel_medico.txt_apellido.getText();
                                        tlf = panel_medico.txt_telefono.getText();

					JOptionPane.showMessageDialog(null,nom + " " + apell+ " " + tlf);
                                        new MedicoDAO().modificarMedico(nom,apell,tlf);
                                        panel_medico.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_DatosMedico){
                                    Panel_DatosMedico panel_datosMedico = (Panel_DatosMedico)panel;
                                    panel_datosMedico.modificarOpcion();
                                }
			}
		});
        
        
        //-------------------------ELIMINACIONES---------------------
        this.opciones[2].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            JPanel panel = (JPanel)Panel_superior.herramientas.getSelectedComponent();
				if(panel instanceof Panel_cliente){
					String nom, apell;
					Panel_cliente panel_cliente = (Panel_cliente)panel;

					nom = panel_cliente.txt_nombre.getText();
                                        apell = panel_cliente.txt_apellido.getText();
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar cliente: " + nom  + " " + apell, "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            
                                            if(res==JOptionPane.YES_OPTION){
                                                new ClienteDAO().eliminarCliente(nom,apell);
                                            }
                                        
					panel_cliente.borrarCampos();
				}
                                
                                if(panel instanceof Panel_mascota){
					String nom,dueño;
					Panel_mascota panel_mascota = (Panel_mascota)panel;
					
					nom = panel_mascota.txt_nombre.getText();
					dueño = panel_mascota.txt_dueño.getText();
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar esta mascota: " + nom  + " De cliente :" + dueño, "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            
                                            if(res==JOptionPane.YES_OPTION){
                                                new MascotaDAO().eliminarMascota(nom, dueño);
                                            }
                                        panel_mascota.borrarCampos();
				}
                                
                                if(panel instanceof Panel_cita){
                                    	String nom;
					Panel_cita panel_cita = (Panel_cita)panel;
					
					nom = panel_cita.txt_nombre.getText();
				
				
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar la cita de : " + nom, "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            
                                            if(res==JOptionPane.YES_OPTION){
                                                new CitaDAO().eliminarCita(nom);
                                            }
                                        panel_cita.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_farmaco){
                                    	String nom,pres;
					Panel_farmaco panel_farmaco = (Panel_farmaco)panel;
					
					nom = panel_farmaco.txt_nombre.getText();
					pres= panel_farmaco.ch_presentacion.getSelectedItem();

				
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el farmaco : " + nom  + " con presentación:" + pres, "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            
                                            if(res==JOptionPane.YES_OPTION){
                                                new FarmacoDAO().eliminarFarmaco(nom, pres);
                                            }
                                        panel_farmaco.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_medico){
                                    	String nom,apell,medico;
					Panel_medico panel_medico = (Panel_medico)panel;
					
					nom = panel_medico.txt_nombre.getText();
                                        apell = panel_medico.txt_apellido.getText();
                                        
                                        medico = nom + " " + apell;
					int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar al medico : " + medico  + " de la base de datos", "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                                            
                                            if(res==JOptionPane.YES_OPTION){
                                                new MedicoDAO().eliminarMedico(nom, apell);
                                            }
                                        
                                        panel_medico.borrarCampos();
                                }
                                
                                if(panel instanceof Panel_DatosMedico){
                                    Panel_DatosMedico panel_datosMedico = (Panel_DatosMedico)panel;
                                    panel_datosMedico.eliminarOpcion();
                                    
                                }
                                
			}//action performer
        });
        
    }
}
