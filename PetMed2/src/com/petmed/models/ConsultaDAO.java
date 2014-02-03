/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.ConsultaController;
import com.petmed.controllers.PetController;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sjronqui
 */
public class ConsultaDAO implements BaseDAO {
    
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
    
    public void update(int id,String diagnos, int trat_id) {
        query ="call update_consulta("+ id +",'"+ diagnos+"' , "+trat_id+ ")";
        
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
        query="{call search_consulta("+parameter+")}";
        
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new ConsultaController(rs.getInt(1), rs.getDate(2), rs.getTime(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void storage(int id_mascota, int id_medico, String motivo, String diagnostico, int id_tratamiento, Date fecha, String hora){
        query ="call insert_consulta(0,'"+new java.sql.Date(fecha.getTime())+"','"+hora+"','"+motivo+"','"+diagnostico+"',"+id_medico+","+id_tratamiento+","+id_mascota+")";
        
        DataConection.ejecutarprocedure(query);        
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
