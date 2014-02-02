/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.controllers;

/**
 *
 * @author sjronqui
 */
public class DoctorController implements BasicController{
    private int id;
    private String name;
    private int phone;
    
    public DoctorController(){
        id=0;
        name=new String();
        phone=0;
    }
    
    public DoctorController(int id, String name, int phone){
        this.id=id;
        this.name=name;
        this.phone=phone;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
    
}
