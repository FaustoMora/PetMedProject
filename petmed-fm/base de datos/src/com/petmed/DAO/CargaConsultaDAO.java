/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.DAO;

import com.petmed.models.DataConexion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Lost Legion
 */
public class CargaConsultaDAO {

    
    public CargaConsultaDAO(){super();}
    
    
    public ResultSet cargarSintoma(){
        try{
            String select_sint = "select descripcion from sintoma;";
            return DataConexion.ejecutarProcedureSelect(select_sint);

        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
}
