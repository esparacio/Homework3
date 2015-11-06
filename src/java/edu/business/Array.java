/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.business;

import java.util.ArrayList;

/**
 *
 * @author Elena
 */
public class Array {
    private ArrayList<Double> values;
    
    public Array(){
        this.values = new ArrayList<>();
    }
    
    public void setArray(ArrayList<Double> values){
        values = this.values;
    }
    
    public ArrayList getArray(){
        return values;
    }
            
         
    
}
