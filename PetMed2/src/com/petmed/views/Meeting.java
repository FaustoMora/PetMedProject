/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class Meeting extends PanelBasic{
    private Panel_cita panelCita;
    private JTable data2;
    private String columNames2[];
    private LinkedList lst_client = new LinkedList();
    private LinkedList lst_meeting = new LinkedList();
    
    public Meeting(){
        super();
        setLayout(new BorderLayout());
        
        init();
        JPanel panelButtons= new JPanel(new GridLayout(1,3));
        
        JPanel bar= new JPanel(new GridLayout(2,1));
        bar.add(searchPanel);
        JPanel temp = new JPanel(new BorderLayout());
        temp.add(panelButtons,BorderLayout.EAST);
        temp.setSize(new Dimension(20,40));
        bar.add(temp);
        add(bar,BorderLayout.NORTH);
        JPanel innerPane = new JPanel(new GridLayout());
        JScrollPane panel1=new JScrollPane(data);
        JScrollPane panel2=new JScrollPane(data2);
        panel1.setBorder(new TitledBorder("Clientes"));
        panel2.setBorder(new TitledBorder("Citas"));
        innerPane.add(panel1);
        innerPane.add(panel2);
        add(innerPane,BorderLayout.CENTER);
        
        
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
        
        
    
    }

    @Override
    protected void init() {
        
        newButton.addActionListener(new ActionListener() {
            private int client_id;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data.getSelectedRow()>=0){
                    client_id=((ClientController)lst_client.get(data.getSelectedRow())).getId();
                    
                    panelCita= new Panel_cita(0);
                    popUpWindow.add(panelCita);
                    popUpWindow.pack();
                    
                    

                    popUpWindow.setVisible(true);
                }
            }
        });
        
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data.getSelectedRow()>=0){
//                    meeting_id=((ClientController)lst_client.get(data.getSelectedRow())).getId();
                    panelCita= new Panel_cita(1);
                    popUpWindow.add(panelCita);
                    popUpWindow.pack();



                    popUpWindow.setVisible(true);
                }
           }
        });
        
        columnNames=new String[3];        
        columnNames[0]="Nombre";
        columnNames[1]="Apellido";
        columnNames[2]="Telefono";   
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        DefaultTableModel dtm = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        columNames2=new String[2];        
        columNames2[0]="Fecha";
        columNames2[1]="Hora";
//        columNames2[2]="Sexo";
//        columNames2[3]="Especia";
//        columNames2[4]="Raza";
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        DefaultTableModel dtm2 = new DefaultTableModel(null, columNames2){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        data2 = new JTable(dtm2);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    

    
    
}
