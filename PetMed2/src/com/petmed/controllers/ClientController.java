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
public class ClientController implements BasicController {
    private int id;
    private String name;
    private String lname;
    private java.sql.Date registerDate;
    private int phone;
    private String address;
    private LinkedList<PetController> pets;

    public ClientController() {
        id =0;
        name= new String();
        lname=new String();
        registerDate =new java.sql.Date(0);
        phone = 0;
        address = new String();
        pets = new LinkedList<PetController>();
    }

    public ClientController(int id, String name, String lname,java.sql.Date registerDate, int phone, String address, LinkedList<PetController> pets) {
        this.id = id;
        this.name = name;
        this.lname=lname;
        this.registerDate = registerDate;
        this.phone = phone;
        this.address = address;
        this.pets = pets;
    }
    
    public ClientController(int id, String name, String lname, java.sql.Date registerDate, int phone, String address) {
        this.id = id;
        this.name = name;
        this.lname=lname;
        this.registerDate = registerDate;
        this.phone = phone;
        this.address = address;
        
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
   

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(java.sql.Date registerDate) {
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
