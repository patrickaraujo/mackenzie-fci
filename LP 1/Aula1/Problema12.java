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
 *
 * @author 41318862
 */
public class Problema12 {
    
    public static int [] newArray(int n){
        // Gera um vetor aleatório de n posições
        int v[] = new int[n];
        for (int i = 0; i < n; i++)
            do {
                v[i] = (int) (Math.random() * 100); // gera números aleatórios entre 0 e 100
            } while (v[i] == 0);
        return v;
    }
    
    public static void printVector(int v[]) {
        // Mostra o vetor v na tela
        for (int i = 0; i < v.length; i++) {
            if (i == (v.length) - 2)
                System.out.print("Posição " + i + ": (" + v[i] + ") e ");
            else if (!(i == (v.length) - 1))
                System.out.print("Posição " + i + ": (" + v[i] + "), ");
            else
                System.out.print("Posição " + i + ": (" + v[i] + ")");
        }
        System.out.println();
    }

    public static int[] addend(int[] v, int elem, int x) {
        if (v.length == x)
            System.out.println("Array cheio");
        else
            v[x] = elem;
        return v;
    }
    
    public static int[] addposition(int[] v, int pos, int ele, int x) {
        if (v.length == x)
            addposition(v, pos, ele, x - 1);
        else {
            ArrayList<Integer> fim = new ArrayList<>();
            for (int i = pos; i < x; i++)
                fim.add(v[i]);
            int z[] = ata(fim);
            v[pos] = ele;
            for (int j = 0; j < z.length; j++)
                v[j + (pos + 1)] = z[j];
        }
        return v;
    }
    
    public static int[] removeposition(int[] v, int pos, int x) {
        ArrayList<Integer> fim = new ArrayList<>();
        for (int i = pos + 1; i < x; i++)
            fim.add(v[i]);
        int z[] = ata(fim);
        for (int j = 0; j < z.length; j++)
            v[j + pos] = z[j];
        v[x - 1] = 0;
        return v;
    }
    
    public static int[] removeall(int[] v, int eleme, int x) {
        int achou;
        int i = 0;
        do {
            achou = lastIndexOf(v, eleme);
            if (achou != -1)
                v = removeposition(v, achou, x);
            else if ((i == 0) && (achou == (-1)))
                System.out.println("Não há nada a ser removido");
            i++;
        } while (achou != -1);

        return v;
    }
    
    public static void check(int[] v, int elemen) {
        int ultimo = lastIndexOf(v, elemen);
        if (ultimo >= 0)
            System.out.println(+elemen + " está no vetor, na posição: " + ultimo);
        else
            System.out.println(+elemen + " não está no vetor");
        
    }
    
    public static boolean printPairs(int sum, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if ((first + second) == sum)
                    return true;
                    // System.out.println("\""+i+": ["+first+"]\" e \""+j+": ["+second+"]\""); 
                    // return 1;
            }
        }
        // return 0;
        return false;
    }
    
    public static int lastIndexOf(int v[], int e) {
        int tam = v.length;
        int k = 0;
        for (int i = (tam - 1); i >= 0; i--)
            if (v[i] == e)
                return (i);
        return -1;
    }
    
    public static int[] ata(ArrayList<Integer> l) {
        Integer g[] = l.toArray(new Integer[l.size()]);
        int v[] = new int[g.length];
        for (int i = 0; i < g.length; i++)
            v[i] = g[i];
        return v;
    }
    
    public static int gerar(int v[]) {
        int x = 0;
        for (int i = 0; i < v.length; i++)
            if (v[i] != 0)
                x++;
        return x;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Entre com a quantidade de elementos no vetor");
        Scanner entrada = new Scanner(System.in);
        int quan;
        do {
            System.out.println("Limite até 100");
            quan = entrada.nextInt();
        } while (quan > 100);
        int x [] = Arrays.copyOf(newArray((int) quan / 4), quan);
        printVector(x);
        int operacao;
        do{
            System.out.println("Escolha uma operação:\n1.\tAdicionar um elemento no final da coleção;\n2.\tAdicionar um dado elemento em uma dada posição;\n3.\tRemover o elemento de uma dada posição;\n4.\tRemover todas as ocorrências de um elemento na coleção;\n5.\tVerificar se dado um elemento está contido na coleção;\n6.\tVerificar se dado um elemento existem dois números na coleção que somados é igual ao elemento informado.");
            operacao = entrada.nextInt();
            switch(operacao){
                case 1:
                    System.out.println("Entre com o elemento");
                    int elem;
                    do {
                        elem = entrada.nextInt();
                    } while (elem == 0);
                    x = addend(x, elem, gerar(x));
                    printVector(x);
                    break;
                case 2:
                    System.out.println("Em qual posição?");
                    int pos1;
                    if (x[0] != 0)
                        do {
                            do {
                                System.out.println("Posição: ");
                                pos1 = entrada.nextInt();
                            } while (pos1 > gerar(x));
                        } while (pos1 > quan - 1);
                    else
                        do {
                            System.out.println("Digite 0(Zero)");
                            pos1 = entrada.nextInt();
                        } while (pos1 != 0);
                    System.out.println("Entre com o elemento");
                    int elemento;
                    do {
                        elemento = entrada.nextInt();
                    } while (elemento == 0);
                    x = addposition(x, pos1, elemento, gerar(x));
                    printVector(x);
                    break;
                case 3:
                    System.out.println("Em qual posição?");
                    int pos2;
                    if (gerar(x) == 0) {
                        System.out.println("Não há nada a remover");
                        break;
                    }
                    else
                        do {
                            System.out.println("Posição Limite: " + (gerar(x)-1));
                            pos2 = entrada.nextInt();
                        } while (pos2 >= gerar(x));
                    x = removeposition(x, pos2, x.length);
                    printVector(x);
                    break;
                case 4:
                    System.out.println("Qual elemento?");
                    int eleme;
                    do {
                        eleme = entrada.nextInt();
                        if (eleme == 0 || (gerar(x) == 0)) {
                            System.out.println("Não há nada a remover");
                            break;
                        }
                    } while (gerar(x) < 0);
                    x = removeall(x, eleme, gerar(x));
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
                    boolean o = printPairs(element, x);
                    if (o)
                        System.out.println("Há elementos");
                    else
                        System.out.println("Não há elementos");
                    break;
                default:
                    System.out.println("Fim da execução");
            }
        } while(operacao < 7);
    }
}
