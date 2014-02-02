/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.PetController;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sjronqui
 */
public class PetDAO implements BaseDAO {
    
private String query;

    @Override
    public void storage() {
  
    }

    @Override
    public BasicController load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(int id,String name, String esp,String raza,Date birth,char sexo) {
        query ="call update_mascota("+id+",'" + name +"','"+esp+"','" + raza +"','" + new java.sql.Date(birth.getTime()) +"','"+sexo+"')";
        
        DataConection.ejecutarprocedure(query);  
    }

    
    @Override
        public LinkedList getList() {
        /*query= "select * from mascota;";
        query="{call search_mascota(null)}";
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new PetController(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),  rs.getDate(5), rs.getString(6)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return null;
    }
        
        public LinkedList getList(int parameter) {
        query="{call search_mascota(" + parameter + ")}";
        
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new PetController(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),  rs.getDate(5), rs.getString(6)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void storage(String nombre, String esp , String raza ,Date birth , char sexo, int id_dueno){
        query ="call insert_mascota(0,'" + nombre +"','"+esp+"','" + raza +"','" + new java.sql.Date(birth.getTime()) +"','"+sexo+"',"+id_dueno+")";
        
        DataConection.ejecutarprocedure(query);        
    }
    
   
}
