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
 *
 * @author Patrick
 */
public class Krika {
    public static int[][] readMatrixFile (String file) throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha = entrada.readLine(); // lê a primeira linha
        String vetorStr[] = linha.split("\t");
        int i = 0;
        while (linha != null) {
            linha = entrada.readLine();
            i++;
        }
        int Mat[][] = new int[i][vetorStr.length];
        Mat = passadados(file, Mat);
        entrada.close();
        return Mat;
    }
    
    public static int[][] passadados(String file, int x[][]) throws IOException {
        BufferedReader entrada = new BufferedReader(new FileReader(file));
        String linha;
        for(int k = 0; k < x.length; k++){
            linha = entrada.readLine();
            String vetorStr[] = linha.split("\t");
            for(int j = 0; j < x[0].length; j++){
                x[k][j] = Integer.parseInt(vetorStr[j]);
            }
        }
        entrada.close();
        return x;
    }
    
    public static void printMatrix(int m[ ][ ]){
        //andando na linha
        for (int n = 0; n < m[0].length; n++)
                System.out.print("\t"+(n+1));
        System.out.println();
        for(int i = 0; i < m.length; i++){
            //andando nas colunas
            for(int j = 0; j < m[0].length; j++){
                if(j == 0)
                    System.out.print("P"+(i+1)+":\t");
                System.out.print(m[i][j]+"\t");
            }
            System.out.println();
        }  

    }
    
    public static int[][] calcula(int x[][], int a1, int a2, int a3){
        for(int i = 0; i < x.length; i++)
            for(int j = 0; j < x[i].length; j++){
                if(i == 0)
                    x[i][j] = x[i][j]*a1;
                else if(i == 1)
                    x[i][j] = x[i][j]*a2;
                else
                    x[i][j] = x[i][j]*a3;
            }
        return x;
    }
    
    public static int[] compara(int x[][]){
        int z[] = new int[x.length];
        for(int i = 0; i < x.length; i++){
            z[i] = menorElemento(x[i]);
        }
        int c[] = new int[z.length];
        for(int j = 0; j < z.length; j++)
            c[j] = procura(x[j], z[j]);
        return c;
    }
    
    public static int menorElemento(int vet[]) {
        int menor = vet[0];
        for(int i=1; i < vet.length; i++){
            if(vet[i] < menor){
                menor=vet[i];
            }
        }
        return menor;
    }
    
    public static int procura(int x[], int y) {
        for (int i = 0; i < x.length; i++)
            if (x[i] == (y))
                return i;
        return -1; // Não achou, retorna -1
    }
    
    public static void print(int x[][], int y[]){
        int s = 0;
        for(int i = 0; i < y.length; i++){
            System.out.println("Estabelecimento mais barato para comprar o produto P"+(i+(1))+": "+(y[i]+(1)));
            s = s + x[i][y[i]];
        }
        System.out.println("Custo da compra: "+s);
    }
    
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        int mat[][];
        mat = readMatrixFile("precos.txt");
        System.out.println("Obs.: Linha X = Estabelecimentos; Linha Y = Produtos");
        System.out.println("Tabela de valores");
        printMatrix(mat);
        System.out.println("Entre com a quantidade do produto:\n\nP1");
        Scanner all = new Scanner(System.in);
        int p1 = all.nextInt();
        System.out.println("P2");
        int p2 = all.nextInt();
        System.out.println("P3");
        int p3 = all.nextInt();
        int x[][] = calcula(mat, p1, p2, p3);
        int b[] = compara(x);
        System.out.println("\nRelação: (preço X quantidade)");
        printMatrix(x);
        print(x, b);
    }
}
