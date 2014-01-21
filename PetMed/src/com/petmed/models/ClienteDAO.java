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
import java.util.Date;

/**
 *
 * @author Ivan
 */
public class ClienteDAO implements BaseDAO{
    String connectionUrl="jdbc:mysql://localhost:3306/PetMed";
    public  Connection con=null;
    
    private void conexion(){
        
        
       
        try{
             System.out.println("conexion1");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(connectionUrl, "root", "root");
            System.out.println("conexion");
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void storage(String name,String direccion,int phone,Date date){
        conexion();
          
        
        Statement stm=null;
        ResultSet rs=null;
        //String sql="insert into Cliente(id,nombre,direccion,telefono,fecha_registro) values(null,\""+name+"\",\""+direccion+"\","+phone+",current_Date);";
        String sql="call nuevoCliente(\""+name+"\",\""+direccion+"\","+phone+",current_Date)";
        //String sql="select * from liente"
        try{
            
            
            stm= con.createStatement();
            stm.execute(sql);
                
//            while(rs.next()){
//                System.out.println(rs.getString(1)+"  "+rs.getString(2));
//            }
            
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
