/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.DoctorController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class DoctorDAO implements BaseDAO {
    private String query;

    @Override
    public void storage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void storage(String name, String phone){
        
        query ="call insert_medico(0,'" + name +"'," + phone +")";
        
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
    
    public void update(int id,String name, String phone) {
        query ="call update_medico("+id+",'" + name +"'," + phone +")";
        
        DataConection.ejecutarprocedure(query);  
    }

    /**
     *
     * @return
     */
    @Override
        public LinkedList getList() {
        query= "select * from medico;";
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new DoctorController(rs.getInt(1), rs.getString(2),rs.getInt(3)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        public LinkedList getList(String parameter) {
        query= "select * from medico where (medico.nombre like '%"+parameter+"%');";
//        query="{call search_cliente('" + parameter + "')}";
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new DoctorController(rs.getInt(1), rs.getString(2),rs.getInt(3)));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
      
    
}
