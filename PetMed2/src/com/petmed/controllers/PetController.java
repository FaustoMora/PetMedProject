/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.controllers;

import java.util.Date;

/**
 *
 * @author Ivan
 */
public class PetController {
    private int id;
    private Date birthDate;
    private String sexo;
    private String especie;
    private String raza;
    
    public PetController(){
        id =0;
        birthDate = new Date();
        sexo = new String();
        especie = new String();
        raza = new String();    
    }

    public PetController(int id, Date birthDate, String sexo, String especie, String raza) {
        this.id = id;
        this.birthDate = birthDate;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    
    
    
    
    
}
