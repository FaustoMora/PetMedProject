/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ivan
 */
public class MainWindows extends JFrame {
    JPanel panel;
    MainTabbedPanel c;
    
    public MainWindows(){
        super("PetMed v2.0");
        panel = new JPanel();
        c=new MainTabbedPanel();
        populateClient();
        populatePet();
        populateMeeting();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    public void populateClient(){
        
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Client());
        c.addTab("Cliente","cliente", i);    
    }
    
    public void populatePet(){
        
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Pet());
        c.addTab("Mascota","mascota", i);    
    }
    
    public void populateMeeting(){
        
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Meeting());
        c.addTab("Citas","cita", i);    
    }
    
    public static void main(String args[]){
        new MainWindows();
    
    }
}
