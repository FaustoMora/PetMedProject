/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ivan
 */
public class Client extends PanelBasic{
    private Panel_cliente client_panel;
    
    
    public Client(){
        super();
        setLayout(new BorderLayout());
        client_panel= new Panel_cliente();
        init();
        JPanel panelButtons= new JPanel(new GridLayout(1,3));
        JPanel bar= new JPanel(new GridLayout(2,1));
        bar.add(searchPanel);
        JPanel temp = new JPanel(new BorderLayout());
        temp.add(panelButtons,BorderLayout.EAST);
        bar.add(temp);
        add(bar,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
        
        
    }

    
    @Override
    protected void init() {
        
        popUpWindow.add(client_panel);
        columnNames=new String[5];
        columnNames[0]="Fecha de registro";
        columnNames[1]="Nombre";
        columnNames[2]="Apellido";
        columnNames[3]="Direccion";
        columnNames[4]="Telefono";   
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        DefaultTableModel dtm = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        
        
    }

    @Override
    public void setLiteners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
