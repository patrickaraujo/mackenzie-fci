/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula3;

import java.util.Scanner;

/**
 * @author Patrick
 * Jogo da Velha (Tic-Tac-Toe)
 * 
 * Estrutura:
 * - Tabuleiro 3x3 representado por matriz String[][]
 * - "." representa posição vazia
 * - "X" e "O" representam jogadas dos jogadores
 */
public class JogoVelha {

    // Scanner único para todo o programa
    public static Scanner entrada = new Scanner(System.in);

    /* =========================================================
       ================== INICIALIZAÇÃO ========================
       ========================================================= */

    /**
     * Inicializa o tabuleiro preenchendo com "."
     */
    public static void inicializarTabuleiro(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                tabuleiro[linha][coluna] = ".";
            }
        }
    }

    /**
     * Imprime o tabuleiro formatado
     */
    public static void imprimirTabuleiro(String[][] tabuleiro) {
        System.out.println("\nTabuleiro:");
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                System.out.print(tabuleiro[linha][coluna] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /* =========================================================
       ================== LÓGICA DO JOGO =======================
       ========================================================= */

    /**
     * Verifica se o tabuleiro está cheio
     */
    public static boolean tabuleiroCheio(String[][] tabuleiro) {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (".".equals(tabuleiro[linha][coluna])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Verifica se há vencedor.
     * Retorna:
     * 0 -> ninguém venceu
     * 1 -> X venceu
     * 2 -> O venceu
     */
    public static int verificarVencedor(String[][] tabuleiro) {

        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {

            // Linhas
            if ("X".equals(tabuleiro[i][0]) &&
                "X".equals(tabuleiro[i][1]) &&
                "X".equals(tabuleiro[i][2]))
                return 1;

            if ("O".equals(tabuleiro[i][0]) &&
                "O".equals(tabuleiro[i][1]) &&
                "O".equals(tabuleiro[i][2]))
                return 2;

            // Colunas
            if ("X".equals(tabuleiro[0][i]) &&
                "X".equals(tabuleiro[1][i]) &&
                "X".equals(tabuleiro[2][i]))
                return 1;

            if ("O".equals(tabuleiro[0][i]) &&
                "O".equals(tabuleiro[1][i]) &&
                "O".equals(tabuleiro[2][i]))
                return 2;
        }

        // Diagonal principal
        if ("X".equals(tabuleiro[0][0]) &&
            "X".equals(tabuleiro[1][1]) &&
            "X".equals(tabuleiro[2][2]))
            return 1;

        if ("O".equals(tabuleiro[0][0]) &&
            "O".equals(tabuleiro[1][1]) &&
            "O".equals(tabuleiro[2][2]))
            return 2;

        // Diagonal secundária
        if ("X".equals(tabuleiro[0][2]) &&
            "X".equals(tabuleiro[1][1]) &&
            "X".equals(tabuleiro[2][0]))
            return 1;

        if ("O".equals(tabuleiro[0][2]) &&
            "O".equals(tabuleiro[1][1]) &&
            "O".equals(tabuleiro[2][0]))
            return 2;

        return 0;
    }

    /* =========================================================
       ================== CONTROLE DAS JOGADAS =================
       ========================================================= */

    /**
     * Executa o loop principal do jogo
     */
    public static void jogar(boolean jogador1EhX, String[][] tabuleiro) {

        String simboloJ1 = jogador1EhX ? "X" : "O";
        String simboloJ2 = jogador1EhX ? "O" : "X";

        int turno = 0;
        boolean jogoAtivo = true;

        while (jogoAtivo) {

            String jogadorAtual = (turno % 2 == 0) ? simboloJ1 : simboloJ2;

            int linha, coluna;

            // Validação de jogada
            while (true) {
                System.out.println("Jogador " + jogadorAtual);
                System.out.print("Linha (0-2): ");
                linha = entrada.nextInt();
                System.out.print("Coluna (0-2): ");
                coluna = entrada.nextInt();

                if (linha >= 0 && linha < 3 &&
                    coluna >= 0 && coluna < 3 &&
                    ".".equals(tabuleiro[linha][coluna])) {
                    break;
                }

                System.out.println("Posição inválida! Tente novamente.\n");
            }

            tabuleiro[linha][coluna] = jogadorAtual;
            imprimirTabuleiro(tabuleiro);

            int resultado = verificarVencedor(tabuleiro);

            if (resultado == 1) {
                System.out.println("Jogador X venceu!");
                jogoAtivo = false;
            } else if (resultado == 2) {
                System.out.println("Jogador O venceu!");
                jogoAtivo = false;
            } else if (tabuleiroCheio(tabuleiro)) {
                System.out.println("Deu velha! (Empate)");
                jogoAtivo = false;
            }

            turno++;
        }
    }

    /* =========================================================
       ============================ MAIN ========================
       ========================================================= */

    public static void main(String[] args) {

        String[][] tabuleiro = new String[3][3];

        inicializarTabuleiro(tabuleiro);
        imprimirTabuleiro(tabuleiro);

        boolean jogador1EhX = false;

        // Escolha do símbolo
        while (true) {
            System.out.print("Jogador 1 escolha seu símbolo (X ou O): ");
            String escolha = entrada.next().toUpperCase();

            if (escolha.equals("X")) {
                jogador1EhX = true;
                break;
            } else if (escolha.equals("O")) {
                jogador1EhX = false;
                break;
            }

            System.out.println("Entrada inválida!");
        }

        jogar(jogador1EhX, tabuleiro);

        entrada.close();
        System.out.println("Fim do jogo!");
    }
}
