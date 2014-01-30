/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.controllers;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Ivan
 */
public class ClientController {
    private int id;
    private String name;
    private String surname;
    private Date registerDate;
    private int phone;
    private String address;
    private LinkedList<PetController> pets;

    public ClientController() {
        id =0;
        name= new String();
        surname = new String();
        registerDate =new Date();
        phone = 0;
        address = new String();
        pets = new LinkedList<PetController>();
    }

    public ClientController(int id, String name, String surname, Date registerDate, int phone, String address, LinkedList<PetController> pets) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.registerDate = registerDate;
        this.phone = phone;
        this.address = address;
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LinkedList<PetController> getPets() {
        return pets;
    }

    public void setPets(LinkedList<PetController> pets) {
        this.pets = pets;
    }
    
    
    
    

    
    
    
    
    
}
