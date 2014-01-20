/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Ivan
 */
public class ClienteDAO implements BaseDAO{
    private String connection;
    
    private static void Conexion(){
        
        String connectionUrl="jdbc:mysql://localhost:3306/test";
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql=";";
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(connectionUrl, "root", "root");
            
            stm= con.createStatement();
            rs=stm.executeQuery(sql);
                System.out.println("    Id         Nombre");
            while(rs.next()){
                System.out.println(rs.getString(1)+"  "+rs.getString(2));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
            
            
    
    


    @Override
    public void storage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
