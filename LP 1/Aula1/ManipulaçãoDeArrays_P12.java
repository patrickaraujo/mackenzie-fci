/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula1;

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
    public static void printVector(int v[], int quantidadePreenchida) {
        for (int i = 0; i < quantidadePreenchida; i++) {
            if (i == quantidadePreenchida - 2)
                System.out.print("Posição " + i + ": (" + v[i] + ") e ");
            else if (i != quantidadePreenchida - 1)
                System.out.print("Posição " + i + ": (" + v[i] + "), ");
            else
                System.out.print("Posição " + i + ": (" + v[i] + ")");
        }
        if (quantidadePreenchida == 0) {
            System.out.print("Vetor vazio");
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
            System.out.println("Array cheio - não é possível adicionar");
            return v;
        }
        
        // Desloca elementos para a direita a partir da posição
        for (int i = quantidadePreenchida; i > pos; i--) {
            v[i] = v[i - 1];
        }
        
        // Insere o novo elemento
        v[pos] = ele;
        
        return v;
    }
    
    /**
     * Remove um elemento de uma posição específica.
     */
    public static int[] removeposition(int[] v, int pos, int quantidadePreenchida) {
        if (quantidadePreenchida == 0) {
            System.out.println("Vetor vazio - não há o que remover");
            return v;
        }
        
        // Desloca elementos para a esquerda a partir da posição
        for (int i = pos; i < quantidadePreenchida - 1; i++) {
            v[i] = v[i + 1];
        }
        
        // Limpa a última posição
        v[quantidadePreenchida - 1] = 0;
        
        return v;
    }
    
    /**
     * Remove todas as ocorrências de um elemento específico.
     */
    public static int[] removeall(int[] v, int eleme, int quantidadePreenchida) {
        boolean encontrou = false;
        
        // Percorre o array procurando o elemento
        for (int i = 0; i < quantidadePreenchida; i++) {
            if (v[i] == eleme) {
                // Remove o elemento na posição i
                v = removeposition(v, i, quantidadePreenchida);
                quantidadePreenchida--;
                encontrou = true;
                i--; // Volta uma posição pois os elementos foram deslocados
            }
        }
        
        if (!encontrou) {
            System.out.println("Não há nada a ser removido");
        }
        
        return v;
    }
    
    /**
     * Verifica se um elemento existe no vetor e imprime o resultado.
     */
    public static void check(int[] v, int elemen, int quantidadePreenchida) {
        int ultimo = lastIndexOf(v, elemen, quantidadePreenchida);
        if (ultimo >= 0)
            System.out.println(elemen + " está no vetor, na posição: " + ultimo);
        else
            System.out.println(elemen + " não está no vetor");
    }
    
    /**
     * Verifica se existem dois números no array que, somados, resultam no valor informado.
     */
    public static boolean printPairs(int sum, int[] array, int quantidadePreenchida) {
        for (int i = 0; i < quantidadePreenchida; i++) {
            int first = array[i];
            for (int j = i + 1; j < quantidadePreenchida; j++) {
                int second = array[j];
                if ((first + second) == sum) {
                    System.out.println("Pares encontrados: " + first + " + " + second + " = " + sum);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Encontra a última posição de um elemento no array.
     */
    public static int lastIndexOf(int v[], int e, int quantidadePreenchida) {
        for (int i = quantidadePreenchida - 1; i >= 0; i--) {
            if (v[i] == e) return i;
        }
        return -1;
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
        } while (quan > 100 || quan <= 0);
        
        // Inicializa o array com 1/4 dos elementos preenchidos
        int x[] = new int[quan];
        int inicialPreenchido = quan / 4;
        for (int i = 0; i < inicialPreenchido; i++) {
            do {
                x[i] = (int) (Math.random() * 100);
            } while (x[i] == 0);
        }
        
        int quantidadePreenchida = inicialPreenchido;
        printVector(x, quantidadePreenchida);
        
        int operacao;
        do {
            System.out.println("\nEscolha uma operação:\n1.\tAdicionar um elemento no final\n2.\tAdicionar um elemento em uma posição\n3.\tRemover elemento de uma posição\n4.\tRemover todas as ocorrências de um elemento\n5.\tVerificar se elemento está contido\n6.\tVerificar pares que somam um valor\n7.\tSair");
            operacao = entrada.nextInt();
            
            switch(operacao) {
                case 1:
                    System.out.println("Entre com o elemento:");
                    int elem;
                    do { 
                        elem = entrada.nextInt(); 
                    } while (elem == 0);
                    
                    if (quantidadePreenchida < x.length) {
                        x = addend(x, elem, quantidadePreenchida);
                        quantidadePreenchida++;
                        printVector(x, quantidadePreenchida);
                    } else {
                        System.out.println("Array cheio - não é possível adicionar");
                    }
                    break;
                    
                case 2:
                    if (quantidadePreenchida == 0) {
                        System.out.println("Vetor vazio. Adicione elementos primeiro.");
                        break;
                    }
                    
                    System.out.println("Em qual posição? (0 a " + quantidadePreenchida + ")");
                    int pos1;
                    do {
                        pos1 = entrada.nextInt();
                    } while (pos1 < 0 || pos1 > quantidadePreenchida || pos1 >= x.length);
                    
                    System.out.println("Entre com o elemento:");
                    int elemento;
                    do { 
                        elemento = entrada.nextInt(); 
                    } while (elemento == 0);
                    
                    if (quantidadePreenchida < x.length) {
                        x = addposition(x, pos1, elemento, quantidadePreenchida);
                        quantidadePreenchida++;
                        printVector(x, quantidadePreenchida);
                    } else {
                        System.out.println("Array cheio - não é possível adicionar");
                    }
                    break;
                    
                case 3:
                    if (quantidadePreenchida == 0) {
                        System.out.println("Não há nada a remover");
                        break;
                    }
                    
                    System.out.println("Em qual posição? (0 a " + (quantidadePreenchida - 1) + ")");
                    int pos2;
                    do {
                        pos2 = entrada.nextInt();
                    } while (pos2 < 0 || pos2 >= quantidadePreenchida);
                    
                    x = removeposition(x, pos2, quantidadePreenchida);
                    quantidadePreenchida--;
                    printVector(x, quantidadePreenchida);
                    break;
                    
                case 4:
                    if (quantidadePreenchida == 0) {
                        System.out.println("Não há nada a remover");
                        break;
                    }
                    
                    System.out.println("Qual elemento?");
                    int eleme = entrada.nextInt();
                    
                    if (eleme == 0) {
                        System.out.println("Elemento inválido");
                        break;
                    }
                    
                    int antes = quantidadePreenchida;
                    x = removeall(x, eleme, quantidadePreenchida);
                    quantidadePreenchida = contarElementosNaoNulos(x);
                    
                    if (antes == quantidadePreenchida) {
                        System.out.println("Elemento não encontrado no vetor");
                    } else {
                        printVector(x, quantidadePreenchida);
                    }
                    break;
                    
                case 5:
                    System.out.println("Qual elemento?");
                    int elemen = entrada.nextInt();
                    check(x, elemen, quantidadePreenchida);
                    break;
                    
                case 6:
                    if (quantidadePreenchida < 2) {
                        System.out.println("Precisa de pelo menos 2 elementos no vetor");
                        break;
                    }
                    
                    System.out.println("Qual valor da soma?");
                    int element = entrada.nextInt();
                    
                    if (printPairs(element, x, quantidadePreenchida))
                        System.out.println("Há elementos que somam " + element);
                    else
                        System.out.println("Não há elementos que somam " + element);
                    break;
                    
                case 7:
                    System.out.println("Fim da execução");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Escolha de 1 a 7.");
                    break;
            }
        } while(operacao != 7);
        
        entrada.close();
    }
}
