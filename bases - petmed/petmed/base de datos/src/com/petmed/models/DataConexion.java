package com.petmed.models;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public  class DataConexion{

	private static Connection con;
    private static DataConexion INSTANCE = null;
    static String connectionUrl = "jdbc:mysql://localhost:3306/petmed";

    public DataConexion(){
    	
    }
	

	public static void performConnection() {
	    Statement stm=null;
	    ResultSet rs=null;
	    String sql="select * from cliente;";
		
		String user = "root";
		String pass = "root";
		  try{
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            con = DriverManager.getConnection(connectionUrl, user,pass);
	            JOptionPane.showMessageDialog(null, "Conexion Establecida");
	            	        
	        }catch(Exception e){
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error in Conexion");
	        }
		
	}
	

	private synchronized static void createInstance() {
	        if (INSTANCE == null) { 
	            INSTANCE = new DataConexion();
	            performConnection();
	        }
	    }
	 

	public static DataConexion getInstance() {
	        if (INSTANCE == null) createInstance();
	        return INSTANCE;
	    }
	

	public void closeConnection() {
		try {
			con.close();
		}catch (Exception e) {
			System.out.println("Error al terminar conexion");
		}
	}
	
	public static Connection  getCon(){
		return con;
	}
	
    public static boolean ejecutarprocedureBool(String sql) {
    	
        try {

            Statement sentencia = con.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            
            if(resultado.next()){
            	int b =resultado.getInt(1); 
            	return resultado.getInt(1)>=1;
           
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
 
        return false;
    }
    
    public static void ejecutarprocedure(String sql) {
        try {

            Statement sentencia = con.prepareCall(sql);
            sentencia.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();

        }


    }
    
    public static ResultSet ejecutarProcedureSelect(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = con.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return resultado;
    }
	

}
