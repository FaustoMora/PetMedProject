/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.DAO;

import com.petmed.models.Validacion;
import javax.swing.JOptionPane;

/**
 *
 * @author Lost Legion
 */
public class DatosMedicoDAO {
    //clase intemediara entre tratamientoDAO y TratamientoFarmacoDAO
    //seran funciones int q devuelven 1,0,-1
    // 1 - cuando el ingreso fue exitos
    // 0 - cuando uno de los  ingreso ya existe (exepto farmaco)
    // -1 - cuando los datos no son correctos o hubo algun error
    
    public int ingresarDatosMedico(String des,String nombre,String presn){
        if(Validacion.validacionTexto(des) && Validacion.validacionTexto(nombre)){
            int trat_id = new TratamientoDAO().buscarTratamiento(des);
            int farm_id = new FarmacoDAO().buscarFarmaco(nombre, presn);
            int trat_farm = new TratamientoFarmacoDAO().buscarTratamientoFarmaco(Integer.toString(trat_id), Integer.toString(farm_id));
            
            if((farm_id>0)&&(!(trat_id>0))&&(!(trat_farm>0))){
                
                new TratamientoDAO().insert(des);
                
                int trat_idX=new TratamientoDAO().buscarTratamiento(des);
                new TratamientoFarmacoDAO().insert(Integer.toString(trat_idX), Integer.toString(farm_id));
                return 1;
                
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }
    
    //metodo aun no soportado
    public int modificarDatosMedico(){
        return 0;
    }
    
    public int eliminarDatosMedico(String des, String sintoma){
        if(des!="" && sintoma==""){
            return new TratamientoDAO().eliminarTratamiento(des);
        }
        if(des=="" && sintoma!=""){
            return new SintomaDAO().eliminarSintoma(sintoma);
        }
        
        return (new TratamientoDAO().eliminarTratamiento(des) + new SintomaDAO().eliminarSintoma(sintoma));
    }
    
    
}
