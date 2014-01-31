package com.petmed.models;

public class Validacion {

	public static boolean validacionTexto(String texto){
            boolean a = texto.matches("[a-zA-Z ]{3,}");
            return texto.matches("[a-zA-Z ]{3,}");

	}
	
	public static boolean validacionNum(String texto){
            return texto.matches("[0-9]{7}|[0-9]{10}");
	}
	
	public static boolean validacionDir(String texto){
            return texto.matches("[a-zA-Z]+[a-zA-Z_0-9].*{3,}");
	}
        
        public static boolean validacionNumero(String texto){
            return texto.matches("\\d.*{1,}");
        }
        
        public static boolean validacionCliente(String nombre, String apellido, String dir, String tlf){
            return(Validacion.validacionTexto(nombre) && Validacion.validacionTexto(apellido) && Validacion.validacionDir(dir) && validacionNum(tlf)); 
        }
        
	

}
