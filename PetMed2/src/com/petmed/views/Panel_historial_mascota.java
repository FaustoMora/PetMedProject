/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import com.petmed.controllers.PetController;
import com.petmed.models.ClientDAO;
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




public class Panel_historial_mascota extends PanelBasic{
        JTextField txt_nombre;
        DefaultTableModel dtm3;
        JTable table;
        private Panel_mascota panel_mascota;
        private JTable data2;
        private String columNames2[];
        private ClientDAO clientDao;
        private PetDAO petDao;
        private DefaultTableModel dtm2;
        private LinkedList lst_client = new LinkedList();
        private LinkedList lst_pet = new LinkedList();
            

    
    public Panel_historial_mascota(){

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
        
    }

    @Override
    protected void init() {
        clientDao= new ClientDAO();
        petDao= new PetDAO();
 
        
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
        
        String[] columNames3=new String[6];
        columNames3[0]="Temperatura";
        columNames3[1]="Peso";
        columNames3[2]="Diagnóstico";
        columNames3[3]="Fecha de la consulta";
        columNames3[4]="Descripción";
        columNames3[5]="Nombre";
        
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
        String seleccion = "call select_mascota_historial("+id+");";
        ResultSet rs = DataConection.ejecutarProcedureSelect(seleccion);
  
        while(dtm3.getRowCount()>0) dtm3.removeRow(0);
        try {
            int i=0;
            while(rs.next()){
                dtm3.insertRow(i,new Object[]{rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6)}); 
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}