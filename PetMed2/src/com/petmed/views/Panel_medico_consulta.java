/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;


import com.petmed.models.DataConection;
import com.petmed.models.PetDAO;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sjronqui
 */




public class Panel_medico_consulta extends JPanel{        
        ResultSetMetaData rsMd;
        DefaultTableModel dtm2;
        JTable table;
        
    public Panel_medico_consulta(){
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        String[] columnNames=new String[2];        
        columnNames[0]="Nombre";
        columnNames[1]="Número de Consultas";
        dtm2 = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        this.table = new JTable(dtm2);
        table.setPreferredScrollableViewportSize(new Dimension(550,200));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=1;
        gbc.anchor=GridBagConstraints.NORTH;
        
        gbc.gridwidth= 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        this.add(panel,gbc);
        cargarTabla();
        
    }
    
    public void cargarTabla(){
        String seleccion = "{call count_medico_consulta()}";
        ResultSet rs = DataConection.ejecutarProcedureSelect(seleccion);
  
        while(dtm2.getRowCount()>0) dtm2.removeRow(0);
        try {
            int i=0;
            while(rs.next()){
                dtm2.insertRow(i,new Object[]{rs.getString(1), rs.getInt(2)}); 
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
}
