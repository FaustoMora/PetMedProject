package com.petmed.models;

public class Validacion {

	public static boolean validacionTexto(String texto){
		if(texto.matches("[a-zA-Z]{3,}")){
			return true;
		}
		return false;
		
	}
	
	public static boolean validacionNum(String texto){
		if(texto.matches("[0-9]{7}|[0-9]{10}")){
			return true;
		}
		return false;
		
	}
	
	public static boolean validacionDir(String texto){
		if(texto.matches("[a-zA-Z]+[a-zA-Z_0-9].*{3,}")){
			return true;
		}
		return false;
	}
        
        public static boolean validacionCliente(String nombre, String apellido, String dir, String tlf){
        
            return(Validacion.validacionTexto(nombre) && Validacion.validacionTexto(apellido) && Validacion.validacionDir(dir) && validacionNum(tlf)); 
        }
	

}
