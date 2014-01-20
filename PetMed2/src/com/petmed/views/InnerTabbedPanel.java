/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.views;

import java.awt.Container;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import resources.PlasticTabbedPaneUI;

/**
 *
 * @author Ivan
 */
public class InnerTabbedPanel extends JTabbedPane{
    
    public InnerTabbedPanel(){
        super();
        setTabPlacement(SwingConstants.LEFT);
        setUI(new BasicTabbedPaneUI());
    }
    
    public void addTab(String name,Container c){
        String label="<html><body><h>"+name+"</h></body></html>";
        super.addTab(label, c);
    }
    
}
