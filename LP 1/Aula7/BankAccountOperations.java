/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula7;

/**
 *
 * @author 41318862
 */
public interface BankAccountOperations {
    public void  withdraw(double value, int accountNumber, int numBank);
    public void  deposit(double value, int accountNumber, int numBank);
    public double  getBalance(int accountNumber, int numBank);
    
}
