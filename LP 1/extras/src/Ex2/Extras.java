/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class Extras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Bank banco = new Bank("newSavingsClients.txt");
        
        banco.sortBalance();
        banco.dump();
        
        System.out.println("Entre com o número da conta que deseja obter os dados");
        Scanner all = new Scanner(System.in);
        int aC = all.nextInt();
        System.out.println(banco.find(aC));
    }
    
}
