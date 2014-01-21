/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.petmed.models;

import java.awt.List;

/**
 *
 * @author Ivan
 */
public interface BaseDAO {
    
    public void storage();
    public void load();
    public void update();
    public List getList();
    
    
}
