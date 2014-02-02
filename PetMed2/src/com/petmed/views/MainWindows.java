/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.petmed.models.DataConection;

/**
 *
 * @author Ivan
 */
public class MainWindows extends JFrame {
    JPanel panel;
    MainTabbedPanel c;
    
    public MainWindows(){
        super("PetMed v2.0");
        DataConection.performConnection();
        panel = new JPanel();
        c=new MainTabbedPanel();
        populateClient();
        populatePet();
        populateMeeting();
        populateDoctor();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    public void populateDoctor(){
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Doctor());
        c.addTab("Médico","doctor", i);  
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
