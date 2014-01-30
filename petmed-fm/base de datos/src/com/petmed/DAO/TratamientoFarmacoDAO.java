/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.DAO;

import com.petmed.models.DataConexion;
import java.sql.ResultSet;

/**
 *
 * @author Lost Legion
 */
public class TratamientoFarmacoDAO{
    
    public void insert(String trat_id, String farm_id){
        String seleccion = "{call insert_tratamiento_farmaco('"+ 0 +"','"+ trat_id +"','"+ farm_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public void update(){ throw new UnsupportedOperationException("Operacion no soportada para este esquema");}
    
    public void delete(String trat_id){
        String seleccion = "{call delete_tratamiento_farmaco('"+ trat_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public int buscarTratamientoFarmaco(String trat_id, String farm_id){
        try{
            String seleccion = "{call find_tratamiento_farmaco('"+ trat_id +"','"+ farm_id +"')}";
            ResultSet resul = DataConexion.ejecutarProcedureSelect(seleccion);

            if(resul.next()){
                return resul.getInt(1);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
