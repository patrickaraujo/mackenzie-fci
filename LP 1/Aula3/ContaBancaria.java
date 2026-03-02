/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula3;

import java.util.Scanner;

/**
 * @author Patrick
 * Classe que simula operações bancárias simples.
 *
 * Cada cliente possui:
 * - Conta corrente (índice 0)
 * - Conta poupança (índice 1)
 * 
 * O sistema permite:
 * - Consultar saldos
 * - Sacar
 * - Depositar
 * - Transferir valores entre contas
 */
public class ContaBancaria {

    // Scanner global para entrada de dados
    public static Scanner entrada;

    /* =========================================================
       =============== MÉTODOS BÁSICOS (LÓGICA) ===============
       ========================================================= */

    /**
     * Realiza saque de uma conta específica.
     */
    public static void sacar(double[][] saldos, double valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] -= valor;
    }

    /**
     * Realiza depósito em uma conta específica.
     */
    public static void depositar(double[][] saldos, double valor, int cliente, int tipoConta) {
        saldos[cliente][tipoConta] += valor;
    }

    /**
     * Realiza transferência entre contas.
     * Primeiro saca da origem e depois deposita no destino.
     */
    public static void transferir(double[][] saldos, double valor,
                                  int clienteOrigem, int tipoContaOrigem,
                                  int clienteDestino, int tipoContaDestino) {

        sacar(saldos, valor, clienteOrigem, tipoContaOrigem);
        depositar(saldos, valor, clienteDestino, tipoContaDestino);
    }

    /* =========================================================
       ============= MÉTODOS DE INTERAÇÃO (USUÁRIO) ===========
       ========================================================= */

    /**
     * Interação completa para realizar saque.
     */
    public static void interacaoSacar(double[][] saldos) {

        int cliente = solicitarClienteValido(saldos.length);
        int tipoConta = solicitarTipoConta();
        
        System.out.print("Qual o valor do saque? ");
        double valor = entrada.nextDouble();

        sacar(saldos, valor, cliente, tipoConta);
    }

    /**
     * Interação completa para realizar depósito.
     */
    public static void interacaoDepositar(double[][] saldos) {

        int cliente = solicitarClienteValido(saldos.length);
        int tipoConta = solicitarTipoConta();

        System.out.print("Qual o valor do depósito? ");
        double valor = entrada.nextDouble();

        depositar(saldos, valor, cliente, tipoConta);
    }

    /**
     * Interação completa para realizar transferência.
     */
    public static void interacaoTransferir(double[][] saldos) {

        System.out.print("Informe o valor da transferência: ");
        double valor = entrada.nextDouble();

        System.out.println("=== Conta Origem ===");
        int clienteOrigem = solicitarClienteValido(saldos.length);
        int tipoContaOrigem = solicitarTipoConta();

        System.out.println("=== Conta Destino ===");
        int clienteDestino = solicitarClienteValido(saldos.length);
        int tipoContaDestino = solicitarTipoConta();

        transferir(saldos, valor, clienteOrigem, tipoContaOrigem,
                   clienteDestino, tipoContaDestino);
    }

    /* =========================================================
       ================= MÉTODOS AUXILIARES ====================
       ========================================================= */

    /**
     * Solicita um cliente válido ao usuário.
     */
    public static int solicitarClienteValido(int totalClientes) {

        int cliente;

        do {
            System.out.print("Escolha o cliente (0 a " + (totalClientes - 1) + "): ");
            cliente = entrada.nextInt();

            if (cliente < 0 || cliente >= totalClientes) {
                System.out.println("Índice de cliente inválido!");
            }

        } while (cliente < 0 || cliente >= totalClientes);

        return cliente;
    }

    /**
     * Solicita tipo de conta válido ao usuário.
     */
    public static int solicitarTipoConta() {

        int tipoConta;

        do {
            System.out.println("Tipo da conta:");
            System.out.println("0 - Conta Corrente");
            System.out.println("1 - Poupança");
            tipoConta = entrada.nextInt();

            if (tipoConta != 0 && tipoConta != 1) {
                System.out.println("Tipo de conta inválido!");
            }

        } while (tipoConta != 0 && tipoConta != 1);

        return tipoConta;
    }

    /**
     * Imprime os saldos de todos os clientes.
     */
    public static void imprimirSaldos(String[] nomes, double[][] saldos) {

        System.out.println("\n=== SALDOS DOS CLIENTES ===");

        for (int i = 0; i < nomes.length; i++) {

            System.out.println(i + ") " + nomes[i]);
            System.out.println("   Conta Corrente: R$ " + saldos[i][0]);
            System.out.println("   Poupança: R$ " + saldos[i][1]);
            System.out.println();
        }
    }

    /* =========================================================
       =========================== MAIN ========================
       ========================================================= */

    public static void main(String[] args) {

        // Lista de clientes
        String[] clientes = {"Marcos", "Júlia", "João", "Roberto", "Janaína"};

        // Matriz de saldos:
        // [cliente][0] = conta corrente
        // [cliente][1] = poupança
        double[][] saldos = {
                {1000, 2500},
                {250, 1500},
                {2500, 750},
                {3000, 50},
                {4500, 3200}
        };

        entrada = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {

            System.out.println("====== MENU ======");
            System.out.println("(1) Mostrar saldos");
            System.out.println("(2) Sacar");
            System.out.println("(3) Depositar");
            System.out.println("(4) Transferência");
            System.out.println("(5) Sair");
            System.out.print("Escolha: ");

            int opcao = entrada.nextInt();
            System.out.println();

            switch (opcao) {

                case 1:
                    imprimirSaldos(clientes, saldos);
                    break;

                case 2:
                    interacaoSacar(saldos);
                    break;

                case 3:
                    interacaoDepositar(saldos);
                    break;

                case 4:
                    interacaoTransferir(saldos);
                    break;

                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();
        }

        System.out.println("Fim do programa!");
        entrada.close();
    }
}
