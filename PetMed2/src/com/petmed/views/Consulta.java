/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import com.petmed.controllers.ConsultaController;
import com.petmed.controllers.PetController;
import com.petmed.models.ClientDAO;
import com.petmed.models.ConsultaDAO;
import com.petmed.models.DataConection;
import com.petmed.models.PetDAO;
import com.petmed.models.Validacion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sjronqui
 */




public class Consulta extends PanelBasic{
        JTextField txt_nombre;
        DefaultTableModel dtm3;
        JTable table;
        private Panel_consulta panel_consulta;
        private JTable data2;
        private String columNames2[];
        private ClientDAO clientDao;
        private PetDAO petDao;
        private ConsultaDAO consultaDao;
        private DefaultTableModel dtm2;
        private LinkedList lst_client = new LinkedList();
        private LinkedList lst_pet = new LinkedList();
        private LinkedList lst_consult = new LinkedList();

    
    public Consulta(){

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
        panel2.setBorder(new TitledBorder("Mascotas"));
        innerPane.add(panel1);
        innerPane.add(panel2);
        add(innerPane,BorderLayout.CENTER);
        
        
        table.setPreferredScrollableViewportSize(new Dimension(650,200));
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel3=new JPanel();
        panel3.add(scroll);;
        add(panel3,BorderLayout.SOUTH);
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
    }

    @Override
    protected void init() {
        clientDao= new ClientDAO();
        petDao= new PetDAO();
        consultaDao = new ConsultaDAO();
        
        newButton.addActionListener(new ActionListener() {
            private int pet_id;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data2.getSelectedRow()>=0){
                    pet_id=((PetController)lst_pet.get(data2.getSelectedRow())).getId();

                    popUpWindow.getContentPane().removeAll();
                    panel_consulta= new Panel_consulta(0);
                    popUpWindow.add(panel_consulta);
                    
                    panel_consulta.btn_guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            
                            consultaDao.storage(pet_id,
                                                1,
                                                panel_consulta.txt_motivo.getText(),
                                                panel_consulta.txt_diagnostico.getText(),
                                                1,
                                                panel_consulta.txt_fecha.getDate(),
                                                panel_consulta.txt_hora.getText());

                            popUpWindow.hide();
                            cargarTabla(pet_id);

                        }
                    });

                    popUpWindow.pack();      
                    popUpWindow.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione la mascota desde la lista");
                }
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            private ConsultaController consult_tmp;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(table.getSelectedRow()>=0){
                    consult_tmp=(ConsultaController)lst_consult.get(table.getSelectedRow());

                    popUpWindow.getContentPane().removeAll();
                    panel_consulta= new Panel_consulta(1);
                    panel_consulta.txt_fecha.setDate(consult_tmp.getFecha());
                    panel_consulta.txt_hora.setText(consult_tmp.getHora().toString());
                    panel_consulta.txt_motivo.setText(consult_tmp.getMotivo());
                    popUpWindow.add(panel_consulta);
                    
                    panel_consulta.btn_modificar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            
                            consultaDao.update(consult_tmp.getId(),                                        
                                               panel_consulta.txt_diagnostico.getText(),
                                               1);

                            popUpWindow.hide();
                            cargarTabla(data2.getSelectedRow());

                        }
                    });

                    popUpWindow.pack();      
                    popUpWindow.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione la consulta a modificar");
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
        
        dtm = new DefaultTableModel(null, columnNames){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        columNames2=new String[5];        
        columNames2[0]="Nombre";
        columNames2[1]="Fecha Nacimiento";
        columNames2[2]="Sexo";
        columNames2[3]="Especie";
        columNames2[4]="Raza";
        
        dtm2 = new DefaultTableModel(null, columNames2){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        String[] columNames3=new String[4];
        columNames3[0]="Fecha";
        columNames3[1]="Hora";
        columNames3[2]="Motivo";
        columNames3[3]="Diagnóstico";
        
        dtm3 = new DefaultTableModel(null, columNames3){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        data = new JTable(dtm);
        data2 = new JTable(dtm2);
        table = new JTable(dtm3);
        
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
        
        data2.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                cargarTabla(((PetController)lst_pet.get(data2.getSelectedRow())).getId());
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
            dtm.insertRow(i,new Object[]{c.getRegisterDate(),c.getName(),c.getAddress(),c.getPhone()});        

            }
    }

    public void update(String parameter){
        lst_client = clientDao.getList(parameter);
        while(dtm.getRowCount()>0) dtm.removeRow(0);
        for(int i= 0; i<lst_client.size();i++){
            ClientController c= (ClientController)lst_client.get(i);
            dtm.insertRow(i,new Object[]{c.getRegisterDate(),c.getName(),c.getAddress(),c.getPhone()});        

            }
    }
    
    public void update2(int parameter){
        lst_pet = petDao.getList(parameter);
        while(dtm2.getRowCount()>0) dtm2.removeRow(0);
        for(int i= 0; i<lst_pet.size();i++){
            PetController c= (PetController)lst_pet.get(i);
            dtm2.insertRow(i,new Object[]{c.getNombre(),c.getBirthDate(),c.getSexo(),c.getEspecie(),c.getRaza()});        

            }
    }
    
    public void cargarTabla(int id){
        
        lst_consult = consultaDao.getList(id);
        while(dtm3.getRowCount()>0) dtm3.removeRow(0);
        for(int i= 0; i<lst_consult.size();i++){
            ConsultaController c= (ConsultaController)lst_consult.get(i);
            dtm3.insertRow(i,new Object[]{c.getFecha(),c.getHora(), c.getMotivo(),c.getDiagnostico()});      
   
        }
        
        
    }
    
}