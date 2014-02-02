
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import com.petmed.controllers.ClientController;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        query ="call insert_client(0,'Rene','Balda','VM rendon',09992212,2012-02-02)";
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
    
    public void update(int id,String name, String surname,String direccion,String phone) {
        query ="call update_cliente("+id+",'" + name +"','"+surname+"','" + direccion +"'," + phone +")";
        
        DataConection.ejecutarprocedure(query);  
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
                list.add(new ClientController(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getDate(6), rs.getInt(5), rs.getString(4)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
        public LinkedList getList(String parameter) {
        query= "select * from cliente where (cliente.nombre like '%"+parameter+"%') or (cliente.apellido like '%"+parameter+"%');";
//        query="{call search_cliente('" + parameter + "')}";
        ResultSet rs = DataConection.ejecutarProcedureSelect(query);
        LinkedList list= new LinkedList<BasicController>();
        try {
            while(rs.next()){
                list.add(new ClientController(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getDate(6), rs.getInt(5), rs.getString(4)));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void storage(String name, String surname,String direccion,String phone){
        
        query ="call insert_cliente('" + name +"','"+surname+"','" + direccion +"'," + phone +")";
        
        DataConection.ejecutarprocedure(query);        
    }
    

    

    
    
}
