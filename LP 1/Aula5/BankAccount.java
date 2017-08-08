/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula5;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Patrick
 */
public class BankAccount {

	private static int lastAccountNumber = 1000;	// Último número utilizado de conta

	private String name;
        
        private String password = setPassword();
        
        private int accountNumber;  // número da conta

	private double balance;     // saldo da conta

	public BankAccount() {

		// Constrói uma conta bancaria com saldo zero

		accountNumber=lastAccountNumber++;

		balance = 0;

	}

	public BankAccount (double balance) {

		// Constrói uma conta bancária com um determinado saldo inicial

		accountNumber=lastAccountNumber++;

		this.balance = balance;

	}
        
        public BankAccount (String name, double balance) {

		// Constrói uma conta bancária com um determinado saldo inicial

		accountNumber=lastAccountNumber++;
                this.name = name;
		this.balance = balance;
	}
        
	public void deposit(double amount) {

		// Deposita valor na conta bancária

		double newBalance = balance + amount;

		balance = newBalance;

	}

	public void withDraw(double amount) {

		// Retira valor da conta bancária

		double newBalance = balance - amount;

		balance = newBalance;

	}

	public String getCliente(){
            return name;
        }
        
        public String getPassword(){
            return password;
        }
        
        public String setPassword(){
            char pass [] = new char [3];
            int passWord [] = new int [4];
            Random generator = new Random();
            for (int x = 0; x < 3; x++)
                pass [x] = ((char) (generator.nextInt(25) + 97));
            for(int y = 0; y < passWord.length; y++)
                passWord [y] = ((int) (Math.random() * 10));
            String a = String.valueOf(pass);
            String b = Arrays.toString(passWord);
            String replace = b.replace(", ", "");
            String replace2 = replace.replace("[", "");
            String replace3 = replace2.replace("]", "");
            return a+replace3;
        }
        
        
        
        public double getBalance() {

		// Consulta o saldo da conta bancária

		return balance;

	}

	public int getAccountNumber(){

		// Consulta o número da conta bancária

		return accountNumber;

	}

}
