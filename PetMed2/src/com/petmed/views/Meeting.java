/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import com.petmed.controllers.MeetingController;
import com.petmed.models.ClientDAO;
import com.petmed.models.MeetingDAO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
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
public class Meeting extends PanelBasic{
    private Panel_cita panelCita;
    private ClientDAO clientDao;
    private MeetingDAO citaDao;
    private JTable data2;
    private DefaultTableModel dtm2;
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
        clientDao= new ClientDAO();
        citaDao= new MeetingDAO();
        
        newButton.addActionListener(new ActionListener() {
            
            private ClientController client_tmp;
            @Override
            public void actionPerformed(ActionEvent ae) {
                popUpWindow.getContentPane().removeAll();
                if(data.getSelectedRow()>=0){
                    client_tmp=(ClientController)lst_client.get(data.getSelectedRow());
                    
                    panelCita = new Panel_cita(0);
                    panelCita.txt_nombre.setText(client_tmp.getName()+" "+client_tmp.getLname());
                    
                    popUpWindow.add(panelCita);
                    popUpWindow.pack();
                    
                    panelCita.btn_guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            citaDao.storage(panelCita.txt_fecha.getDate(),
                                            panelCita.listaHoras.getSelectedItem(),
                                            client_tmp.getId());

                            popUpWindow.hide();
                            update2(client_tmp.getId());

                        }
                    });

                    popUpWindow.setVisible(true);
                    }else{
                    JOptionPane.showMessageDialog(null, "Seleccione al dueño de la mascota.");
                }
            }
            
        });
        
        editButton.addActionListener(new ActionListener() {
            private ClientController client_tmp;
            private MeetingController meeting_tmp;
            @Override
            public void actionPerformed(ActionEvent ae) {
                popUpWindow.getContentPane().removeAll();
                if(data2.getSelectedRow()>=0){
                    client_tmp=(ClientController)lst_client.get(data.getSelectedRow());
                    meeting_tmp=(MeetingController)lst_meeting.get(data2.getSelectedRow());
                    panelCita= new Panel_cita(1);
                    panelCita.txt_nombre.setText(client_tmp.getName()+" "+client_tmp.getLname());
                    panelCita.txt_fecha.setDate(meeting_tmp.getDate());
                    panelCita.listaHoras.select(meeting_tmp.getHora().toString());
                    popUpWindow.add(panelCita);
                    popUpWindow.pack();
                    
                panelCita.btn_modificar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            citaDao.update(panelCita.txt_fecha.getDate(),
                                            panelCita.listaHoras.getSelectedItem(),
                                            meeting_tmp.getId());

                            popUpWindow.hide();
                            update2(client_tmp.getId());

                        }
                    });

                    popUpWindow.setVisible(true);
                    }else{
                    JOptionPane.showMessageDialog(null, "Seleccione al dueño de la mascota.");
                }
           }
        });
        
        searchButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(search.getText().isEmpty()){ update();}
                else{update(search.getText());};
            }
        });
        
        
        columnNames=new String[3];        
        columnNames[0]="Nombre";
        columnNames[1]="Apellido";
        columnNames[2]="Telefono";   
        //Object[][] data1 = {{"joe","joe","21","joe","21"},{"fred","31","fred","31","fred"},{"mary","22","mary","22","mary"}};
        dtm = new DefaultTableModel(null, columnNames){

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
        dtm2 = new DefaultTableModel(null, columNames2){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        data2 = new JTable(dtm2);
        
        data.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                while(dtm2.getRowCount()>0) dtm2.removeRow(0);
                update2(((ClientController)lst_client.get(data.getSelectedRow())).getId());
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        
        });
    }

    @Override
    public void update() {
        lst_client = clientDao.getList();
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<lst_client.size();i++){
            ClientController c= (ClientController)lst_client.get(i);
            dtm.insertRow(i,new Object[]{c.getName(),c.getLname(),c.getPhone()});        

            }
    }
    
    public void update(String parameter){
        lst_client = clientDao.getList(parameter);
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<lst_client.size();i++){
            ClientController c= (ClientController)lst_client.get(i);
            dtm.insertRow(i,new Object[]{c.getName(),c.getLname(),c.getPhone()});        

            }
    }
    
    public void update2(int parameter){
        lst_meeting = citaDao.getList(parameter);
        while(dtm2.getRowCount()>0) dtm2.removeRow(0);
        for(int i= 0; i<lst_meeting.size();i++){
            MeetingController c= (MeetingController)lst_meeting.get(i);
            dtm2.insertRow(i,new Object[]{c.getDate().toString(), c.getHora().toString()});        

            }
    }
    
    
}
