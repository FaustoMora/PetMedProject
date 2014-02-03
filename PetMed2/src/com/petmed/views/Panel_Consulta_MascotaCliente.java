/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petmed.view;

import com.petmed.models.DataConection;
import com.petmed.models.Validacion;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Administrador
 */
public class Panel_Consulta_MascotaCliente extends JPanel{
        JTextField txt_nombre;
        ResultSetMetaData rsMd;
        DefaultTableModel dftabla;
        JTable table;
        
    public Panel_Consulta_MascotaCliente(){
        
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_nombre= new JLabel("Nombre del Cliente:");
        txt_nombre=new JTextField(15);
        txt_nombre.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( !txt_nombre.getText().isEmpty()){
                    if(Validacion.validacionTexto(txt_nombre.getText())){
                    Panel_Consulta_MascotaCliente.this.cargarTabla(txt_nombre.getText());
                    txt_nombre.setText("");
                    }
                }else{
                    Panel_Consulta_MascotaCliente.this.cargarTabla();
                }
            }
            
        });
        
        this.table = new JTable();
        
        this.cargarTabla();
        
        table.setPreferredScrollableViewportSize(new Dimension(550,200));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
  
        JPanel pnl_entrada= new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl_entrada.add(lbl_nombre);
        pnl_entrada.add(txt_nombre);
        
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.anchor=GridBagConstraints.NORTH;
        
        gbc.gridwidth= 0;
        gbc.weightx=GridBagConstraints.NORTH;
        this.add(pnl_entrada,gbc);
        
        gbc.gridwidth= 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        this.add(panel,gbc);
    }
    
    public void cargarTabla(){
        
        try{
        String seleccion = "{call select_cliente_mascota()}";
        ResultSet resul = DataConection.ejecutarProcedureSelect(seleccion);
        this.rsMd = resul.getMetaData();
        
        int numCol = this.rsMd.getColumnCount();
        this.dftabla = new DefaultTableModel();
        this.table.setModel(dftabla);
        
        for(int i=1; i <= numCol;i++){
            dftabla.addColumn(rsMd.getColumnLabel(i));
        }
        
        while(resul.next()){
            Object[] fila = new Object[numCol];
            
            for(int i=0;i<numCol;i++){
                fila[i] = resul.getObject(i+1);
            }
            dftabla.addRow(fila);
            
        }
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void cargarTabla(String cliente){
        try{
            String seleccion = "{call select_mascota_by_cliente('"+ cliente +"')}";
            ResultSet resul = DataConection.ejecutarProcedureSelect(seleccion);
            this.rsMd = resul.getMetaData();

            int numCol = this.rsMd.getColumnCount();
            this.dftabla = new DefaultTableModel();
            this.table.setModel(dftabla);

            for(int i=1; i <= numCol;i++){
                dftabla.addColumn(rsMd.getColumnLabel(i));
            }

            while(resul.next()){
                Object[] fila = new Object[numCol];

                for(int i=0;i<numCol;i++){
                    fila[i] = resul.getObject(i+1);
                }
                dftabla.addRow(fila);

            }       
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
