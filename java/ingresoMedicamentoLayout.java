import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class ingresoMedicamentoLayout extends JFrame{
	
	DefaultTableModel tabla;
	final JTable dtm;
	JButton guardar_button;
	
	public ingresoMedicamentoLayout() {
		// TODO Auto-generated constructor stub
		super("PetMed Medicamentos");
		this.setSize(400, 220);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.getContentPane();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setResizable(false);
	
	this.guardar_button = new JButton("Guardar");
	this.guardar_button.setSize(50, 50);
	String columNames[] = {"Nombre","Concentracion","Presentacion"};
	
	tabla = new DefaultTableModel(columNames,10);
	
	dtm = new JTable(tabla);
	
	dtm.setPreferredScrollableViewportSize(new Dimension(300,100));
	JScrollPane scroll = new JScrollPane(dtm); 
	scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	
	TableColumn presentacion = dtm.getColumnModel().getColumn(2);
	JComboBox comboBox = new JComboBox();
	comboBox.addItem("Vacuna");
	comboBox.addItem("Emulsion");
	comboBox.addItem("Cutanea");
	presentacion.setCellEditor(new DefaultCellEditor(comboBox));

	
	JPanel panel = new JPanel();
	panel.setLayout(new FlowLayout(FlowLayout.CENTER));
	panel.add(scroll);
	
	
	
	
	
	
	this.add(panel);
	this.add(this.guardar_button);
	}
	
	public static void main(String args[]){
		  new ingresoMedicamentoLayout();
	}
}
