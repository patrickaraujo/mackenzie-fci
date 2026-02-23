/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;
 
/**
 * Classe responsável por implementar o algoritmo Merge Sort
 * em sua abordagem Iterativa (Bottom-Up), sem o uso de recursividade.
 * @author 41318862
 */

public class MergeSortInterativo {

    /**
     * Intercala (faz o merge de) dois subvetores adjacentes que já estão ordenados.
     * O primeiro subvetor vai de v[inicio] até v[meio-1].
     * O segundo subvetor vai de v[meio] até v[fim-1].
     */
    public static void intercalacao(int[] v, int inicio, int meio, int fim) {
        int[] vetorAuxiliar = new int[fim - inicio];
        int i = inicio;
        int j = meio;
        int k = 0;

        // Compara e intercala os elementos dos dois subvetores em ordem crescente
        while (i < meio && j < fim) {
            if (v[i] <= v[j]) {
                vetorAuxiliar[k] = v[i];
                i++;
            } else {
                vetorAuxiliar[k] = v[j];
                j++;
            }
            k++;
        }

        // Copia o restante da primeira metade (caso o segundo subvetor acabe primeiro)
        while (i < meio) { 
            vetorAuxiliar[k] = v[i];
            k++;
            i++;
        }

        // Copia o restante da segunda metade (caso o primeiro subvetor acabe primeiro)
        while (j < fim) { 
            vetorAuxiliar[k] = v[j];
            k++;
            j++;
        }

        // Transfere os elementos do vetor auxiliar (já ordenados) de volta para o vetor original
        for (i = 0; i < k; i++) {
            v[inicio + i] = vetorAuxiliar[i];
        }
    }

    /**
     * Ordena o vetor utilizando a abordagem iterativa do Merge Sort.
     */
    public static void mergeSort(int[] v) {
        int inicio, fim;
        int tamanhoSubvetor = 1;

        // Vai dobrando o tamanho dos subvetores a cada iteração (1, 2, 4, 8...)
        while (tamanhoSubvetor < v.length) {
            inicio = 0;
            
            // Percorre o vetor agrupando os subvetores aos pares
            while (inicio + tamanhoSubvetor < v.length) {
                fim = inicio + 2 * tamanhoSubvetor;
                
                // Evita estourar o limite do vetor caso o tamanho não seja potência de 2
                if (fim > v.length) {
                    fim = v.length;
                }
                
                intercalacao(v, inicio, inicio + tamanhoSubvetor, fim);
                
                // Avança para o próximo par de subvetores
                inicio = inicio + 2 * tamanhoSubvetor;
            }
            tamanhoSubvetor = tamanhoSubvetor * 2;
        }
    }

    /**
     * Gera um vetor de tamanho n preenchido com números aleatórios entre 0 e 299.
     */
    public static int[] generateVector(int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = (int) (Math.random() * 300);
        }
        return v;
    }

    /**
     * Imprime os elementos do vetor de forma legível.
     */
    public static void printVector(int[] v) {
        for (int i = 0; i < v.length; i++) {
            if (i == (v.length) - 2) {
                System.out.print("Posição " + i + ": (" + v[i] + ") e ");
            } else if (i != (v.length) - 1) {
                System.out.print("Posição " + i + ": (" + v[i] + "), ");
            } else {
                System.out.print("Posição " + i + ": (" + v[i] + ")");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] vetor = generateVector(10);
        
        System.out.println("Vetor original desordenado:");
        printVector(vetor);
        
        mergeSort(vetor);
        
        System.out.println("Vetor ordenado:");
        printVector(vetor);
    }
}
