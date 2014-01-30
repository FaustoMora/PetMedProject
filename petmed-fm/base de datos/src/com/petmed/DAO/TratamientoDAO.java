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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lost Legion
 */
public class TratamientoDAO{
    
    public int eliminarTratamiento(String des){
       if(Validacion.validacionTexto(des)){
            int trat_id = new TratamientoDAO().buscarTratamiento(des);
            
            new TratamientoFarmacoDAO().delete(Integer.toString(trat_id));
            
            new TratamientoDAO().delete(des);
            
            
            if((new TratamientoDAO().buscarTratamiento(des))>0){
                return -1;
            }else{
               return 1; 
            }
        }else{
            return 0;
        }
    }
    
    public void insert(String descripcion){
        String seleccion = "{call insert_tratamiento('"+ 0 +"','"+ descripcion +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }

    public void delete(String descripcion){
        String seleccion = "{call delete_tratamiento('%"+ descripcion +"%')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public int buscarTratamiento(String descripcion){
        try {
            String seleccion = "{call find_tratamiento('%"+ descripcion +"%')}";
            ResultSet resultado = DataConexion.ejecutarProcedureSelect(seleccion);
            
            if(resultado.next()){
                return resultado.getInt(1);    
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
