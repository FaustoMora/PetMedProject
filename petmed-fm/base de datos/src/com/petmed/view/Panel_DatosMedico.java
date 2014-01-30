/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import com.petmed.DAO.ClienteDAO;
import com.petmed.DAO.DatosMedicoDAO;
import com.petmed.DAO.MascotaDAO;
import com.petmed.DAO.SintomaDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Lost Legion
 */
public class Panel_DatosMedico extends JPanel{
    JButton btn_guardar;
	JButton btn_cancelar;
	JTextField txt_trat;
        JTextField txt_sintoma;
	DefaultTableModel table_farmaco;
	Calendar calendario;
        JTable tabla;
	
	
    public Panel_DatosMedico (){
        GridBagLayout layout= new GridBagLayout();
        //GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc_trat = new GridBagConstraints();
        
        this.setLayout(layout);
        
        JLabel lbl_trat = new JLabel("Tratamiento:");
        JLabel lbl_farmaco = new JLabel("Farmaco Recetado:");
        JLabel lbl_sintoma = new JLabel("Ingreso de Sintomas:");

        txt_trat = new JTextField(45);
        txt_sintoma = new JTextField(30);
        
        String columNames[] = {"Nombre","Presentacion"};
        table_farmaco = new DefaultTableModel(columNames,20);
        tabla = new JTable (table_farmaco);
        tabla.setSize(new Dimension(100, 100));
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        TableColumn presentacion = tabla.getColumnModel().getColumn(1);
	JComboBox comboBox = new JComboBox();
	comboBox.addItem("Jarabe");
	comboBox.addItem("Capsula");
	comboBox.addItem("Pildora");
        comboBox.addItem("Gel");
        comboBox.addItem("Vacuna");
	presentacion.setCellEditor(new DefaultCellEditor(comboBox));
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        
        btn_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                            
                            if(Panel_DatosMedico.this.txt_sintoma.getText()!=""){
                               new SintomaDAO().ingresarSintoma(Panel_DatosMedico.this.txt_sintoma.getText());
                               
                               
                            }
                            
                            try{
                            ArrayList<String> array = new ArrayList<>();
                            String tratamiento, farmaco, presen;
                            
                            tratamiento=Panel_DatosMedico.this.txt_trat.getText();
                            
                            for(int i=0;i<Panel_DatosMedico.this.table_farmaco.getRowCount();i++){
                                if(Panel_DatosMedico.this.table_farmaco.getValueAt(i, 0)!=null){
                                    farmaco = (String)Panel_DatosMedico.this.table_farmaco.getValueAt(i, 0);
                                    presen = (String)Panel_DatosMedico.this.table_farmaco.getValueAt(i, 1);
                                    JOptionPane.showMessageDialog(null, tratamiento + " " + farmaco);
                                    
                                    int works = new DatosMedicoDAO().ingresarDatosMedico(tratamiento,farmaco,presen);
                                    if(works!=1){
                                        array.add(farmaco + " " + presen);
                                    }
                                    farmaco="";
                                    presen="";
                                }
                            }
                            
                            if(array.isEmpty()){
                                JOptionPane.showMessageDialog(null, "Ingreso realizado con exito");
                            }else{
                                JOptionPane.showMessageDialog(null,"No se pudo ingresar estos farmacos:" + Panel_DatosMedico.this.printErrorArray(array) + "con este tratamiento:" + tratamiento);
                                JOptionPane.showMessageDialog(null, "Es posible que ya existan en la base o este escrito incorrectamente");
                            }
                            Panel_DatosMedico.this.borrarCampos();
                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
			}
		});
        
        btn_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                                Panel_DatosMedico.this.tabla.setEnabled(false);                                
				Panel_DatosMedico.this.borrarCampos();
			}
		});
        
        txt_sintoma.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int aux = new SintomaDAO().ingresarSintoma(txt_sintoma.getText());
                    if(aux>0){JOptionPane.showMessageDialog(null, "Sintoma ingresado con exito");
                    }else{ JOptionPane.showMessageDialog(null,"Sintoma ya existente");}
                Panel_DatosMedico.this.txt_sintoma.setText("");
            }
        });
        
        gbc_trat.fill= GridBagConstraints.HORIZONTAL;
        gbc_trat.anchor=GridBagConstraints.WEST;
        
        gbc_trat.gridwidth=0;
        this.add(lbl_sintoma,gbc_trat);
        
        gbc_trat.gridwidth = GridBagConstraints.REMAINDER;
        this.add(txt_sintoma,gbc_trat);
        
        gbc_trat.gridwidth=1;
        this.add(lbl_trat,gbc_trat);
        
        gbc_trat.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_trat,gbc_trat);
        
        gbc_trat.gridwidth=1;
        this.add(lbl_farmaco,gbc_trat);
        
        
        gbc_trat.fill = GridBagConstraints.BOTH;
        gbc_trat.weighty = 1;
        this.add(scroll,gbc_trat);

        gbc_trat.gridx=1;
        gbc_trat.gridy=5;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc_trat);
        

        
        this.setPreferredSize(new Dimension(400,200));
    }
    
    public void borrarCampos(){
		this.txt_trat.setText("");
                this.txt_sintoma.setText("");
                this.cleanTabla(table_farmaco);
                Panel_DatosMedico.this.tabla.setEnabled(true);
    }
    
    public void cleanTabla(DefaultTableModel tabla){
        for(int i=0;i<tabla.getRowCount();i++){
            try{
            tabla.setValueAt("", i, 0);
            tabla.setValueAt("", i, 1);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error tabla");
            }
        }

    }
    
    public String printErrorArray(ArrayList array){
        String aux="";
        for(int  i=0;i<array.size();i++){
            aux=aux + " " +array.get(i);
        }
       return aux;
    }

    void modificarOpcion() {
        JOptionPane.showMessageDialog(null, "No soportado para esta caracteristica");
    }

    void eliminarOpcion() {
        String tratamiento = this.txt_trat.getText();
        String sintoma = this.txt_sintoma.getText();
        
        int res = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar aquellos datos:", "",JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if(res==JOptionPane.YES_OPTION){
            int valor = new DatosMedicoDAO().eliminarDatosMedico(tratamiento,sintoma);
            
                if(valor>=1){
                    JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Error en la eliminacion");
                }
             this.borrarCampos();
        }    
                                            
        

    }
    

}
