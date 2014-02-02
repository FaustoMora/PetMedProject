/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rbalda
 */
public class CreateCitas extends JPanel {	
	public JLabel fechaemisionLabel;
	public JLabel fechadeturnoLabel;
	public JLabel nombredoctorLabel;
	public JLabel nombredueñoLabel;
	public JLabel nombremascotaLabel;
	public JLabel horaActualLabel;
	
	public JLabel fechaShowLabel;
	public Choice diadeturno;
	public Choice mesdeturno;
	public JTextField nombredoctorText;
	public JTextField nombredueñoText;
	public JTextField nombremascotaText;
	
	public JButton guardar_button;
	public Date fecha;

	
	public CreateCitas() {
		// TODO Auto-generated constructor stub		
		this.setSize(450,280);		
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));		
		
		fecha = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		SimpleDateFormat dh = new SimpleDateFormat("hh:mm:ss");
		String s = df.format(fecha);
		String sh = dh.format(fecha);
				
		
		fechaemisionLabel = new JLabel("Fecha de Emision");
		fechadeturnoLabel= new JLabel("Fecha de Turno:");
		nombredoctorLabel= new JLabel("Doctor asignado:");
		nombredueñoLabel= new JLabel("Nombre del Propietario:");
		nombremascotaLabel= new JLabel("Nombre de Mascota:");
		this.horaActualLabel = new JLabel(" Hora: " + sh);
		
		fechaShowLabel= new JLabel(" " + s);
		nombredoctorText= new JTextField("Ingrese datos aqui");
		nombredueñoText= new JTextField("Ingrese datos aqui");
		nombremascotaText= new JTextField("Ingrese datos aqui");
		
		this.diadeturno = new Choice();
		this.mesdeturno = new Choice();
		this.crearChoice();
		
		guardar_button= new JButton("Guardar");
		

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		
		JPanel listFecha = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		listFecha.add(diadeturno);
		listFecha.add(mesdeturno);
		
		panel.add(this.fechaemisionLabel);
		panel.add(this.fechaShowLabel);
		panel.add(this.nombredueñoLabel);
		panel.add(this.nombredueñoText);
		panel.add(this.nombremascotaLabel);
		panel.add(this.nombremascotaText);
		panel.add(this.nombredoctorLabel);
		panel.add(this.nombredoctorText);
		panel.add(this.fechadeturnoLabel);
		panel.add(listFecha);

		
		
		this.add(this.horaActualLabel);
		this.add(panel);
		this.add(this.guardar_button);
                
		
	}
	
	
	
	
	private void crearChoice(){
		this.diadeturno.add("1");this.diadeturno.add("2");this.diadeturno.add("3");this.diadeturno.add("4");this.diadeturno.add("5");this.diadeturno.add("6");this.diadeturno.add("7");
		this.diadeturno.add("8");this.diadeturno.add("9");this.diadeturno.add("10");this.diadeturno.add("11");this.diadeturno.add("12");this.diadeturno.add("13");this.diadeturno.add("14");
		this.diadeturno.add("15");this.diadeturno.add("16");this.diadeturno.add("17");this.diadeturno.add("18");this.diadeturno.add("19");this.diadeturno.add("20");this.diadeturno.add("21");
		this.diadeturno.add("22");this.diadeturno.add("23");this.diadeturno.add("24");this.diadeturno.add("25");this.diadeturno.add("26");this.diadeturno.add("27");this.diadeturno.add("28");
		this.diadeturno.add("29");this.diadeturno.add("30");this.diadeturno.add("31");
		
		this.mesdeturno.add("Enero");this.mesdeturno.add("Febrero");this.mesdeturno.add("Marzo");
		this.mesdeturno.add("Abril");this.mesdeturno.add("Mayo");this.mesdeturno.add("Junio");
		this.mesdeturno.add("Julio");this.mesdeturno.add("Agosto");this.mesdeturno.add("Septiembre");
		this.mesdeturno.add("Octubre");this.mesdeturno.add("Noviembre");this.mesdeturno.add("Diciembre");
	
	}

}
