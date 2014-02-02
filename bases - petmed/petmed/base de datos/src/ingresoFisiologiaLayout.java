import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class ingresoFisiologiaLayout extends JFrame{
	
	public JLabel fechaLabel;
	public JLabel pesoPetLabel;
//	public JLabel tama�oPetLabel;

	
	public JLabel fechaShowLabel;
	public JTextField pesoPetText;
//	public JTextField tama�oPetText;

	
	public JButton guardar_button;
	public Date fecha;
	
	public ingresoFisiologiaLayout() {
		// TODO Auto-generated constructor stub
		super("PetMed Fisiologia");
		this.setSize(450, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
		
		
		this.fechaLabel = new JLabel("Fecha:");
		this.pesoPetLabel = new JLabel("Peso:");
//		this.tama�oPetLabel = new JLabel("Tama�o:");
		
		fecha = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		String s = df.format(fecha);
		
		this.fechaShowLabel = new JLabel(" " + s);
		this.pesoPetText = new JTextField();
		this.pesoPetLabel.setSize(25, 25);
//		this.tama�oPetText = new JTextField();
//		this.tama�oPetText.setSize(25,25);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		panel.add(fechaLabel);
		panel.add(fechaShowLabel);
		panel.add(pesoPetLabel);
		panel.add(pesoPetText);
//		panel.add(tama�oPetLabel);
//		panel.add(tama�oPetText);
		
		this.guardar_button = new JButton("Guardar");
		this.guardar_button.setSize(25, 25);
		
		this.add(panel);
		this.add(guardar_button);
		
	}
	
	public static void main(String args[]){
		new ingresoFisiologiaLayout();
	}
}
