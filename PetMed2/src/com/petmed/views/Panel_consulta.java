/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author sjronqui
 */
public class Panel_consulta extends JPanel{
    JButton btn_cancelar;
    JButton btn_guardar;
    JButton btn_modificar;
    JButton btn_tratamiento;
    JTextField txt_diagnostico;
    JTextArea txt_descripcion;
    JTextField txt_temperatura;
    JTextField txt_peso;
    JTextField txt_motivo;
    JList lst_sintomas;
    JDateChooser txt_fecha;
    JLabel txt_hora;
    
    
    
    public Panel_consulta(int m){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(layout);
        gbc.insets=new Insets(0,0,5,5);
        
        JPanel pnl_fisiologia= new JPanel(new GridLayout(1,4,5,0));
        pnl_fisiologia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK),"Datos Fisiológicos:"));
        pnl_fisiologia.setOpaque(false);
        
        
        String[] sintomas={"Fiebre","Pigmentación de piel","Perdida de peso","Hemorragia nasal",
                            "Halitosis","Apatía","Erlichiosis","Sarna demodécica"};
        lst_sintomas = new JList(sintomas);
        lst_sintomas.setLayoutOrientation(JList.VERTICAL_WRAP);
        lst_sintomas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lst_sintomas.setVisibleRowCount(3);
        lst_sintomas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK),"Síntomas:"));
        
        
        JLabel lbl_fecha = new JLabel("Fecha de consulta:");
        JLabel lbl_hora = new JLabel("Hora:");
        JLabel lbl_peso = new JLabel("Peso:");
        JLabel lbl_temperatura = new JLabel("Temperatura:");
        JLabel lbl_motivo = new JLabel("Motivo:");
        JLabel lbl_descripcion = new JLabel("Descripción:");
        JLabel lbl_diagnostico = new JLabel("Diagnóstico:");
        JLabel lbl_tratamiento = new JLabel("Tratamiento:");
               
        Calendar calendario = new GregorianCalendar();
        
        txt_fecha = new JDateChooser();
        txt_fecha.setDate(calendario.getTime());
        txt_fecha.setEnabled(false);
        
        txt_hora = new JLabel(""+calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE));
        
        txt_motivo = new JTextField(15);
        txt_motivo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        txt_peso = new JTextField(5);
        txt_peso.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[0-9]+(\\.[0-9]+)*")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        txt_temperatura = new JTextField(3);
        txt_temperatura.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[0-9]+(\\.[0-9]+){0,1}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
        
        txt_descripcion = new JTextArea(3,10);        
        txt_diagnostico = new JTextField(5);
        txt_diagnostico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(((JTextField)e.getSource()).getText().matches("[a-zA-Z]{3,}")){
                     JOptionPane.showMessageDialog(null,"Válido");
                    }else{
                    JOptionPane.showMessageDialog(null,"Dato no válido");
                }
            }
        });
               
        btn_tratamiento = new JButton(new ImageIcon("/home/sjronqui/PetMedProject/Images/tratamiento.png"));
        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_modificar = new JButton("Modificar");
        
        JPanel pnl_boton= new JPanel(new FlowLayout());
        pnl_boton.setOpaque(false);
        
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_fecha,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_fecha,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_hora,gbc);
        
//        gbc.fill=GridBagConstraints.NONE;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_hora,gbc);
                
//        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=1;
        this.add(lbl_motivo,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_motivo,gbc);
        
        gbc.anchor= GridBagConstraints.CENTER;
//        gbc.fill=GridBagConstraints.NONE;
        pnl_fisiologia.add(lbl_peso);
        pnl_fisiologia.add(txt_peso);
        pnl_fisiologia.add(lbl_temperatura);
        pnl_fisiologia.add(txt_temperatura);
        this.add(pnl_fisiologia,gbc);
        

        gbc.gridwidth=GridBagConstraints.REMAINDER;  
        this.add(lst_sintomas,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_descripcion,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=3;
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        this.add(txt_descripcion,gbc);
        
        gbc.gridheight=1;
        gbc.gridwidth=1;
        this.add(lbl_diagnostico,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_diagnostico,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_tratamiento,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.anchor=GridBagConstraints.WEST;
        gbc.fill=GridBagConstraints.NONE;
        this.add(btn_tratamiento,gbc);
        
        gbc.anchor=GridBagConstraints.PAGE_END;
        gbc.gridx=1;
        pnl_boton.add(btn_cancelar);
        if(m==1){ pnl_boton.add(btn_modificar);}
        else {pnl_boton.add(btn_guardar);}
        this.add(pnl_boton,gbc);
        this.setPreferredSize(new Dimension(650,350));
    }
    
}
