/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula6;

import Aula5.BankAccount;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31470203
 */
public class BankAccountTest {
    
    @Test
    public void withDrawnTest(){
        double saldoInicial = Math.random()*1_000_000_000;
        BankAccount conta = new BankAccount(saldoInicial);
        double saque = Math.random()*1000;
        conta.withDraw(saque);
        double saldoEsperado = saldoInicial - saque;
        double saldoObtido = conta.getBalance();
        Assert.assertEquals(saldoEsperado, saldoObtido, 0.001);
    }
    
    @Test
    public void depositTest(){
        BankAccount conta = new BankAccount(500.0);
        conta.deposit(300.0);
        Assert.assertEquals(800.0, conta.getBalance(), 0.01);
    }
    
}
