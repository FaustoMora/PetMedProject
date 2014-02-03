/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import com.petmed.controllers.PetController;
import com.petmed.models.ClientDAO;
import com.petmed.models.PetDAO;
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
public class Pet extends PanelBasic {
    private Panel_mascota panel_mascota;
    private JTable data2;
    private String columNames2[];
    private ClientDAO clientDao;
    private PetDAO petDao;
    private DefaultTableModel dtm2;
    private LinkedList lst_client = new LinkedList();
    private LinkedList lst_pet = new LinkedList();
    
    public Pet(){
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
        
        
        
        panelButtons.add(newButton);
        panelButtons.add(editButton);
        panelButtons.add(deleteButton);
        
    }

    @Override
    protected void init() {
        clientDao= new ClientDAO();
        petDao= new PetDAO();
        newButton.addActionListener(new ActionListener() {
            private int client_id;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data.getSelectedRow()>=0){
                    client_id=((ClientController)lst_client.get(data.getSelectedRow())).getId();

                    popUpWindow.getContentPane().removeAll();
                    panel_mascota= new Panel_mascota(0);
                    popUpWindow.add(panel_mascota);
                    
                    panel_mascota.btn_guardar.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent ae) {

                            panel_mascota.rb_macho.setSelected(true);
                            petDao.storage( panel_mascota.txt_nombre.getText(),
                                            panel_mascota.ch_especie.getSelectedItem(),
                                            panel_mascota.txt_raza.getText(),
                                            panel_mascota.txt_nacimiento.getDate(),
                                            panel_mascota.gp_sexo.getSelection().getActionCommand().charAt(0),
                                            //panel_mascota.gp_sexo.getSelection().toString().charAt(0),
                                            client_id);

                            popUpWindow.hide();
                            update2(client_id);

                        }
                    });

                    popUpWindow.pack();      
                    popUpWindow.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione al dueño de la mascota.");
                }
            }
        });
        
        editButton.addActionListener(new ActionListener() {
            private PetController pet_tmp;
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(data2.getSelectedRow()>=0){
                    pet_tmp=(PetController)lst_pet.get(data2.getSelectedRow());

                    popUpWindow.getContentPane().removeAll();
                    panel_mascota= new Panel_mascota(1);
                    
                    panel_mascota.txt_nombre.setText(pet_tmp.getNombre());
                    panel_mascota.txt_nacimiento.setDate(pet_tmp.getBirthDate());
                    panel_mascota.txt_raza.setText(pet_tmp.getRaza());
                    panel_mascota.ch_especie.select(pet_tmp.getEspecie());
                    if(pet_tmp.getSexo().equals("H")){
                        panel_mascota.rb_hembra.setSelected(true);}
                    else{
                        panel_mascota.rb_macho.setSelected(true);}
                    
                    
                    
                    
                    popUpWindow.add(panel_mascota);

                    panel_mascota.btn_modificar.addActionListener(new ActionListener() {
                        private PetController pet_tmp;

                        @Override
                        public void actionPerformed(ActionEvent ae) {               
                                                     

                            System.out.println(panel_mascota.gp_sexo.getSelection().getActionCommand().charAt(0));
                            petDao.update(pet_tmp.getId(), panel_mascota.txt_nombre.getText(),
                                            panel_mascota.ch_especie.getSelectedItem(),
                                            panel_mascota.txt_raza.getText(),
                                            panel_mascota.txt_nacimiento.getDate(),
                                            panel_mascota.gp_sexo.getSelection().getActionCommand().charAt(0));
                            

                            popUpWindow.hide();
                            update2(((ClientController)lst_client.get(data.getSelectedRow())).getId());

                        }
                    });

                    popUpWindow.pack();      
                    popUpWindow.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Seleccione la mascota.");
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
        
        columNames2=new String[5];        
        columNames2[0]="Nombre";
        columNames2[1]="Fecha Nacimiento";
        columNames2[2]="Sexo";
        columNames2[3]="Especie";
        columNames2[4]="Raza";
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
    
}
