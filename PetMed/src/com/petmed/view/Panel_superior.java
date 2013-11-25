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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

/**
 *
 * @author sjronqui
 */
public class Panel_superior extends JPanel{
    final static String path="/home/sjronqui/PetMedProject/Images/";
    Color color_usuario = Color.LIGHT_GRAY;
    JToolBar herramientas;   
    JPanel pnl_usuario;
    JPanel pnl_usuario_izq;
    JPanel pnl_usuario_der;
    
    
    public Panel_superior(){
        this.setLayout(new BorderLayout());
        herramientas= new JToolBar();
        herramientas.setBackground(Color.DARK_GRAY);
        herramientas.setFloatable(false);
        herramientas.setMargin(new Insets(5,3,5,3));
       
        ImageIcon icono_cliente = new ImageIcon(path+"cliente.png");
        ImageIcon icono_mascota = new ImageIcon(path+"mascota.png");
        ImageIcon icono_cita = new ImageIcon(path+"cita.png");
        ImageIcon icono_perfil = new ImageIcon(path+"perfil.png");
        
        Item item_cliente=new Item("Cliente",icono_cliente);
        Item item_mascota = new Item("Mascota",icono_mascota);
        Item item_cita = new Item("Cita",icono_cita);
        Item item_perfil = new Item("Perfil",icono_perfil);
        Item item_consulta = new Item("Consulta",new ImageIcon(path+"consulta.png"));
        Item item_reporte = new Item("Reporte",new ImageIcon(path+"reporte.png"));
        
        herramientas.add(item_cliente);
        herramientas.add(item_mascota);
        herramientas.add(item_cita);
        herramientas.add(item_consulta);
        herramientas.add(item_reporte);
        herramientas.add(item_perfil);
        
        
        this.add(herramientas,BorderLayout.NORTH);
        
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
        
        this.add(pnl_usuario,BorderLayout.SOUTH);
        
        
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
