/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import com.petmed.controllers.BasicController;
import java.awt.List;
import java.util.LinkedList;

/**
 *
 * @author Ivan
 */
public interface BaseDAO {
    
    public void storage();
    public BasicController load();
    public void update();
    public LinkedList getList();
    public void delete();
    
    
}
