/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 *
 * @author Elena
 */
public class User implements Serializable {
    private double investAmount;
    private double yearlyRate;
    private int numYears;
    private double futureValue;

    public User() {
        investAmount = 0;
        yearlyRate = 0;
        numYears = 0;
        futureValue= 0;
    }

    public User(double investAmount, double yearlyRate, int numYears, double futureValue) {
        this.investAmount = investAmount;
        this.yearlyRate = yearlyRate;
        this.numYears = numYears;
        this.futureValue = futureValue;
    }

    public double getInvestAmount() {
        return investAmount;
    }

    public void setInvestAmount(double investAmount) {
        this.investAmount = investAmount;
    }

    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }

    public int getNumYears() {
        return numYears;
    }

    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }
    
    public void setFutureValue(double futureValue){
        this.futureValue = futureValue;
    }
    
     public double getFutureValue(){
        return futureValue;
    }
     
     public String getIACurrency(){
         NumberFormat currency = NumberFormat.getCurrencyInstance();
         return currency.format(investAmount);
     }
     
      
       public String getFVCurrency(){
         NumberFormat currency = NumberFormat.getCurrencyInstance();
         return currency.format(futureValue);
     }
       
    
}
