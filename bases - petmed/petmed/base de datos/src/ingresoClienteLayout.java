import java.awt.*;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.*;

public class ingresoClienteLayout extends JFrame{
	
	public JLabel fechaLabel;
	public JLabel CIDLabel;
	public JLabel nombreClienteLabel;
	public JLabel apellidoClienteLabel;
	public JLabel direccionClienteLabel;
	public JLabel tlfClienteLabel;
	
	public JLabel fechaShowLabel;
	public JTextField CIDText;
	public JTextField nombreClienteText;
	public JTextField apellidoClienteText;
	public JTextField direccionClienteText;
	public JTextField tlfClienteText;
	
	public JButton guardar_button;
	public Date fecha;

	
	public ingresoClienteLayout() {
		// TODO Auto-generated constructor stub
		super(" PetMed Cliente ");
		this.getContentPane();
		this.setSize(450,250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
		
		fecha = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String s = df.format(fecha);
		
		fechaLabel = new JLabel("Fecha de Registro:");
		CIDLabel= new JLabel("Cedula de Identidad:");
		nombreClienteLabel= new JLabel("Nombre:");
		apellidoClienteLabel= new JLabel("Apellido:");
		direccionClienteLabel= new JLabel("Direccion:");
		tlfClienteLabel = new JLabel("Telefono:");
		
		fechaShowLabel= new JLabel(" " + s);
		CIDText= new JTextField("Ingrese datos aqui");
		nombreClienteText= new JTextField("Ingrese datos aqui");
		apellidoClienteText= new JTextField("Ingrese datos aqui");
		direccionClienteText= new JTextField("Ingrese datos aqui");
		this.tlfClienteText = new JTextField("Ingrese datos aqui");
		
		guardar_button= new JButton("Guardar");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		
		panel.add(this.fechaLabel);
		panel.add(this.fechaShowLabel);
		panel.add(this.CIDLabel);
		panel.add(this.CIDText);
		panel.add(this.nombreClienteLabel);
		panel.add(this.nombreClienteText);
		panel.add(this.apellidoClienteLabel);
		panel.add(this.apellidoClienteText);
		panel.add(this.direccionClienteLabel);
		panel.add(this.direccionClienteText);	
		panel.add(this.tlfClienteLabel);
		panel.add(this.tlfClienteText);

		
		
		this.add(panel);
		this.add(this.guardar_button);
	}
	
	
	public static void main(String args[]){
		new ingresoClienteLayout();
	}
}
