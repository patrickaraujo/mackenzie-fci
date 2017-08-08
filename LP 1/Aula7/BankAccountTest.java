/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula7;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class BankAccountTest {
    
    public static void main(String[] args)throws IOException{
        Bank banco = new Bank("clientes.txt");
        Bank bancoS = new Bank("newSavingsClients.txt");
        
        banco.sort();
        banco.dump();
        bancoS.dumpAll();
        
        System.out.println("Entre com o número da conta que deseja obter os dados");
        Scanner all = new Scanner(System.in);
        int aC = all.nextInt();
        System.out.println(bancoS.find(aC));
    }
}
