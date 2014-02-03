/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.MeetingController;
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
public class MeetingDAO implements BaseDAO {
    private String query;

    @Override
    public void storage() {
  
    }
    
    
    public void storage( Date date, String hora , int id){
        query ="call insert_cita(0,'" + new java.sql.Date(date.getTime()) +"','"+hora+"',"+id+")";
        
        DataConection.ejecutarprocedure(query);        
    }

    @Override
    public BasicController load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void update(Date date, String hora, int id) {
        query ="call update_cita('" + new java.sql.Date(date.getTime()) +"','"+hora+"',"+id+")";
        
        DataConection.ejecutarprocedure(query);  
    }

    
    @Override
        public LinkedList getList() {
         return null;
    }
        
        public LinkedList getList(int parameter) {
        query="{call search_cita(" + parameter + ")}";
        
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new MeetingController(rs.getInt(1), rs.getDate(2), rs.getTime(3),rs.getInt(4)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
