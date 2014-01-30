import java.awt.*;
import java.text.DateFormat;
import java.util.*;

import javax.swing.*;

public class ingresoMascotaLayout extends JFrame{
	
	public JLabel fechaLabel;
	public JLabel sexoPetLabel;
	public JLabel nombrePetLabel;
	public JLabel especiePetLabel;
	public JLabel razaPetLabel;
	public JLabel fechaNacPetLabel;

	
	public JLabel fechaShowLabel;
	public JRadioButton sexoRButtonM;
	public JRadioButton sexoRButtonF;
	public JTextField nombrePetText;
	public JTextField especiePetText;
	public JTextField razaPetText;
	public Choice diaNacPet;
	public Choice mesNacPet;
	public Choice yearNacPet;
	
	public JButton guardar_button;
	public JButton ingreso_fisiologia;
	public Date fecha;
	

	
	public ingresoMascotaLayout() {
		// TODO Auto-generated constructor stub
		super(" PetMed Mascota ");
		this.getContentPane();
		this.setSize(600,320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
		
		fecha = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String s = df.format(fecha);
		
		
		fechaLabel = new JLabel("Fecha de Registro:");
		sexoPetLabel= new JLabel("Sexo:");
		nombrePetLabel= new JLabel("Nombre:");
		especiePetLabel= new JLabel("Especie:");
		razaPetLabel= new JLabel("Raza:");
		fechaNacPetLabel = new JLabel("Fecha de Nacimiento:");
		
		fechaShowLabel= new JLabel("" + s);
		sexoRButtonM= new JRadioButton("Masculino");
		sexoRButtonF= new JRadioButton("Femenino");
		nombrePetText= new JTextField("Ingrese datos aqui");
		especiePetText= new JTextField("Ingrese datos aqui");
		razaPetText= new JTextField("Ingrese datos aqui");
		this.diaNacPet = new Choice();
		this.yearNacPet = new Choice();
		this.mesNacPet = new Choice();
		
		this.crearChoice();
		
		
		guardar_button= new JButton("Guardar");
		this.ingreso_fisiologia = new JButton("Ingresar Fisiologia");
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		
		JPanel c = new JPanel();
		ButtonGroup botones = new ButtonGroup();
		botones.add(sexoRButtonF);
		botones.add(sexoRButtonM);
		c.setVisible(true);
		c.add(this.sexoRButtonM);
		c.add(this.sexoRButtonF);
		
		JPanel listaFecha = new JPanel();
		listaFecha.setLayout(new GridLayout(0,3));
		listaFecha.add(diaNacPet);
		listaFecha.add(mesNacPet);
		listaFecha.add(yearNacPet);
		
		panel.add(this.fechaLabel);
		panel.add(this.fechaShowLabel);
		panel.add(this.sexoPetLabel);
		panel.add(c);
		panel.add(this.nombrePetLabel);
		panel.add(this.nombrePetText);
		panel.add(this.especiePetLabel);
		panel.add(this.especiePetText);
		panel.add(this.razaPetLabel);
		panel.add(this.razaPetText);	
		panel.add(this.fechaNacPetLabel);
		panel.add(listaFecha);
		

		
		
		this.add(panel);
		this.add(this.guardar_button);
		this.add(new JTextField());
		this.add(ingreso_fisiologia);
	}
	
	
	public static void main(String args[]){
		new ingresoMascotaLayout();
	}
	
	public void crearChoice(){
		this.diaNacPet.add("1");this.diaNacPet.add("2");this.diaNacPet.add("3");this.diaNacPet.add("4");this.diaNacPet.add("5");this.diaNacPet.add("6");this.diaNacPet.add("7");
		this.diaNacPet.add("8");this.diaNacPet.add("9");this.diaNacPet.add("10");this.diaNacPet.add("11");this.diaNacPet.add("12");this.diaNacPet.add("13");this.diaNacPet.add("14");
		this.diaNacPet.add("15");this.diaNacPet.add("16");this.diaNacPet.add("17");this.diaNacPet.add("18");this.diaNacPet.add("19");this.diaNacPet.add("20");this.diaNacPet.add("21");
		this.diaNacPet.add("22");this.diaNacPet.add("23");this.diaNacPet.add("24");this.diaNacPet.add("25");this.diaNacPet.add("26");this.diaNacPet.add("27");this.diaNacPet.add("28");
		this.diaNacPet.add("29");this.diaNacPet.add("30");this.diaNacPet.add("31");
		
		this.mesNacPet.add("Enero");this.mesNacPet.add("Febrero");this.mesNacPet.add("Marzo");
		this.mesNacPet.add("Abril");this.mesNacPet.add("Mayo");this.mesNacPet.add("Junio");
		this.mesNacPet.add("Julio");this.mesNacPet.add("Agosto");this.mesNacPet.add("Septiembre");
		this.mesNacPet.add("Octubre");this.mesNacPet.add("Noviembre");this.mesNacPet.add("Diciembre");
		
		this.yearNacPet.add("2013");this.yearNacPet.add("2012");this.yearNacPet.add("2011");
		this.yearNacPet.add("2010");this.yearNacPet.add("2009");this.yearNacPet.add("2008");
		this.yearNacPet.add("2007");this.yearNacPet.add("2006");this.yearNacPet.add("2005");
		this.yearNacPet.add("2004");this.yearNacPet.add("2003");this.yearNacPet.add("2002");
	}
}