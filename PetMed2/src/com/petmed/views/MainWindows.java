/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ivan
 */
public class MainWindows extends JFrame {
    JPanel panel;
    
    public MainWindows(){
        panel = new JPanel();
        MainTabbedPanel c=new MainTabbedPanel();
        InnerTabbedPanel i=new InnerTabbedPanel();
        getContentPane().add(c);
        i.addTab("prueba", new Client());
        c.addTab("test","cliente", i);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    
    public static void main(String args[]){
        new MainWindows();
    
    }
}
