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
import javax.swing.JOptionPane;
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
    public static LinkedList temp = new LinkedList();
    
    
    
    public Client(){
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
                popUpWindow.getContentPane().removeAll();
                client_panel= new Panel_cliente(0);
                popUpWindow.add(client_panel);
                
                client_panel.btn_guardar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        clientDao.storage(client_panel.txt_nombre.getText(), client_panel.txt_apellido.getText(), client_panel.txt_direccion.getText(), client_panel.txt_telefono.getText());
                        popUpWindow.hide();
                        update();

                    }
                });
                
                popUpWindow.pack();
                popUpWindow.setVisible(true);
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            private ClientController client_tmp;    

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data.getSelectedRow()<0)
                    JOptionPane.showMessageDialog(null, "No ha seleccionado un cliente");
                else{//protección temporal para evitar que edite sin haber seleccionado antes.
                    popUpWindow.getContentPane().removeAll();
                    
                    client_tmp=(ClientController)temp.get(data.getSelectedRow());
                    client_panel= new Panel_cliente(1);
                    client_panel.txt_nombre.setText(client_tmp.getName());
                    client_panel.txt_apellido.setText(client_tmp.getLname());
                    client_panel.txt_direccion.setText(client_tmp.getAddress());
                    client_panel.txt_telefono.setText(""+client_tmp.getPhone());
                    
                    popUpWindow.add(client_panel);
                    
                    
                    client_panel.btn_modificar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            clientDao.update(client_tmp.getId(),client_panel.txt_nombre.getText(), client_panel.txt_apellido.getText(), client_panel.txt_direccion.getText(), client_panel.txt_telefono.getText());
                            popUpWindow.hide();
                            update();

                        }
                    });

                    popUpWindow.pack();
                    popUpWindow.setVisible(true);

                        

                }              
           }
        });
        
        //revisar:
        searchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(search.getText().isEmpty()){ update();}
                else{update(search.getText());};
            }
        });//
        
        deleteButton.addActionListener(new ActionListener() {
            private ClientController client_tmp;  

            @Override
            public void actionPerformed(ActionEvent ae) {
                 client_tmp=(ClientController)temp.get(data.getSelectedRow());
                
            }
        });
        
        
        
        columnNames=new String[5];
        columnNames[0]="Fecha de registro";
        columnNames[1]="Nombre";
        columnNames[2]="Apellido";
        columnNames[3]="Direccion";
        columnNames[4]="Telefono";   
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        dtm = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        
        
        
        
    }

    @Override
    public void update() {
        dtm.setRowCount(0);
   
        temp = clientDao.getList();
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<temp.size();i++){
            ClientController c= (ClientController)temp.get(i);
            dtm.insertRow(i,new Object[]{c.getRegisterDate(),c.getName(), c.getLname(),c.getAddress(),c.getPhone()});        
            
            }

        }
        
    public void update(String parameter){
        dtm.setRowCount(0);
        temp = clientDao.getList(parameter);
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<temp.size();i++){
            ClientController c= (ClientController)temp.get(i);
            dtm.insertRow(i,new Object[]{c.getRegisterDate(),c.getName(), c.getLname(),c.getAddress(),c.getPhone()});      
            
            
        }
    }
}

    

    
    

