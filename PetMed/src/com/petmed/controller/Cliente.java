/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.controller;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Ivan
 */
public class Cliente extends Persona {
    private int id;
    private Date regiteredDate;
    private LinkedList<Mascota> mascotas;
    private LinkedList<Cita> cita;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegiteredDate() {
        return regiteredDate;
    }

    public void setRegiteredDate(Date regiteredDate) {
        this.regiteredDate = regiteredDate;
    }

    public LinkedList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(LinkedList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public LinkedList<Cita> getCita() {
        return cita;
    }

    public void setCita(LinkedList<Cita> cita) {
        this.cita = cita;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
    
          
    
    
}
