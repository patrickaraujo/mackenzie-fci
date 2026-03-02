/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Patrick
 * Sistema que:
 * - Lê uma matriz de preços de um arquivo
 * - Recebe quantidade desejada de produtos
 * - Calcula preço total por estabelecimento
 * - Indica onde comprar cada produto pelo menor preço
 */
public class Krika {

    /* =========================================================
       ================= LEITURA DE ARQUIVO ====================
       ========================================================= */

    /**
     * Lê a matriz de preços do arquivo.
     * Cada linha representa um produto.
     * Cada coluna representa um estabelecimento.
     */
    public static int[][] lerMatrizArquivo(String nomeArquivo) throws IOException {

        BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));

        // Primeiro: contar número de linhas
        int linhas = 0;
        String linha;
        while ((linha = leitor.readLine()) != null) {
            linhas++;
        }

        leitor.close();

        // Reabrir arquivo para realmente ler dados
        leitor = new BufferedReader(new FileReader(nomeArquivo));

        int[][] matriz = new int[linhas][];

        int i = 0;
        while ((linha = leitor.readLine()) != null) {

            String[] valores = linha.split("\t");
            matriz[i] = new int[valores.length];

            for (int j = 0; j < valores.length; j++) {
                matriz[i][j] = Integer.parseInt(valores[j]);
            }

            i++;
        }

        leitor.close();
        return matriz;
    }

    /* =========================================================
       ================= IMPRESSÃO DA MATRIZ ===================
       ========================================================= */

    public static void imprimirMatriz(int[][] matriz) {

        System.out.print("\t");
        for (int j = 0; j < matriz[0].length; j++) {
            System.out.print("Est" + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("P" + (i + 1) + ":\t");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /* =========================================================
       ================= CÁLCULO PREÇO x QUANTIDADE ============
       ========================================================= */

    public static int[][] calcularTotal(int[][] matriz, int[] quantidades) {

        int[][] resultado = new int[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado[i][j] = matriz[i][j] * quantidades[i];
            }
        }

        return resultado;
    }

    /* =========================================================
       ================= LÓGICA DE MENOR PREÇO =================
       ========================================================= */

    public static int menorElemento(int[] vetor) {
        int menor = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
            }
        }
        return menor;
    }

    public static int indiceMenor(int[] vetor) {
        int menor = menorElemento(vetor);

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == menor) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Retorna o melhor estabelecimento para cada produto
     */
    public static int[] compararEstabelecimentos(int[][] matriz) {

        int[] melhores = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            melhores[i] = indiceMenor(matriz[i]);
        }

        return melhores;
    }

    /* =========================================================
       ================= RESULTADO FINAL =======================
       ========================================================= */

    public static void imprimirResultado(int[][] matriz, int[] melhores) {

        int somaTotal = 0;

        for (int i = 0; i < melhores.length; i++) {

            System.out.println("Produto P" + (i + 1) +
                    " comprar no Estabelecimento " + (melhores[i] + 1));

            somaTotal += matriz[i][melhores[i]];
        }

        System.out.println("Custo total da compra: " + somaTotal);
    }

    /* =========================================================
       ============================= MAIN ======================
       ========================================================= */

    public static void main(String[] args) throws IOException {

        Scanner entrada = new Scanner(System.in);

        int[][] precos = lerMatrizArquivo("precos.txt");

        System.out.println("Tabela de Preços:");
        imprimirMatriz(precos);

        int[] quantidades = new int[precos.length];

        for (int i = 0; i < quantidades.length; i++) {
            System.out.print("Quantidade do Produto P" + (i + 1) + ": ");
            quantidades[i] = entrada.nextInt();
        }

        int[][] total = calcularTotal(precos, quantidades);

        System.out.println("\nTabela (Preço x Quantidade):");
        imprimirMatriz(total);

        int[] melhores = compararEstabelecimentos(total);

        System.out.println("\nMelhores opções:");
        imprimirResultado(total, melhores);

        entrada.close();
    }
}
