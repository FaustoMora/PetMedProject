/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sjronqui
 */
public class Panel_cita extends JPanel{
    JButton btn_guardar;
    JButton btn_cancelar;
    JButton btn_modificar;
    JTextField txt_nombre;
    JDateChooser txt_fecha;
    DefaultTableModel dtm;
    JTable data;
    Choice listaHoras;
    
    
    public Panel_cita(int m){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        this.setLayout(layout);
        JLabel lbl_nombre = new JLabel("Cliente:");
        JLabel lbl_fecha = new JLabel("Fecha de cita:");
        JLabel lbl_hora = new JLabel("Hora:");
        JLabel lbl_medico = new JLabel("Médico:");
        
        
        txt_fecha = new JDateChooser();
        txt_nombre = new JTextField(20);
        txt_nombre.setEditable(false);
               
        
        this.listaHoras=new Choice();
        this.crearChoice();
                
        /*JTextField txt_medico = new JTextField(20);
        txt_medico.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });*/
        JTextField search = new JTextField(40);
        JButton searchButton = new JButton("Buscar");
        
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(search,BorderLayout.CENTER);
        searchPanel.add(searchButton,BorderLayout.EAST);        
        searchPanel.setBorder(new EmptyBorder(8,8,8,8));
        
        String[] columnNames = {"Médicos"};
        dtm = new DefaultTableModel(null, columnNames){
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };
        data = new JTable(dtm);
        JScrollPane panel1= new JScrollPane(data);
        panel1.setPreferredSize(new Dimension(200,80));
        //panel1.setBorder(new TitledBorder("Medicos"));
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_modificar=new JButton("Modificar");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        
        
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridwidth=1;
        this.add(lbl_nombre,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_nombre,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth=1;
//        this.add(lbl_medico,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        //this.add(txt_medico,gbc);
//        this.add(searchPanel);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
//        this.add(panel1,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth=1;
        this.add(lbl_fecha,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_fecha,gbc);  
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth=1;
        this.add(lbl_hora,gbc);
        
        gbc.gridx =1;
        gbc.gridy = 4;
        gbc.fill=GridBagConstraints.NONE;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(listaHoras,gbc);       
        
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        pnl_boton.add(btn_cancelar);
        if(m==1){   pnl_boton.add(btn_modificar);   }
        else {  pnl_boton.add(btn_guardar); }
        this.add(pnl_boton,gbc);
        
        this.setPreferredSize(new Dimension(650,300));
    }
    
    public void crearChoice(){
        this.listaHoras.add("08:00");this.listaHoras.add("08:30");this.listaHoras.add("09:00");this.listaHoras.add("09:30");
        this.listaHoras.add("10:00");this.listaHoras.add("10:30");this.listaHoras.add("11:00");this.listaHoras.add("11:30");
        this.listaHoras.add("12:00");this.listaHoras.add("12:30");this.listaHoras.add("13:00");this.listaHoras.add("13:30");
        this.listaHoras.add("14:00");this.listaHoras.add("14:30");this.listaHoras.add("15:00");this.listaHoras.add("15:30");
        this.listaHoras.add("16:00");this.listaHoras.add("16:30");
    }
}
