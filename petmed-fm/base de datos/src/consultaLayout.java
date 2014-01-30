import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class consultaLayout extends JFrame{
	
	public JLabel fechaLabel;
	public JLabel horaLabel;
	public JLabel nombreClienteLabel;
	public JLabel nombreMascotaLabel;
	public JLabel MotivoLabel;
	public JLabel DescripcionLabel;
	public JLabel TratamientoLabel;
	
	public JLabel fechaShowLabel;
	public JTextField nombreClienteText;
	public JTextField nombreMascotaText;
	public JTextField MotivoLabelText;
	public JTextArea DescripcionText;
	public JTextField TratamientoLabelText;
	
	public JButton guardar_button;
	public Date fecha;

	
	public consultaLayout() {
		// TODO Auto-generated constructor stub
		super(" PetMed Consulta");
		this.getContentPane();
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		
		fecha = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		SimpleDateFormat dh = new SimpleDateFormat("hh:mm:ss");
		String s = df.format(fecha);
		String sh = dh.format(fecha);
		
		fechaLabel = new JLabel("Fecha de Registro:");
		nombreClienteLabel= new JLabel("Dueño:");
		nombreMascotaLabel= new JLabel("Nombre Mascota:");
		MotivoLabel= new JLabel("Motivo:");
		DescripcionLabel= new JLabel("Descripcion:");
		this.TratamientoLabel = new JLabel("Tratamiento:");
		
		fechaShowLabel= new JLabel(" " + s);
		this.horaLabel = new JLabel("HORA: " + sh);
		
		nombreClienteText= new JTextField("Ingrese datos aqui");
		this.nombreMascotaText= new JTextField("Ingrese datos aqui");
		this.MotivoLabelText= new JTextField("Ingrese datos aqui");
		this.DescripcionText=new JTextArea(10,10);
		this.TratamientoLabelText = new JTextField("Ingrese datos aqui");
		
		guardar_button= new JButton("Guardar");
		
		JPanel panelout = new JPanel();
		panelout.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,6));
		
		JPanel c = new JPanel();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		c.add(this.DescripcionLabel);
		c.add(this.DescripcionText);
		c.setAlignmentX(LEFT_ALIGNMENT);
		
		JPanel c2 = new JPanel();
		c2.setLayout(new FlowLayout(FlowLayout.CENTER));
		c2.add(this.TratamientoLabel);
		c2.add(this.TratamientoLabelText);
		
		JPanel k = new JPanel();
		k.setLayout(new BoxLayout(k,BoxLayout.Y_AXIS));
		k.add(c2);
		k.add(this.guardar_button);

		panel.add(horaLabel);
		panel.add(new Container());
		panel.add(this.fechaLabel);
		panel.add(this.fechaShowLabel);
		panel.add(this.nombreClienteLabel);
		panel.add(this.nombreClienteText);
		panel.add(this.nombreMascotaLabel);
		panel.add(this.nombreMascotaText);
		panel.add(this.MotivoLabel);
		panel.add(this.MotivoLabelText);	

		//panelout.add(horaLabel);	
		panelout.add(panel,BorderLayout.NORTH);
		panelout.add(c,BorderLayout.CENTER);
		panelout.add(k,BorderLayout.SOUTH);
		//panelout.add(this.guardar_button);
		panelout.setAlignmentX(CENTER_ALIGNMENT);

		
		this.add(panelout);
	}
	
	
	public static void main(String args[]){
		new consultaLayout();
	}
}