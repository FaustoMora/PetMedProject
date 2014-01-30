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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lost Legion
 */
public class MedicoDAO {
    
    public void ingresarMedico(String nom, String apell, String tlf){
        if(Validacion.validacionTexto(nom) && Validacion.validacionTexto(apell) && Validacion.validacionNum(tlf)){
                String medico = nom + " " + apell;  
		if(!(this.buscarMedico(medico)>0)){
        
                        this.insert(medico, tlf);
                        JOptionPane.showMessageDialog(null,"Medico ingresado con exito");
                        
                }else{
                    JOptionPane.showMessageDialog(null,"Medico ya existente");
                }
			
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");
            }
    }
    public void modificarMedico(String nom, String apell, String tlf){
        if(Validacion.validacionTexto(nom) && Validacion.validacionTexto(apell) && Validacion.validacionNum(tlf)){
                String medico = nom + " " + apell;  
		if((this.buscarMedico(medico)>0)){
                    
                        this.update(medico, tlf);
                        JOptionPane.showMessageDialog(null,"Cambios realizado con exito");
                        
                }else{
                    JOptionPane.showMessageDialog(null,"Medico no existente");
                }
			
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");
            }
    }
    public void eliminarMedico(String nom, String apell){
        if(Validacion.validacionTexto(nom) && Validacion.validacionTexto(apell)){
            String medico = nom + " " + apell;  
            
		this.delete(medico);
                if(this.buscarMedico(medico)==0){
                    JOptionPane.showMessageDialog(null, "Registro eliminado con existo");
                }else{
                    JOptionPane.showMessageDialog(null, "Error en la eliminacion");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Error en dato");
            }
    }
    
    public void insert(String medico, String tlf){
        String seleccion = "{call insert_medico('"+ 0 +"','"+ medico +"','"+ tlf +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void update(String medico, String tlf){
        String seleccion = "{call update_medico('"+ medico +"','"+ tlf +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    public void delete(String medico){
        String seleccion = "{call delete_medico('"+ medico +"')}";
        DataConexion.ejecutarprocedure(seleccion);
    }
    
    public int buscarMedico(String medico){
        String seleccion = "{call find_medico('" + medico +"')}";
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
