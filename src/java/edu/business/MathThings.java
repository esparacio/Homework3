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
public class MathThings {
    private int numYears;
    private double investAmount;
    private double yearlyRate;
    private double futureValue;
    private ArrayList<Double> values;
    
    public MathThings (int numYears, Double investAmount, Double yearlyRate){
        this.numYears = numYears;
        this.investAmount = investAmount;
        this.yearlyRate = yearlyRate;
        values = new ArrayList<>(numYears);
    }
    
    public void setNumYears(int numYears){
        this.numYears = numYears;
    }
    
    public void setInvestAmount(Double investAmount){
        this.investAmount = investAmount;
    }
    
    public void setYearlyRate(Double yearlyRate){
        this.yearlyRate = yearlyRate;
    }
    
    public double doMath(){
        double futureValue = investAmount;

        for(int i=0;i<numYears; i++){
                futureValue = investAmount+(investAmount)*((yearlyRate)/100);
                investAmount =futureValue;
                values.add(futureValue);
        }
        return futureValue;
    }
    
    public ArrayList<Double> getArray(){
        return this.values;
    }
    
    
    
    
}
