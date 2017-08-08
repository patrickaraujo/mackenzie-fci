/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula2;

import static Aula1.UnionAndIntersection.generateVector;
import static Aula1.UnionAndIntersection.printVector;
import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class PiscinaeBaldes {
    
    public static int bubble(int[] array) {
        int cont = 0;
        for (int fixo = 0; fixo < array.length; fixo++)
            for (int i = 0; i < array.length-1; i++)
                if (array[i] > array[i+1]){
                    int aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                    cont++;
                }
        return cont;
    }
    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Entre o número");
        int y;
        do{
            y = entrada.nextInt();
        }while(y <= 0);
        
        int a[] = generateVector(y);
        System.out.println("Vetor");
        printVector(a);
        int x = bubble(a);
        if(x % 2 == 0)
            System.out.println("Carlos");
        else
            System.out.println("Marcelo");
            
    }
}
