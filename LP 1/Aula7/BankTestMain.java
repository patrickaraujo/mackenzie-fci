/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula7;

/**
 *
 * @author 31438938
 */
public class BankTestMain {
    public static void main(String[] args) {
        Bank b = new Bank();
        BankAccount c1 = new BankAccount(100, "123", "Ana Cris", 1500.00);
        b.addAccount(c1);
        b.addAccount(new BankAccount(112, "456", "maria Antonia", 800.00));
    }
}
