/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula3;

import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class ContaBancaria {
    public static Scanner entrada;
    
    public static void sacar (double[][] saldos, double valor, int cliente, int tipoConta){
        saldos[cliente][tipoConta] -=valor;
    }
    
    public static void depositar (double[][] saldos, double valor, int cliente, int tipoConta){
        saldos[cliente][tipoConta] +=valor;
    }
    
    public static void interacaoSacar(double[][] saldos){
        boolean clienteValido = false;
        int cliente = -1;
        while(!clienteValido){
            System.out.print("O saque será efetuado na conta de qual cliente (0 a " + (saldos.length-1) + "): ");
            cliente = entrada.nextInt();
            if(cliente >= 0 && cliente < saldos.length)
                clienteValido = true;
            else
                System.out.println("Índice de cliente inválido!");
        }
        boolean contaValida = false;
        int tipoConta = -1;
        while(!contaValida){
            System.out.println("Em qual conta séra efetuado o saque? " + "(0 - conta corrente; 1 - poupança): ");
        
            tipoConta = entrada.nextInt();
            if(tipoConta == 0 || tipoConta == 1)
                contaValida = true;
            else
                System.out.println("Valor inválido!");
        }
        System.out.print("Qual o valor do saque? ");
        int saque = entrada.nextInt();
        sacar(saldos, saque, cliente, tipoConta);
    }
    
    public static void interacaoDepositar(double[][] saldos){
        boolean clienteValido = false;
        int cliente = -1;
        while(!clienteValido){
            System.out.print("O depósito será efetuado na conta de qual cliente (0 a " + (saldos.length-1) + "): ");
            cliente = entrada.nextInt();
            if(cliente >= 0 && cliente < saldos.length)
                clienteValido = true;
            else
                System.out.println("Índice de cliente inválido!");
        }
        boolean contaValida = false;
        int tipoConta = -1;
        while(!contaValida){
            System.out.println("Em qual conta séra efetuado o depósito? " + "(0 - conta corrente; 1 - poupança): ");
        
            tipoConta = entrada.nextInt();
            if(tipoConta == 0 || tipoConta == 1)
                contaValida = true;
            else
                System.out.println("Valor inválido!");
        }
        System.out.print("Qual o valor do depósito? ");
        int deposito = entrada.nextInt();
        depositar(saldos, deposito, cliente, tipoConta);
    }
    
    public static void imprimeSaldos(String nomes[], double saldos[][]){
        System.out.println("Saldos de todos os clientes:");
        for(int i = 0; i < nomes.length; i++){
            String msg = i + ") " + nomes[i] + ": ";
            msg +=saldos[i][0] + " (conta corrente) e ";
            msg +=saldos[i][1] + " (poupança)";
            System.out.println(msg);
        }
        System.out.println();
    }
    
    public static void interacaoTransferir (double[][] saldos){
        double valor;
        do{
            System.out.println("Valor");
            valor = entrada.nextDouble();
        }while(valor < 0);
        int cO;
        do{
            System.out.println("Qual a conta origem? (0 a " + (saldos.length-1) + "): ");
            cO = entrada.nextInt();
        }while((cO < 0) || (cO > (saldos.length-1)));
        int tCO;
        do{
            System.out.println("Qual o tipo da conta origem? " + "(0 - conta corrente; 1 - poupança): ");
            tCO = entrada.nextInt();
        }while((tCO < 0) || (tCO > 1));
        int cD;
        do{
            System.out.println("Qual a conta destino? (0 a " + (saldos.length-1) + "): ");
            cD = entrada.nextInt();
        }while((cD < 0) || (cD > (saldos.length-1)));
        int tCD;
        do{
            System.out.println("Qual o tipo da conta destino? " + "(0 - conta corrente; 1 - poupança): ");
            tCD = entrada.nextInt();
        }while((tCD < 0) || (tCD > 1));
        transferir(saldos, valor, cO, tCO, cD, tCD);
    }
    
    public static void transferir(double[][] saldos, double valor, int clienteOrigem, int tipoContaOrigem, int clienteDestino, int tipoContaDestino){
        sacar(saldos, valor, clienteOrigem, tipoContaOrigem);
        depositar(saldos, valor, clienteDestino, tipoContaDestino);
    }
    
    public static void main(String[] args) {
        String cliente[] = {"Marcos", "Júlia", "João", "Roberto", "Janaína"};
        double saldos [][] = {{1000, 2500}, {250, 1500}, {2500, 750}, {3000, 50}, {4500, 3200}};
        entrada = new Scanner(System.in);
        boolean sair = false;
        
        while(!sair){
            System.out.println("Escolha uma operação: ");
            System.out.println("(1) mostrar saldos de todos os clientes");
            System.out.println("(2) sacar");
            System.out.println("(3) depositar");
            System.out.println("(4) transferência");
            System.out.println("(5) sair");
            System.out.println("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch(escolha){
                case 1:
                    imprimeSaldos(cliente, saldos);
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
    }
}
