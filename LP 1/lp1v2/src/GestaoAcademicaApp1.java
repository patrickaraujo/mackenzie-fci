/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp1v2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Patrick
 */
public class GestaoAcademicaApp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Universidade x = new Universidade("UNIVIDA");
        x.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "newMatriculas.txt");
        int operacao;
        Scanner all = new Scanner(System.in);
        do{
            System.out.println("Escolha uma operação:\n1.\tListar os números, nomes e créditos de todos os estudantes;\n2.\tListar os códigos de todas as disciplinas;\n3.\tListar todas as informações dos estudantes matriculados em uma determinada disciplina;\n4.\tListar todas as informações das disciplinas em que um determinado estudante está matriculado.");
            operacao = all.nextInt();
            switch(operacao){
                case 1:
                    System.out.println(x.showAllStudents());
                    break;
                case 2:
                    System.out.println("Disciplinas\n"+x.showAllSubjects());
                    break;
                case 3: 
                    System.out.println("Entre com código da disciplina");
                    System.out.println(x.findStudentsBySubject(all.next()));
                    break;
                case 4: 
                    System.out.println("Entre com código do estudante");
                    System.out.println(x.findSubjectsbyStudent(all.nextInt()));
                    break;
                default:
                    System.out.println("Fim da execução");
            }
        } while(operacao < 5);
        
    }
}
