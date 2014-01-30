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
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author Lost Legion
 */
public class FisiologiaDAO {
    
    public int insertarFisiologia(String temperatura, String peso, Date fecha, int id_mascota){
        try{
        if(Validacion.validacionNumero(temperatura) && Validacion.validacionNumero(peso)){
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(fecha);
            java.sql.Date currentTime = new java.sql.Date(sdf.parse(date).getTime());
            
            if(!(this.buscarFisiologia(currentTime, id_mascota)>0)){
                this.insert(Integer.parseInt(temperatura),Integer.parseInt(peso),currentTime,id_mascota);
                return 1;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
    }
    public int modificarFisiologia(){
        return 0;
    }
    public int eliminarFisiologia(java.sql.Date fecha, String dueño, String mascota){
        if(Validacion.validacionTexto(dueño) && Validacion.validacionTexto(mascota)){
            int dueño_id = new ClienteDAO().buscarCliente(dueño);
            int masco_id = new MascotaDAO().buscarMascota(mascota, dueño_id);
            
            if((dueño_id >0) && (masco_id>0)){
                this.delete(fecha, masco_id);
                
                if(this.buscarFisiologia(fecha, masco_id)>0){
                    return -1;
                }else{
                   return 1; 
                }
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }
    
    
    public void insert(int temperatura, int peso, java.sql.Date fecha, int mascota_id){
        String seleccion = "{call insert_fisiologia('"+ 0 +"','"+ temperatura +"','"+ peso +"','"+ fecha +"','"+ mascota_id +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void update(){ throw new UnsupportedOperationException("Opcion no soportada para este esquema");}
    
    public void delete(java.sql.Date fecha, int mascota_id){
       String seleccion = "{call delete_fisiologia('"+ mascota_id +"','"+ fecha +"')}";
       DataConexion.ejecutarprocedure(seleccion);
   }
    
    public int buscarFisiologia(Date fecha, int id_mascota){
        String seleccion = "{call find_fisiologia('"+ id_mascota +"','"+ fecha +"')}";
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
