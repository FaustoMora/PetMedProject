/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.DAO;

import com.petmed.models.DataConexion;
import com.petmed.models.Validacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lost Legion
 */
public class CitaDAO {
    
    public void ingresarCita(String nombre,Date fecha, String hora){
        if(Validacion.validacionTexto(nombre)){
            int cliente_id= new ClienteDAO().buscarCliente(nombre);
            
            if((cliente_id > 0)){
                if(!(this.buscarCita(cliente_id)>0)){
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String date = sdf.format(fecha);
                        java.sql.Date reg_date = new java.sql.Date(sdf.parse(date).getTime());

                        Date hour = new SimpleDateFormat("HH:mm").parse(hora);
                        java.sql.Time reg_time = new java.sql.Time(hour.getTime());

                        this.insert(reg_date,reg_time,cliente_id);
                        JOptionPane.showMessageDialog(null, "Cita creada exitosamente");
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }   
                }else{
                    JOptionPane.showMessageDialog(null, "Cita ya existente");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Medico o Cliente no registrado");
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error Dato");
        }
    }
    public void modificarCita(String nombre, Date fecha, String hora){
        if(Validacion.validacionTexto(nombre)){
           int cliente_id= new ClienteDAO().buscarCliente(nombre);
           
           if((cliente_id>0)){
               if(this.buscarCita(cliente_id)>0){
                   try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String date = sdf.format(fecha);
                        java.sql.Date reg_date = new java.sql.Date(sdf.parse(date).getTime());

                        Date hour = new SimpleDateFormat("HH:mm").parse(hora);
                        java.sql.Time reg_time = new java.sql.Time(hour.getTime());

                        this.update(reg_date,reg_time,cliente_id);
                        JOptionPane.showMessageDialog(null, "Cita modificada exitosamente");
                    }catch (ParseException ex) {
                        ex.printStackTrace();
                    }
               }else{
                   JOptionPane.showMessageDialog(null, "Cita no existente");
               }
           }else{
               JOptionPane.showMessageDialog(null, "Medico o Cliente no registrado");
           }
        }else{
            JOptionPane.showMessageDialog(null, "Error Dato");
        }
    }
    
    public void eliminarCita(String nombre){
        if( Validacion.validacionTexto(nombre)){
           int cliente_id= new ClienteDAO().buscarCliente(nombre);
          
           if((cliente_id>0)){
               this.delete(cliente_id);
               
               if(!(this.buscarCita(cliente_id)>0)){
                   JOptionPane.showMessageDialog(null, "Cita Eliminada Exitosamente");
               }else{
                   JOptionPane.showMessageDialog(null, "Error al eliminar Cita");
               }
           }else{
               JOptionPane.showMessageDialog(null, "Cliente no registrado");
           } 
        }else{
            JOptionPane.showMessageDialog(null, "Error dato");
        }
    }
    
    
    public void insert(java.sql.Date fecha,java.sql.Time hora, int cliente_id){
        String seleccion="{call insert_cita('"+ 0 +"','"+ fecha +"','"+ hora +"','"+ cliente_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void update(java.sql.Date fecha,java.sql.Time hora, int cliente_id){
        String seleccion="{call update_cita('"+ fecha +"','"+ hora +"','"+ cliente_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void delete(int cliente_id){
        String seleccion="{call delete_cita('"+ cliente_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public int buscarCita(int cliente_id){
           String seleccion = "{call find_cita('"+ cliente_id +"')}";
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
