/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
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
import com.petmed.DAO.CargaConsultaDAO;
import com.petmed.DAO.TratamientoDAO;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.ListModel;
import javax.swing.*;
import com.petmed.DAO.*;
import com.petmed.models.DataConexion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sjronqui
 */
public class Panel_consulta extends JPanel{
    JList lst_sintomas;
    //ArrayList<String> sintomas = new ArrayList<>();
    DefaultListModel sintomas = new DefaultListModel();
    JTextField txt_cliente;
    JTextField txt_mascota;
    JTextField txt_medico;
    JTextField txt_peso;
    JTextField txt_temperatura;
    JTextField txt_motivo;
    JLabel lbl_tratamiento;
    JTextArea txt_diagnostico;
    JButton btn_buscar_trat;
    JButton btn_cancelar;
    JButton btn_guardar;
                
    public Panel_consulta(){
        GridBagLayout layout= new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(layout);
        gbc.insets=new Insets(0,0,5,5);
        
        JPanel pnl_fisiologia= new JPanel(new GridLayout(1,4,5,0));
        pnl_fisiologia.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK),"Datos Fisiológicos:"));
        pnl_fisiologia.setOpaque(false);
        
        

        cargarSintomas();
        lst_sintomas = new JList(sintomas);
        lst_sintomas.setLayoutOrientation(JList.VERTICAL_WRAP);
        lst_sintomas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lst_sintomas.setVisibleRowCount(3);
        lst_sintomas.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK),"Síntomas:"));
   
        JLabel lbl_cliente = new JLabel("Cliente:");
        JLabel lbl_mascota = new JLabel("Mascota:");
        JLabel lbl_doctor = new JLabel("Doctor:");
        JLabel lbl_fecha = new JLabel("Fecha de consulta:");
        JLabel lbl_hora = new JLabel("Hora:");
        JLabel lbl_peso = new JLabel("Peso(Kg):");
        JLabel lbl_temperatura= new JLabel("Temperatura(Cº):");
        JLabel lbl_motivo = new JLabel("Motivo:");
        JLabel lbl_diagnostico = new JLabel("Diagnóstico:");
        lbl_tratamiento = new JLabel("TRATAMIENTO");
               
        Calendar calendario = new GregorianCalendar();
        
        JLabel txt_fecha = new JLabel(""+calendario.get(Calendar.DAY_OF_MONTH)+"/"+calendario.get(Calendar.MONTH)+"/"+calendario.get(Calendar.YEAR));
        JLabel lbl_current_hora = new JLabel(""+calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE));
        

        this.txt_cliente = new JTextField();
        this.txt_mascota = new JTextField();
        this.txt_peso = new JTextField();
        this.txt_temperatura = new JTextField();
        this.txt_motivo = new JTextField();
        this.txt_medico = new JTextField();
        txt_diagnostico = new JTextArea(3,8);        
        lbl_tratamiento.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        lbl_tratamiento.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_tratamiento.setFont(lbl_tratamiento.getFont ().deriveFont (16.0f));
                        
        btn_cancelar = new JButton("Cancelar");
        btn_guardar = new JButton("Guardar");
        btn_buscar_trat = new JButton("Tratemiento");
        JPanel pnl_boton= new JPanel(new FlowLayout());
        pnl_boton.setOpaque(false);
        
        
        this.btn_buscar_trat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null,"Ingrese el tratemiento requerido:");
                
                if((new TratamientoDAO().buscarTratamiento(input)>0)){
                    Panel_consulta.this.lbl_tratamiento.setText(input);
                }else{
                    JOptionPane.showMessageDialog(null, "Tratamiento no encontrado");
                }
            }
       });
        
       this.btn_cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Panel_consulta.this.borrarCampos();
            }
        });
       
       this.btn_guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{ 
                   Panel_consulta.this.guardarButton();
                   Panel_consulta.this.borrarCampos();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        

        ///////////////////////
        gbc.anchor=GridBagConstraints.WEST;
        gbc.gridwidth=1;
        this.add(lbl_cliente,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_cliente,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_mascota,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_mascota,gbc);
        
        gbc.gridwidth=1;
        this.add(lbl_doctor,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        this.add(txt_medico,gbc);
        
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
        this.add(lbl_current_hora,gbc);
                
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
        
        gbc.gridheight=1;
        gbc.gridwidth=1;
        this.add(lbl_diagnostico,gbc);
        
        gbc.gridwidth=GridBagConstraints.REMAINDER;  
        this.add(txt_diagnostico,gbc);
        
        gbc.gridwidth=0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(lbl_tratamiento,gbc);
         
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=3;
        txt_diagnostico.setLineWrap(true);
        txt_diagnostico.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        this.add(btn_buscar_trat,gbc);
        
              
        gbc.anchor=GridBagConstraints.PAGE_END;
        gbc.gridx=1;
        pnl_boton.add(btn_cancelar);
        pnl_boton.add(btn_guardar);
        this.add(pnl_boton,gbc);
        this.setPreferredSize(new Dimension(650,350));
        
        
        
        
    }

    
    
    public void cargarSintomas(){
        sintomas.clear();
        try {       
            ResultSet resul_sintomas = (new CargaConsultaDAO()).cargarSintoma();

                while(resul_sintomas.next()){
                    sintomas.addElement(resul_sintomas.getString(1));              
                }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void borrarCampos(){
        this.txt_cliente.setText("");
        this.txt_mascota.setText("");
        this.txt_diagnostico.setText("");
        this.txt_motivo.setText("");
        this.txt_peso.setText("");
        this.txt_temperatura.setText("");
        this.lbl_tratamiento.setText("TRATAMIENTO");
        this.lst_sintomas.clearSelection();
        this.txt_medico.setText("");
        
    }
    
    
    public void guardarButton() throws ParseException{
        
        //todas las variables 
        String cliente = this.txt_cliente.getText();
        String mascota = this.txt_mascota.getText();
        String doctor = this.txt_medico.getText();
        String motivo = this.txt_motivo.getText();
        String peso = this.txt_peso.getText();
        String temperatura = this.txt_temperatura.getText();
        String diagnostico = this.txt_diagnostico.getText();
        String tratamiento = this.lbl_tratamiento.getText();
        
        //hora
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        java.sql.Date currentTime = new java.sql.Date(sdf.parse(date).getTime());
        
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(new Date());
        java.sql.Time reg_time = new java.sql.Time(calendar.get(Calendar.HOUR_OF_DAY));
        String hora ="" + reg_time;
        
        //lista de id_sintomas
        ArrayList<String> id_sint = this.idSintomas((ArrayList<String>)this.lst_sintomas.getSelectedValuesList()) ;
        JOptionPane.showMessageDialog(null, id_sint);
        
        //obteniendo id requeridos
        int id_cliente = new ClienteDAO().buscarCliente(cliente);
        int id_mascota = new MascotaDAO().buscarMascota(mascota, id_cliente);
        int id_doctor = new MedicoDAO().buscarMedico(doctor);
        
        int id_tratamiento = new TratamientoDAO().buscarTratamiento(tratamiento);
        
        int valor_consul = new ConsultaDAO().ingresarConsulta(currentTime,hora, motivo, diagnostico, id_doctor, id_tratamiento,id_mascota);
        
        if(valor_consul>0){

            int id_consulta = new ConsultaDAO().buscarConsulta(currentTime, id_doctor, id_mascota);
            
            int valor_fisiologia = new FisiologiaDAO().insertarFisiologia(temperatura, peso, new java.util.Date(), id_mascota);
            if(!(valor_fisiologia>0)){JOptionPane.showMessageDialog(null, "Error al ingresar datos fisiologia este dia");}
            
            int valor_consulta_sintoma = new ConsultaSintomaDAO().ingresarConsultaSintoma(id_consulta, id_sint);
            if(valor_consulta_sintoma>0){
                JOptionPane.showMessageDialog(null, "Consulta ingresada exitosamente");
            }else{
                JOptionPane.showMessageDialog(null, "Error al ingresar consulta"); 
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ingresar la consulta");            
        }
    
    }
    
    public ArrayList<String> idSintomas(ArrayList<String> sint_select){
        
        ArrayList<String> idsintomas = new ArrayList<String>();;
        try {
            for(int i=0; i< sint_select.size();i++){
                int aux = new SintomaDAO().buscarSintoma(sint_select.get(i).toString());
                idsintomas.add(String.valueOf(aux));
            }
            return idsintomas;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
}
