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

/**
 *
 * @author Lost Legion
 */
public class ConsultaDAO {
    
    public int ingresarConsulta(java.sql.Date currentTime, String hora, String motivo, String diagnostico, int  medico_id, int  tratamiento_id, int  mascota_id){
        if(Validacion.validacionTexto(motivo) && Validacion.validacionTexto(diagnostico)){       
            try {    
            
            Date hour = new SimpleDateFormat("HH:mm").parse(hora);
            java.sql.Time reg_time = new java.sql.Time(hour.getTime());
           
                if(!(this.buscarConsulta(currentTime, medico_id, mascota_id)>0)){
                      this.insert(currentTime, reg_time, motivo, diagnostico, medico_id, tratamiento_id, mascota_id);
                      return 1;
                }else{
                    return 0;
                }  
            } catch (ParseException ex) {
                ex.printStackTrace();
                return -1;
            }
        }else{
            return -1;
        }
    }
    public int modificarConsulta(){ throw new UnsupportedOperationException("No  implementado para este esquema");}
    
    public int eliminarConsulta(java.sql.Date fecha, int medico_id, int mascota_id){
        if(this.buscarConsulta(fecha, medico_id, mascota_id)>0){
            this.delete(fecha, medico_id, mascota_id);
            
            if(this.buscarConsulta(fecha, medico_id, mascota_id)>0){
                return -1;
            }else{
                return 1;
            }
            
        }else{
            return 0;
        }
    }
    
    public void insert(java.sql.Date fecha, java.sql.Time hora, String motivo, String diagnostico, int medico_id, int  tratamiento_id, int mascota_id){
        String seleccion = "{call insert_consulta('"+ 0 +"','"+ fecha +"','"+ hora +"','"+ motivo +"','"+ diagnostico +"','"+ medico_id +"','"+ tratamiento_id +"','"+ mascota_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public void update(){throw new UnsupportedOperationException("No implementado en este esquema");}
    
    public void delete(java.sql.Date fecha, int medico_id, int mascota_id){
        String seleccion = "{call delete_consulta('"+ fecha +"','"+ medico_id +"','"+ mascota_id +"')}";
        DataConexion.ejecutarprocedure(seleccion); 
    }
    
    public int buscarConsulta(java.sql.Date fecha, int medico_id, int mascota_id){
        String seleccion = "{call find_consulta('"+ fecha +"','"+ medico_id +"','"+ mascota_id +"')}";
        
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
