/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;
 
/**
 *
 * @author 41318862
 */
public class MergeSortInterativo {

    public static void intercalacao(int v[], int ini, int meio, int fim) {
        int[] w = new int[fim - ini];
        int i = ini;
        int j = meio;
        int k = 0;
        while (i < meio && j < fim) {
            if (v[i] <= v[j]) {
                w[k] = v[i];
                k++;
                i++;
            } else {
                w[k] = v[j];
                k++;
                j++;
            }
        }
        while (i < meio) { //Copia restante da primeira metade
            w[k] = v[i];
            k++;
            i++;
        }
        while (j < fim) { //Copia restante da segunda metade
            w[k] = v[j];
            k++;
            j++;
        }

        i = ini;
        // Copia os elementos levados para w de volta para o vetor v
        while (i < fim) {
            v[i] = w[i - ini];
            i++;
        }

    }

    public static void mergeSort(int v[]) {
        int ini, fim;
        int i = 1;

        while (i < v.length) {
            ini = 0;
            while (ini + i < v.length) {
                fim = ini + 2 * i;
                if (fim > v.length) {
                    fim = v.length;
                }
                intercalacao(v, ini, ini + i, fim);
                ini = ini + 2 * 1;
            }
            i = 2 * i;
        }

    }

    public static int[] generateVector(int n) {
        int v[] = new int[n];

        for (int i = 1; i < n; i++) {
            v[i] = (int) (Math.random() * 300);

        }
        return v;
    }

    public static void printVector(int v[]) {
        // Mostra o vetor v na tela
        for (int i = 0; i < v.length; i++) {
            if (i == (v.length) - 2) {
                System.out.print("Posição " + i + ": (" + v[i] + ") e ");
            } else if (!(i == (v.length) - 1)) {
                System.out.print("Posição " + i + ": (" + v[i] + "), ");
            } else {
                System.out.print("Posição " + i + ": (" + v[i] + ")");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int vetor[] = generateVector(10);
        printVector(vetor);
        mergeSort(vetor);
        printVector(vetor);
    }

}
