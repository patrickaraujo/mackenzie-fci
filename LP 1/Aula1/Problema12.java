/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar operações interativas em um array, como inserção, remoção e busca de elementos.
 * @author 41318862
 */
public class Problema12 {
    
    /**
     * Gera um vetor de tamanho n preenchido com números aleatórios entre 1 e 99.
     */
    public static int[] newArray(int n) {
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            do {
                v[i] = (int) (Math.random() * 100); 
            } while (v[i] == 0);
        }
        return v;
    }
    
    /**
     * Imprime os elementos do vetor formatados.
     */
    public static void printVector(int v[]) {
        for (int i = 0; i < v.length; i++) {
            if (i == (v.length) - 2)
                System.out.print("Posição " + i + ": (" + v[i] + ") e ");
            else if (i != (v.length) - 1)
                System.out.print("Posição " + i + ": (" + v[i] + "), ");
            else
                System.out.print("Posição " + i + ": (" + v[i] + ")");
        }
        System.out.println();
    }

    /**
     * Adiciona um elemento no final da área preenchida do array.
     */
    public static int[] addend(int[] v, int elem, int quantidadePreenchida) {
        if (v.length == quantidadePreenchida) {
            System.out.println("Array cheio");
        } else {
            v[quantidadePreenchida] = elem;
        }
        return v;
    }
    
    /**
     * Adiciona um elemento em uma posição específica, deslocando os demais.
     */
    public static int[] addposition(int[] v, int pos, int ele, int quantidadePreenchida) {
        if (v.length == quantidadePreenchida) {
            addposition(v, pos, ele, quantidadePreenchida - 1);
        } else {
            ArrayList<Integer> fim = new ArrayList<>();
            for (int i = pos; i < quantidadePreenchida; i++) {
                fim.add(v[i]);
            }
            int z[] = converterParaArray(fim);
            v[pos] = ele;
            for (int j = 0; j < z.length; j++) {
                v[j + (pos + 1)] = z[j];
            }
        }
        return v;
    }
    
    /**
     * Remove um elemento de uma posição específica.
     */
    public static int[] removeposition(int[] v, int pos, int tamanhoMaximo) {
        ArrayList<Integer> fim = new ArrayList<>();
        for (int i = pos + 1; i < tamanhoMaximo; i++) {
            fim.add(v[i]);
        }
        int z[] = converterParaArray(fim);
        for (int j = 0; j < z.length; j++) {
            v[j + pos] = z[j];
        }
        v[tamanhoMaximo - 1] = 0;
        return v;
    }
    
    /**
     * Remove todas as ocorrências de um elemento específico.
     */
    public static int[] removeall(int[] v, int eleme, int tamanhoMaximo) {
        int achou;
        int i = 0;
        do {
            achou = lastIndexOf(v, eleme);
            if (achou != -1) {
                v = removeposition(v, achou, tamanhoMaximo);
            } else if (i == 0 && achou == -1) {
                System.out.println("Não há nada a ser removido");
            }
            i++;
        } while (achou != -1);

        return v;
    }
    
    /**
     * Verifica se um elemento existe no vetor e imprime o resultado.
     */
    public static void check(int[] v, int elemen) {
        int ultimo = lastIndexOf(v, elemen);
        if (ultimo >= 0)
            System.out.println(elemen + " está no vetor, na posição: " + ultimo);
        else
            System.out.println(elemen + " não está no vetor");
    }
    
    /**
     * Verifica se existem dois números no array que, somados, resultam no valor informado.
     */
    public static boolean printPairs(int sum, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if ((first + second) == sum) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Encontra a última posição de um elemento no array.
     */
    public static int lastIndexOf(int v[], int e) {
        for (int i = (v.length - 1); i >= 0; i--) {
            if (v[i] == e) return i;
        }
        return -1;
    }
    
    /**
     * Converte um ArrayList de Integer para um array de int primitivo.
     */
    public static int[] converterParaArray(ArrayList<Integer> l) {
        Integer g[] = l.toArray(new Integer[0]);
        int v[] = new int[g.length];
        for (int i = 0; i < g.length; i++) {
            v[i] = g[i];
        }
        return v;
    }
    
    /**
     * Conta quantos elementos não nulos (diferentes de zero) existem no array.
     */
    public static int contarElementosNaoNulos(int v[]) {
        int x = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] != 0) x++;
        }
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println("Entre com a quantidade de elementos no vetor");
        Scanner entrada = new Scanner(System.in);
        int quan;
        do {
            System.out.println("Limite até 100");
            quan = entrada.nextInt();
        } while (quan > 100);
        
        int x[] = Arrays.copyOf(newArray(quan / 4), quan);
        printVector(x);
        
        int operacao;
        do {
            System.out.println("\nEscolha uma operação:\n1.\tAdicionar um elemento no final\n2.\tAdicionar um elemento em uma posição\n3.\tRemover elemento de uma posição\n4.\tRemover todas as ocorrências de um elemento\n5.\tVerificar se elemento está contido\n6.\tVerificar pares que somam um valor\n7.\tSair");
            operacao = entrada.nextInt();
            
            switch(operacao) {
                case 1:
                    System.out.println("Entre com o elemento:");
                    int elem;
                    do { elem = entrada.nextInt(); } while (elem == 0);
                    x = addend(x, elem, contarElementosNaoNulos(x));
                    printVector(x);
                    break;
                case 2:
                    System.out.println("Em qual posição?");
                    int pos1;
                    if (x[0] != 0) {
                        do {
                            System.out.println("Posição: ");
                            pos1 = entrada.nextInt();
                        } while (pos1 > contarElementosNaoNulos(x) || pos1 > quan - 1);
                    } else {
                        do {
                            System.out.println("Digite 0(Zero)");
                            pos1 = entrada.nextInt();
                        } while (pos1 != 0);
                    }
                    System.out.println("Entre com o elemento:");
                    int elemento;
                    do { elemento = entrada.nextInt(); } while (elemento == 0);
                    x = addposition(x, pos1, elemento, contarElementosNaoNulos(x));
                    printVector(x);
                    break;
                case 3:
                    System.out.println("Em qual posição?");
                    int pos2;
                    if (contarElementosNaoNulos(x) == 0) {
                        System.out.println("Não há nada a remover");
                        break;
                    } else {
                        do {
                            System.out.println("Posição Limite: " + (contarElementosNaoNulos(x) - 1));
                            pos2 = entrada.nextInt();
                        } while (pos2 >= contarElementosNaoNulos(x));
                    }
                    x = removeposition(x, pos2, x.length);
                    printVector(x);
                    break;
                case 4:
                    System.out.println("Qual elemento?");
                    int eleme = entrada.nextInt();
                    if (eleme == 0 || contarElementosNaoNulos(x) == 0) {
                        System.out.println("Não há nada a remover");
                        break;
                    }
                    x = removeall(x, eleme, contarElementosNaoNulos(x));
                    printVector(x);
                    break;
                case 5:
                    System.out.println("Qual elemento?");
                    int elemen = entrada.nextInt();
                    check(x, elemen);
                    break;
                case 6:
                    System.out.println("Qual elemento?");
                    int element = entrada.nextInt();
                    if (printPairs(element, x))
                        System.out.println("Há elementos");
                    else
                        System.out.println("Não há elementos");
                    break;
                default:
                    System.out.println("Fim da execução");
                    break;
            }
        } while(operacao > 0 && operacao < 7);
        entrada.close();
    }
}
