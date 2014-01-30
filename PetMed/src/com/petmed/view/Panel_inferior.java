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
    public Panel_inferior(){
        this.setLayout(new FlowLayout());
        Panel_interno pnl_interno= new Panel_interno();
        
        this.add(pnl_interno);
        
    }
    
    private class Panel_interno extends JPanel{
        public Panel_interno(){
            CardLayout card = new CardLayout();
            this.setLayout(card);
     
            final String masco="mascota";
            final String trata="tratamiento";
            final String nclient="nuevo_cliente";
            
                  
            //this.add(new Panel_consulta());
            //this.add(new Panel_cliente());
            this.add(new Panel_cita());
            //this.add(new Panel_farmaco());
            //this.add(new Panel_tratamiento());
            this.add(new Panel_mascota()); 
            this.add(new Panel_modificar_cliente());
            this.add(new Panel_consultas_medico());
            this.add(new Panel_consultas_sintoma());
            this.add(new Panel_historial_mascota());
            this.add(new Panel_consultas_fecha());
            this.add(new Panel_citas_cliente());
            this.add(new Panel_citas_fechas());
            this.add(new Panel_nuevos_clientes(),nclient);
           
        }
        
  
    }
    
}
    

