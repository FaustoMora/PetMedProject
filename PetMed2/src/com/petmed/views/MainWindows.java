/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.petmed.models.DataConection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Ivan
 */
public class MainWindows extends JFrame {
    JPanel panel;
    MainTabbedPanel c;
    Client cli;
    
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
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent we) {
                cli.update(); //To change body of generated methods, choose Tools | Templates.
            }
            
});
    
    }
    public void populateDoctor(){
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Doctor());
        i.addTab("Reportes", new Panel_medico_consulta());
        c.addTab("Médico","doctor", i);  
    }
    
    public void populateClient(){
        
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        cli=new Client();
        i.addTab("Administrar",cli );
        c.addTab("Cliente","cliente", i);    
    }
    
    public void populatePet(){
        
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("Administrar", new Pet());
        i.addTab("Reportes", new Panel_historial_mascota());
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
