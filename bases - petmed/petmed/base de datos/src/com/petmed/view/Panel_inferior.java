/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author sjronqui
 */

public class Panel_inferior extends JPanel{
	
	static JPanel pnl_interno = new JPanel();

	
	public final static String MESSAGEINFO = "Panel_Inferior";
	
    public Panel_inferior(){
   
        this.add(pnl_interno);
        
    }
    
	public static void crearPanelInterior(JPanel panel){
		Panel_inferior.pnl_interno=panel;

	}
    
    
        

    
    
}
    

