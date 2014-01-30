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
import javax.swing.JOptionPane;

/**
 *
 * @author Lost Legion
 */
public class FarmacoDAO {

    public void ingresarFarmaco(String nombre, String presen, String cantidad, String concen, String concen2){
        if(Validacion.validacionTexto(nombre) && Validacion.validacionNumero(cantidad) && (presen!="")){
            if(!(this.buscarFarmaco(nombre, presen)>0)){
                String dosis = cantidad + " " + concen + "/" + concen2;
                this.insert(nombre,presen,dosis);
                JOptionPane.showMessageDialog(null, "Farmaco ingresado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "Este farmaco ya esta en la base");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error Dato");
        }
    }
    
    public void modificarFarmaco(String nombre, String presen, String cantidad, String concen, String concen2){
        if(Validacion.validacionTexto(nombre) && Validacion.validacionNumero(cantidad) && (presen!="")){
           if((this.buscarFarmaco(nombre, presen)>0)){
               String dosis = cantidad + " " + concen + "/" + concen2;
               this.update(nombre,presen,dosis);
               JOptionPane.showMessageDialog(null, "Farmaco modificado con exito");
           }else{
               JOptionPane.showMessageDialog(null, "Farmaco no exite");
           } 
        }else{
            JOptionPane.showMessageDialog(null, "Error Dato");
        }
    }
    
    public void eliminarFarmaco(String nom, String pres) {
        if(Validacion.validacionTexto(nom) && (pres!="")){
            this.delete(nom, pres);
            
            if(!(this.buscarFarmaco(nom, pres)>0)){
                JOptionPane.showMessageDialog(null, "Farmaco: " + nom + " de presentacion:" + pres + " Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar Farmaco");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error Dato");
        }
    }
    
    
    public void insert(String nombre, String presen, String dosis){
        String seleccion = "{call insert_farmaco('"+ 0 +"','"+ nombre +"','"+ presen +"','"+ dosis +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public void update(String nombre, String presen, String dosis){
        String seleccion = "{call update_farmaco('"+ nombre +"','"+ presen +"','"+ dosis +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public void delete(String nombre, String presen){
        String seleccion = "{call delete_farmaco('"+ nombre +"','"+ presen +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    
    public int buscarFarmaco(String nombre, String presen){
        String seleccion = "{call find_farmaco('"+ nombre +"','"+ presen +"')}";
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
