package com.petmed.DAO;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.petmed.models.*;
import com.petmed.view.*;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MascotaDAO {
	public void ingresarMascota(String nom, String esp, String raza, Date fecha_nacimiento, String sexo, String dueño){
		
            if(Validacion.validacionTexto(nom)&& Validacion.validacionTexto(raza)){ 
                int id_cliente =  new ClienteDAO().buscarCliente(dueño);
                if(id_cliente>0){
                    if(!(this.buscarMascota(nom, id_cliente)>0)){
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            String date = sdf.format(fecha_nacimiento);
                            java.sql.Date birth = new java.sql.Date(sdf.parse(date).getTime());

                            this.insert(nom, esp, raza, birth, sexo,id_cliente);
                            JOptionPane.showMessageDialog(null, "Mascota Ingresada a: " + dueño);
                        }catch (ParseException ex) {
                            ex.printStackTrace();
                        }   
                    }else{
                        JOptionPane.showMessageDialog(null, "Mascota ya existe en este cliente");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No exite el cliente");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error en dato");
            }
	}
	
	public void modificarMascota(String nom, String espe, String raza, Date fecha_nacimiento, String sexo, String dueño){
            if(Validacion.validacionTexto(nom)&& Validacion.validacionTexto(raza)){
                int id_cliente =  new ClienteDAO().buscarCliente(dueño);
                if(this.buscarMascota(nom, id_cliente)>0){
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String date = sdf.format(fecha_nacimiento);
                        java.sql.Date birth = new java.sql.Date(sdf.parse(date).getTime());
                        
                        this.update(nom,espe,raza,birth,sexo,id_cliente);
                        JOptionPane.showMessageDialog(null, "Mascota Modifcada");
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "No existe esa mascota con el cliente: " +dueño);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error Dato");
            }
        }
	
	public void eliminarMascota(String nom, String dueño){
            if(Validacion.validacionTexto(nom) && Validacion.validacionTexto(dueño)){
                int id_cliente = new ClienteDAO().buscarCliente(dueño);
                this.delate(nom,id_cliente);
                
                if(!(this.buscarMascota(nom, id_cliente)>0)){
                    JOptionPane.showMessageDialog(null, "Mascota Eliminada");
                }else{
                    JOptionPane.showMessageDialog(null, "Problema en la Eliminacion");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error Dato");
            }
        }
	
	
	public void insert(String nombre, String esp, String raza, java.sql.Date fecha, String sexo, int id_cliente){
            String seleccion = "{call insert_mascota('"+ 0 +"','"+ nombre +"','"+ esp +"','"+ raza +"','"+ fecha +"','"+ sexo +"','"+ id_cliente +"')}";
            DataConexion.ejecutarprocedure(seleccion);
        }
	
	public void update(String nombre, String esp, String raza, java.sql.Date fecha, String sexo, int id_cliente){
            String seleccion = "{call update_mascota('"+ nombre +"','"+ esp +"','"+ raza +"','"+ fecha +"','"+ sexo +"','"+ id_cliente +"')}";
            DataConexion.ejecutarprocedure(seleccion);
        }
	
	public void delate(String nombre, int id_cliente){
            String seleccion = "{call delete_mascota('"+ nombre +"','"+ id_cliente +"')}";
            DataConexion.ejecutarprocedure(seleccion);
        }
        
        public int buscarMascota(String nombre, int id_cliente){
            
           String seleccion = "{call find_mascota('" + nombre +"', '" + id_cliente +"')}";
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
