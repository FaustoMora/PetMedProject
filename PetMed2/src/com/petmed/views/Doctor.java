/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;


import com.petmed.controllers.DoctorController;
import com.petmed.models.DoctorDAO;
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
public class Doctor extends PanelBasic{
    private Panel_medico doctor_panel;
    private DoctorDAO doctorDao;
    private LinkedList temp = new LinkedList();
    
    
    
    public Doctor(){
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
        panel1.setBorder(new TitledBorder("Medicos"));
        add(panel1,BorderLayout.CENTER);
        
        
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
        
        
    }

    
    @Override
    protected void init() {
        doctorDao = new DoctorDAO();
        newButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                popUpWindow.getContentPane().removeAll();
                doctor_panel= new Panel_medico(0);
                popUpWindow.add(doctor_panel);
                
                doctor_panel.btn_guardar.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        doctorDao.storage(doctor_panel.txt_nombre.getText(), doctor_panel.txt_telefono.getText());
                        popUpWindow.hide();
                        update();

                    }
                });
                
                popUpWindow.pack();
                popUpWindow.setVisible(true);
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            private DoctorController doctor_tmp;    

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data.getSelectedRow()>=0){//protección temporal para evitar que edite sin haber seleccionado antes.
                    popUpWindow.getContentPane().removeAll();
                    
                    doctor_tmp=(DoctorController)temp.get(data.getSelectedRow());
                    doctor_panel= new Panel_medico(1);
                    doctor_panel.txt_nombre.setText(doctor_tmp.getName());                   
                    doctor_panel.txt_telefono.setText(""+doctor_tmp.getPhone());
                    
                    popUpWindow.add(doctor_panel);
                    
                    
                    doctor_panel.btn_modificar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            doctorDao.update(doctor_tmp.getId(),doctor_panel.txt_nombre.getText(), doctor_panel.txt_telefono.getText());
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
        
        
        
        columnNames=new String[2];
        columnNames[0]="Nombre";
        columnNames[1]="Telefono";   
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
   
        temp = doctorDao.getList();
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<temp.size();i++){
            DoctorController c= (DoctorController)temp.get(i);
            dtm.insertRow(i,new Object[]{c.getName(), c.getPhone()});        
            
            }

        }
        
    public void update(String parameter){
        temp = doctorDao.getList(parameter);
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<temp.size();i++){
            DoctorController c= (DoctorController)temp.get(i);
            dtm.insertRow(i,new Object[]{c.getName(), c.getPhone()});        
            
            
        }
    }
}

    

    
    

