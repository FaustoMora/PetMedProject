/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.ClientController;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class ClientDAO implements BaseDAO {
    private String query;

    @Override
    public void storage() {
        query ="call insert_client('Rene Balda','VM rendon',09992212,2012-02-02)";
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

    /**
     *
     * @return
     */
    @Override
        public LinkedList getList() {
        query= "select * from cliente;";
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new ClientController(rs.getInt(1), rs.getString(2), rs.getDate(5), rs.getInt(4), rs.getString(3)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void storage(String name, String surname,String direccion,String phone){
        
        query ="call insert_client('" + name +" "+surname+"','" + direccion +"'," + phone +",curtime())";
        
        DataConection.ejecutarprocedure(query);        
    }

    
    
}
