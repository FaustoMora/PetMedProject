/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public abstract class PanelBasic extends JPanel{
    protected JTextField search;
    protected JButton searchButton;
    protected JTable data;
    protected JButton newButton,editButton,deleteButton;
    protected JFrame popUpWindow;
    protected JPanel searchPanel;
    protected String[] columnNames;
    protected DefaultTableModel dtm;
    
    public PanelBasic(){
        
        newButton = new JButton("Nuevo");
        editButton = new JButton("Editar");
        deleteButton = new JButton("Borrar");
        popUpWindow = new JFrame();
        popUpWindow.setVisible(false);
        popUpWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        search = new JTextField(20);
        searchButton = new JButton("Buscar");     
        
        searchPanel = new JPanel(new BorderLayout());
        searchPanel.add(search,BorderLayout.CENTER);
        searchPanel.add(searchButton,BorderLayout.EAST);        
        searchPanel.setBorder(new EmptyBorder(8,8,8,8));
        
        
    }
    protected abstract void init();
    
    public abstract void update();
    
    
            
}
