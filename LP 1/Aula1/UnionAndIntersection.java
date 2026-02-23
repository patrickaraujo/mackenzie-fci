/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;

import java.util.Arrays;

/**
 * Classe utilitária para gerar vetores, buscar elementos e realizar
 * operações de conjuntos (União e Intersecção) entre arrays numéricos.
 * @author 41318862
 */
public class UnionAndIntersection {
    
    /**
     * Gera um vetor de tamanho n preenchido com números aleatórios entre 0 e 9.
     */
    public static int[] generateVector(int n) {
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = (int) (Math.random() * 10);
        }
        return v;
    }
     
    /**
     * Imprime os elementos do vetor separados por espaço.
     */
    public static void printVector(int v[]) {
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + "  ");
        }
        System.out.println();
    }
     
    /**
     * Busca sequencialmente um elemento no vetor.
     */
    public static boolean busca(int v[], int x) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == x) return true;
        }
        return false;
    }
     
    /**
     * Realiza a união de dois vetores, concatenando-os.
     * Nota: Esta implementação adiciona todos os elementos do vetor 'w' ao vetor 'v',
     * sem filtrar duplicatas.
     */
    public static int[] union(int v[], int w[]) {
        int uniao[] = Arrays.copyOf(v, v.length + w.length);
        int k = v.length;
        
        for (int i = 0; i < w.length; i++) {
            uniao[k] = w[i];
            k++;
        }
        
        return Arrays.copyOf(uniao, k);
    }

    /**
     * Realiza a intersecção matemática entre dois vetores.
     * Mantém apenas os elementos de 'v' que também estão presentes em 'w'.
     */
    public static int[] intersection(int v[], int w[]) {
        int tam = Math.max(v.length, w.length);
        int inter[] = new int[tam];
        int k = 0;
        
        for (int i = 0; i < v.length; i++) {
            if (busca(w, v[i])) {
                inter[k] = v[i];
                k++;
            }
        }
        
        return Arrays.copyOf(inter, k);
    }
     
    public static void main(String args[]) {
        int vet[] = generateVector(10);
        int vet2[] = generateVector(15);
        
        System.out.println("Vetor 1:");
        printVector(vet);
        System.out.println("Vetor 2:");
        printVector(vet2);
        
        int x = 7;
        boolean achou = busca(vet, x);
        if (achou) {
            System.out.println("7 está no vetor");
        } else {
            System.out.println("7 não está no vetor");
        }
        
        System.out.println("União: ");
        int u[] = union(vet, vet2);
        printVector(u);
        
        System.out.println("Intersecção: ");
        int inters[] = intersection(vet, vet2);
        printVector(inters);
    }
}
