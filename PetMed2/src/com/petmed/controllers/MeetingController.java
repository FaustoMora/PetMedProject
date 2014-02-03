/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.controllers;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author sjronqui
 */
public class MeetingController {
    private int id;
    private Date date;
    private Time hora;
    private int cliente_id;

    public MeetingController(int id, Date date, Time hora, int cliente_id) {
        this.id = id;
        this.date = date;
        this.hora = hora;
        this.cliente_id = cliente_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    
    
    
}
