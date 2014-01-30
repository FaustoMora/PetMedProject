/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petmed.DAO;

import com.petmed.models.DataConexion;
import com.petmed.models.Validacion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class SintomaDAO {
    public int ingresarSintoma(String nombre){
        if(Validacion.validacionTexto(nombre)){
            if(!(this.buscarSintoma(nombre)>0)){
                
                this.insert(nombre);
                return 1;
                
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }
    
    public void modificarSintoma(){ throw new UnsupportedOperationException("Funcion No valida para este esquema");}
    
    public int eliminarSintoma(String nombre){
        if(Validacion.validacionTexto(nombre)){
        
            this.delete(nombre);
            if(this.buscarSintoma(nombre)>0){
                return -1;
            }else{
                return 1;
            }
        }else{
            return 0;
        }
    }
    
    
    public void insert(String nombre){
        String seleccion = "{call insert_sintoma('"+ 0 +"','"+ nombre +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public void update(){ throw new UnsupportedOperationException("Funcion No valida para este esquema");}
    
    public void delete(String nombre){
        String seleccion = "{call delete_sintoma('"+ nombre +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public int buscarSintoma(String nombre){
        try {
            String seleccion = "{call find_sintoma('"+ nombre +"')}";
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
