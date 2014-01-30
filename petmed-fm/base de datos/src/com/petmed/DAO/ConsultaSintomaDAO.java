/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.DAO;

import com.petmed.models.DataConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lost Legion
 */
public class ConsultaSintomaDAO {
    
    public int ingresarConsultaSintoma(int id_consul, ArrayList id_sint){
        int id_aux=0;
        for(int i=0; i< id_sint.size();i++){
            id_aux = Integer.parseInt(id_sint.get(i).toString());
            if(!(this.buscarConsultaSintoma(id_consul,id_aux)>0)){
                
                this.insert(id_consul, id_aux);
                
            }else{
                return 0;
            }
        }
        return 1;
    }
        
    
    public void insert(int consul_id, int sint_id){
        String seleccion = "{call insert_consulta_sintoma('"+ 0 +"','"+ consul_id +"','"+ sint_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void update(){ throw new UnsupportedOperationException("Operacion no soportado para este esquema");}
    
    public void delete(int consul_id, int sint_id){
        String seleccion = "{call delete_consulta_sintoma('"+ consul_id +"','"+ sint_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public int buscarConsultaSintoma(int consul_id, int sint_id){
        try {
            String seleccion = "{call find_consulta_sintoma('"+ consul_id +"','"+ sint_id +"')}";
            ResultSet resul = DataConexion.ejecutarProcedureSelect(seleccion);
            
            if(resul.next()){
                return resul.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();        
        }
        return 0;
    }
    
}
