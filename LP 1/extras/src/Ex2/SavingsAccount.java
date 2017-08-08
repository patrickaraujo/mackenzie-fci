/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 31470203
 */
public class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(int accountNumber, String password, String owner, double balance, double interestRate) {
        super(accountNumber, password, owner, (balance+((balance*interestRate)/100)));
        this.interestRate = interestRate;
    }
    
    public double getInterestRate(){
        return interestRate;
    }
    
}
