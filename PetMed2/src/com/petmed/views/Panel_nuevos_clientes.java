/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import com.petmed.controllers.ClientController;
import com.petmed.models.ClientDAO;
import static com.petmed.views.Client.temp;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JButton;

/**
 *
 * @author sjronqui
 */
public class Panel_nuevos_clientes extends JPanel{
        DefaultTableModel tabla;
        private JTable dtm;
        private ClientDAO clienteDao;
        JDateChooser txt_de;
        JDateChooser txt_hasta;
        
    public Panel_nuevos_clientes(){
        clienteDao = new ClientDAO();
        this.setSize(200, 300);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets=new Insets(0,0,5,5);
        
        JLabel lbl_de= new JLabel("Desde:");
        JLabel lbl_hasta= new JLabel("Hasta:");
        JButton consultar = new JButton("Consultar"); 
       
       
        
        txt_de=new JDateChooser();    
        
        txt_hasta=new JDateChooser();
        
        String columNames[] = {"#" ,"Nombre" ,"Apellido","Fecha de registro" ,"Telefono" ,"Direccion" };
        
         consultar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                update(txt_de.getDate(), txt_hasta.getDate());
            }
        });
        
        tabla = new DefaultTableModel(columNames,30);
        
        dtm = new JTable(tabla);
        dtm.setPreferredScrollableViewportSize(new Dimension(550,300));
        JScrollPane scroll = new JScrollPane(dtm);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(scroll);
        
        JPanel pnl_entrada= new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnl_entrada.add(lbl_de);
        pnl_entrada.add(txt_de);
        pnl_entrada.add(lbl_hasta);
        pnl_entrada.add(txt_hasta);
        pnl_entrada.add(consultar);
        
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=1;
        gbc.anchor=GridBagConstraints.WEST;
        
        gbc.weightx=GridBagConstraints.REMAINDER;
        this.add(pnl_entrada,gbc);
        
        gbc.anchor=GridBagConstraints.PAGE_END;
        gbc.gridx=0;
        gbc.gridy=2;
        this.add(panel,gbc);
    }
    
    public void update(Date inic,Date fin) {
        tabla.setRowCount(0);
        LinkedList<ClientController> list= new LinkedList<>();
   
        list = clienteDao.getList(inic,fin);
        
        for(int i= 0; i<list.size();i++){
            ClientController c= (ClientController)list.get(i);
            tabla.insertRow(i,new Object[]{c.getId(),c.getName(), c.getLname(),c.getRegisterDate(),c.getPhone(),c.getAddress()});        
            
            }

        }
    
    
    
    
    
}
