package com.petmed.DAO;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;
import com.petmed.*;
import javax.swing.JOptionPane;
import com.petmed.models.*;
import com.petmed.view.Panel_cliente;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
	

	public void insertarCliente(String nom,String apell,String dir,String tlf){
            if(Validacion.validacionCliente(nom, apell, dir, tlf)){
                String cliente = nom + " " + apell;  
		if(!(this.buscarCliente(cliente)>0)){
	
                     try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = new Date();
                        String date = sdf.format(dt);
			java.sql.Date currentTime = new java.sql.Date(sdf.parse(date).getTime());
                                      
                        this.insert(cliente, dir, tlf, currentTime);
                        JOptionPane.showMessageDialog(null,"Nuevo Cliente Ingresado");
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"Error en fecha");
                    }

                }else{
                    JOptionPane.showMessageDialog(null,"Usuario ya existe");
                }
			
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");
            }
	
	}
	
	public void modificarCliente(String nom,String apell,String dir,String tlf){
            if(Validacion.validacionCliente(nom, apell, dir, tlf)){
                String cliente = nom + " " + apell;
                if(this.buscarCliente(cliente)>0){		
                    this.update(nom + " " + apell,dir,tlf);
                    JOptionPane.showMessageDialog(null,"Datos Actualizados");				
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario no existe");
					
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");	
            }
		
	}
	
	public void eliminarCliente(String nombre, String apell){
            if(Validacion.validacionTexto(nombre) && Validacion.validacionTexto(apell)){
                String cliente = nombre + " " + apell;
                this.delete(cliente);
                if(!(this.buscarCliente(cliente)>0)){
                    JOptionPane.showMessageDialog(null, "Cliente Elimnado");
                }else{
                    JOptionPane.showMessageDialog(null, "Problema en la Eliminacion");
                }
            }else{
               JOptionPane.showMessageDialog(null, "Error de Dato");
            }
        }
	
	
	public void insert(String nombre, String dir, String tlf, java.sql.Date fecha){
		String seleccion = "{call insert_cliente('"  + 0 + "','" + nombre +"','" + dir +"','" + tlf +"','" + fecha +"')}";
		DataConexion.ejecutarprocedure(seleccion);
	}
	
	
	public void update(String nom, String dir, String tlf){
		String seleccion = "{call update_cliente('" + nom +"','" + dir +"','" + tlf +"')}";
		DataConexion.ejecutarprocedure(seleccion);
   
	}
	
	public void delete(String nombre){
                String seleccion = "{call delete_cliente('"+nombre+"')}";
                DataConexion.ejecutarprocedure(seleccion);
        }
	
        
        public int buscarCliente(String cliente){
           String seleccion = "{call find_cliente('" + cliente +"')}";
           ResultSet resul = DataConexion.ejecutarProcedureSelect(seleccion);
            try {
                
                if(resul.next()){
                    return resul.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();           
            }
           return 0;

        }
        
        
}
