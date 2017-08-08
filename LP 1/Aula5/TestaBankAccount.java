/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula5;

import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class TestaBankAccount {
    
    public static void main(String[] args) {
        BankAccount pamela = new BankAccount("Pamela", 600);
        boolean sair = false;
        Scanner entrada = new Scanner(System.in);
        while(!sair){
            System.out.println("OPERAÇÕES DISPONÍVEIS: ");
            System.out.println("(1) Sacar R$ 20");
            System.out.println("(2) Depositar R$ 15");
            System.out.println("(3) Consultar o saldo");
            System.out.println("(4) Obter informações da conta (nome do correntista e número da conta)");
            System.out.println("(5) Consultar a senha gerada");
            System.out.println("(6) sair");
            System.out.println("Opção escolhida: ");
            int escolha = entrada.nextInt();
            System.out.println();
            switch(escolha){
                case 1:
                    pamela.withDraw(20);
                    break;
                case 2:
                    pamela.deposit(15);
                    break;
                case 3:
                    System.out.println("Saldo: "+pamela.getBalance());
                    break;
                case 4:
                    System.out.println("Informações da conta\nNome do correntista: "+pamela.getCliente()+"\nNúmero da conta: "+pamela.getAccountNumber());
                    break;
                case 5:
                    System.out.println("Senha: "+pamela.getPassword());
                    break;
                case 6:
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
