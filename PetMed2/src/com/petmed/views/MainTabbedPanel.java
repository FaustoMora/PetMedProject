/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import resources.PlasticTabbedPaneUI;

/**
 *
 * @author Ivan
 */
public class MainTabbedPanel extends JTabbedPane{
   final static String path="../Images/";


    public MainTabbedPanel() {
        super();
        
        setUI(new BasicTabbedPaneUI() );
    }
    
    public void addTab(String name,String image,Container c){
        ImageIcon icono_cliente = new ImageIcon(path+image+".png");        
        super.addTab(name, icono_cliente, c);
    
    }
    
    
    
    
    
}
