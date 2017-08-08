/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed;

import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class ED {

    /**
     * @param args the command line arguments
     */
    public static int[] newArray(int n) {
        // Gera um vetor aleatório de n posições
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            do {
                v[i] = (int) (Math.random() * 10);     // gera números aleatórios entre 0 e 100
            } while (v[i] == 0);
        }
        return v;
    }

    public static boolean verifica(int x[]) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }
        return true;
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

    public static void InsertionSort(int[] v) {
        int eleito, j;
        for (int i = 1; i < v.length; i++) {
            eleito = v[i];
            j = i - 1;

            while ((j >= 0 && v[j] > eleito)) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = eleito;
        }
    }
    
    public static int busca(int x, int [] v ,int i,int f){
        int m;
        System.out.println("hey!");
        if(i > f)
            return - 1;
        m = (i + f) / 2;
        if(v[m] == x)
            return m;
        if(x < v[m])
            return busca(x, v, i, m - 1);
        else
            return busca(x, v, m + 1, f);
    }
     
    public static int potencia (int m, int n) {
        if (n == 0)
            return 1;
        else
            return m * potencia (m, n-1);
    }
    
    public static void reverse (int x[]) {
        for (int i = 0; i < x.length / 2; i++) {
            int temp = x[i];
            x[i] = x[x.length - 1 - i];
            x[x.length - 1 - i] = temp;
        }
    }
    
    public static void menorMaior (int x[]) {
        int maior = 0;
        int maiorIndex = 0;
        int menor = x[0];
        int menorIndex = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] < menor){
                menor = x[i];
                menorIndex = i;
            }
            if(x[i] > maior){
                maior = x[i];
                maiorIndex = i;
            }
        }
        x[maiorIndex]=menor;
        x[menorIndex]=maior;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //  int a[] = newArray(100);
        printVector(a);
        InsertionSort(a);
        reverse(a);
        printVector(a);
        menorMaior(a);
        printVector(a);
        if (verifica(a)) {
            System.out.println("Está ordenado");
        } else {
            System.out.println("Não está ordenado");
        }
        //  System.out.println(busca(9, a, 0, a.length));
        System.out.println(potencia(2, 4));
    }

}
