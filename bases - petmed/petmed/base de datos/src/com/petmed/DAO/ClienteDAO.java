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
		if(!this.validarCliente(nom, apell)){
	
                     try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date dt = new Date();
                        String date = sdf.format(dt);
			java.sql.Date currentTime = new java.sql.Date(sdf.parse(date).getTime());
                                        
                        this.insert(nom + " " + apell, dir, tlf, currentTime);
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
                if(this.validarCliente(nom, apell)){		
                    this.update(nom + " " + apell,dir,tlf);
                    JOptionPane.showMessageDialog(null,"Datos Actualizados");				
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario no existe");
					
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");	
            }
		
	}
	
	public void eliminarCliente(){}
	
	
	public void insert(String nombre, String dir, String tlf, java.sql.Date fecha){
		String seleccion = "{call insert_cliente('"  + 0 + "','" + nombre +"','" + dir +"','" + tlf +"','" + fecha +"')}";
		DataConexion.ejecutarprocedure(seleccion);
	}
	
	
	public void update(String nom, String dir, String tlf){
		String seleccion = "{call update_cliente('" + nom +"','" + dir +"','" + tlf +"')}";
		DataConexion.ejecutarprocedure(seleccion);
   
	}
	
	public void delete(){}
	
	
	
	public boolean validarCliente(String nom, String apell){
            try{
		String id = nom + " " + apell;
		String seleccion = "{call find_cliente('" + id +"')}";
		return DataConexion.ejecutarprocedureBool(seleccion);
            }catch(Exception e){
                e.printStackTrace();
                return false;
            }
	}
}
