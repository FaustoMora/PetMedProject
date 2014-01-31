/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.ClientController;
import com.petmed.models.ClientDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class Client extends PanelBasic{
    private Panel_cliente client_panel;
    private ClientDAO clientDao;
    
    
    
    public Client(){
        super();
        setLayout(new BorderLayout());
        client_panel= new Panel_cliente();
        popUpWindow.add(client_panel);
        popUpWindow.pack();
        init();
        JPanel panelButtons= new JPanel(new GridLayout(1,3));
        
        JPanel bar= new JPanel(new GridLayout(2,1));
        bar.add(searchPanel);
        JPanel temp = new JPanel(new BorderLayout());
        temp.add(panelButtons,BorderLayout.EAST);
        temp.setSize(new Dimension(20,40));
        bar.add(temp);
        add(bar,BorderLayout.NORTH);
        JScrollPane panel1= new JScrollPane(data);
        panel1.setBorder(new TitledBorder("Clientes"));
        add(panel1,BorderLayout.CENTER);
        
        
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
        
        
    }

    
    @Override
    protected void init() {
        clientDao = new ClientDAO();
        newButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                popUpWindow.setVisible(true);
            }
        });
        
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //data.getSele
           }
        });
        
        columnNames=new String[4];
        columnNames[0]="Fecha de registro";
        columnNames[1]="Nombre";
        
        columnNames[2]="Direccion";
        columnNames[3]="Telefono";   
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        dtm = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        
        client_panel.btn_guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                clientDao.storage(client_panel.txt_nombre.getText(), client_panel.txt_apellido.getText(), client_panel.txt_direccion.getText(), client_panel.txt_telefono.getText());
                popUpWindow.hide();
                update();
                
            }
        });
        
        
    }

    @Override
    public void update() {
        
        LinkedList temp = new LinkedList();
        temp = clientDao.getList();
        for(int i= 0; i<temp.size();i++){
            ClientController c= (ClientController)temp.get(i);
            dtm.insertRow(i,new Object[]{c.getRegisterDate(),c.getName(),c.getAddress(),c.getPhone()});        
            
            
            }
        
        
        
        
        }
        
}

    

    
    

