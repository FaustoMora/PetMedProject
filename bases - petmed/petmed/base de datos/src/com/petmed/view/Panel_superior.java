/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author sjronqui
 */
public class Panel_superior extends JPanel{
    final static String path="../Images/";
    Color color_usuario = Color.LIGHT_GRAY;
    public static JTabbedPane herramientas; 
    JPanel pnl_usuario;
    JPanel pnl_usuario_izq;
    JPanel pnl_usuario_der;

    
 

    
    public Panel_superior(){
        this.setLayout(new BorderLayout());
        
       
        ImageIcon icono_cliente = new ImageIcon(path+"cliente.png");
        ImageIcon icono_mascota = new ImageIcon(path+"mascota.png");
        ImageIcon icono_cita = new ImageIcon(path+"cita.png");
        ImageIcon icono_perfil = new ImageIcon(path+"perfil.png");

        this.herramientas = new JTabbedPane();
        this.herramientas.setBackground(Color.white);
        
        Panel_cliente panel_cliente = new Panel_cliente();
        herramientas.addTab("Cliente", icono_cliente, panel_cliente,"Opciones para Cliente");
        
        Panel_mascota panel_mascota = new Panel_mascota();
        herramientas.addTab("Mascota", icono_mascota, panel_mascota,"Opciones para Mascota");
        
        Panel_cita panel_cita = new Panel_cita();
        herramientas.addTab("Cita", icono_cita, panel_cita,"Opciones para Cita");
        
        Panel_consulta panel_consulta = new Panel_consulta();
        herramientas.addTab("Consulta", new ImageIcon(path+"consulta.png"), panel_consulta,"Opciones para Consulta");
        
        JPanel panel_reporte= new JPanel();
        herramientas.addTab("Reporte", new ImageIcon(path+"reporte.png"), panel_reporte,"Opciones para Reporte");
        
        JPanel panel_perfil = new JPanel();
        herramientas.addTab("Perfil", icono_perfil, panel_perfil,"Opciones para Perfil");

        this.add(herramientas,BorderLayout.CENTER);
        
   
        
        pnl_usuario = new JPanel();
        pnl_usuario.setLayout(new BorderLayout());
        pnl_usuario.setBackground(color_usuario);
        
        pnl_usuario_izq = new JPanel();
        pnl_usuario_izq.setLayout(new FlowLayout());
        pnl_usuario_izq.setBackground(color_usuario);
        pnl_usuario_izq.add(new JLabel("NONBRES APELLIDOS"));
        
        pnl_usuario_der = new JPanel();
        pnl_usuario_der.setLayout(new FlowLayout());
        pnl_usuario_der.setBackground(color_usuario);
        pnl_usuario_der.add(new JLabel("Día del mes, año.   "));
        pnl_usuario_der.add(new JButton("Cerrar Sesión"));
        
        pnl_usuario.add(pnl_usuario_izq, BorderLayout.WEST);
        pnl_usuario.add(pnl_usuario_der, BorderLayout.EAST);
        
        this.add(pnl_usuario,BorderLayout.NORTH);
        
        
        this.setSize(100, 200);
        

    }
    
    
    public class Item extends JButton{
        public Item(String str,ImageIcon icono){
            super(str,icono);
            this.setVerticalTextPosition(SwingConstants.BOTTOM);
            this.setHorizontalTextPosition(SwingConstants.CENTER);
            this.setBackground(Color.GRAY);
        }
    }
    
    
    
    	
    
    
}
