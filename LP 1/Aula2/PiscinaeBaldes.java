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
 * Jogo que determina um vencedor (Carlos ou Marcelo) com base no 
 * número de trocas necessárias para ordenar um vetor gerado aleatoriamente.
 * @author Patrick
 */

public class PiscinaeBaldes {
    
    /**
     * Aplica o algoritmo Bubble Sort no array e conta o número de trocas.
     * * @param array O vetor desordenado.
     * @return O número total de inversões (trocas) realizadas.
     */
    public static int bubble(int[] array) {
        int cont = 0;
        for (int fixo = 0; fixo < array.length; fixo++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    cont++;
                }
            }
        }
        return cont;
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Entre o número de elementos do vetor:");
        int y;
        do {
            y = entrada.nextInt();
        } while (y <= 0);
        
        int a[] = generateVector(y);
        System.out.println("Vetor gerado:");
        printVector(a);
        
        int x = bubble(a);
        
        // Determina o vencedor baseado na paridade das trocas
        if (x % 2 == 0) {
            System.out.println("Carlos (Número de trocas par: " + x + ")");
        } else {
            System.out.println("Marcelo (Número de trocas ímpar: " + x + ")");
        }
        
        entrada.close();
    }
}
