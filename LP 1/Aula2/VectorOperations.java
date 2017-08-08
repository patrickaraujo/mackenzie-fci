/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula2;

import static Aula1.UnionAndIntersection.generateVector;
import static Aula1.UnionAndIntersection.printVector;

/**
 *
 * @author 41318862
 */
public class VectorOperations {
    public static int linearSearch (int v[], int e){
        for (int i = 0; i < v.length; i++)
            if(v[i] == e)
                return i;
        return -1;
    }
    
    public static int linearSearchLast (int v[], int e){
        for (int i = (v.length-1); i >= 0; i--)
            if (v[i] == e)
                return i;
        return -1;
    }
    
    private static int binarySearch(int[] array, int valor) {
        int inicio = 0;
        int fim = array.length-1;
        
        while(inicio <= fim) {
            int meio = (inicio+fim)/2;
            
            if(array[meio] == valor)
                return meio;
            
            if(valor > array[meio])
            inicio = meio+1;
            
            else
                fim = meio-1;

        }
        return -1;
    }
    
    public static void bubbleSort(int v[]){
        for(int i = 0; i < (v.length - 1); i++)
            for(int j = 0; j < (v.length - (1 + i)); j++)
                if(v[j] > v [j + 1]){
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
    }
    
    public static void main(String[] args) {
        System.out.println("b)");
        int A[] = generateVector(10);
        System.out.println("Vetor");
        printVector(A);
        bubbleSort(A);
        System.out.println("Vetor ordenado");
        printVector(A);
        int res = linearSearchLast(A, 2);
        if(res != -1)
            System.out.println("Última ocorrência\nPosição: "+res);
        else
            System.out.println("Não achou 2 no vetor. :(");
        
        System.out.println("\n\na)");
        int B[] = {8, 7, 4, 21, 54, 28, 4, 89, 8};
        printVector(B);
        res = linearSearchLast(B, 4);
        if(res != -1)
            System.out.println("Última ocorrência\nPosição: "+res);
        else
            System.out.println("Não achou 4 no vetor. :(");
    }
}
