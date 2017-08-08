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
public class JogoVelha {
    
    public static void initialize (String x[][]){
        for(int i = 0; i < x[0].length; i++)
            for(int j = 0; j < x.length; j++)
                x[i][j] = ".";
    }
    
    public static void print2DArray (String x[][]){
        for(int i = 0; i < x[0].length; i++){
            System.out.println();
            for(int j = 0; j < x.length; j++)
                System.out.print(x[i][j]+"\t");
        }
    }
    
    public static void tentativas (boolean j1, String[][] a){
        String g1 = "";
        String g2 = "";
        if(j1){
            g1 = "X";
            g2 = "O";
        }
        else{
            g1 = "O";
            g2 = "X";
        }
        int i = 0;
        Scanner entrada = new Scanner(System.in);
        boolean lol = false;
        do{
            int lin = 4;
            int col = 4;
            boolean test = false;
            String jogador = "";
            if(i % 2 == 0)
                jogador = g1;
            else
                jogador = g2;
            
            while(!test){
                System.out.println(jogador+": qual posição?");
                System.out.print("Linha: ");
                lin = entrada.nextInt();
                System.out.print("\nColuna: ");
                col = entrada.nextInt();
                if((lin < 3) && (col < 3))
                    if(".".equals(a[lin][col]))
                        test = true;
            }
            a[lin][col] = jogador;
            print2DArray(a);
            int y = check(a);
            if (y == 1)
                System.out.println("\"X\" venceu");
            if (y == 2)
                System.out.println("\"O\" venceu");
            i++;
            if((verificaCheio(a)) || (y > 0))
                lol = false;
            else
                lol = true;
        }while(lol);// até estar cheio
        
    }
    
    public static boolean verificaCheio(String v[][]){
        for(int i = 0; i < v[0].length; i++)
            for(int j = 0; j < v.length; j++)
                if(".".equals(v[i][j])){
                    System.out.println("Deu velha");
                    return false;
                }
        return true;
    }
    
    public static int check(String a[][]){
        if((("X".equals(a[0][0])) && ("X".equals(a[1][1])) && ("X".equals(a[2][2]))))
            return 1;
        if((("O".equals(a[0][0])) && ("O".equals(a[1][1])) && ("O".equals(a[2][2]))))
            return 2;
        if((("X".equals(a[2][0])) && ("X".equals(a[1][1])) && ("X".equals(a[0][2]))))
            return 1;
        if((("O".equals(a[2][0])) && ("O".equals(a[1][1])) && ("O".equals(a[0][2]))))
            return 2;
        for(int coluna=0 ; coluna<3 ; coluna++){
            if((("X".equals(a[0][coluna])) && ("X".equals(a[1][coluna])) && ("X".equals(a[2][coluna]))))
                return 1;
            if((("O".equals(a[0][coluna])) && ("O".equals(a[1][coluna])) && ("O".equals(a[2][coluna]))))
                return 2;
            if((("X".equals(a[coluna][0])) && ("X".equals(a[coluna][1])) && ("X".equals(a[coluna][2]))))
                return 1;
            if((("O".equals(a[coluna][0])) && ("O".equals(a[coluna][1])) && ("O".equals(a[coluna][2]))))
                return 2;
        }
        return 0;       
    }
    
    public static void main(String [] args) {
        String a[][] = new String[3][3];
        initialize(a);
        print2DArray(a);
        Scanner entrada = new Scanner(System.in);
        String j1;
        boolean cond = false;
        boolean ej1 = false;
        while(!cond){
            System.out.print("\nJogador 1 escolha seu símbolo: \"X\" ou \"O\": ");
            j1 = entrada.next();
            if(("X".equals(j1)) || ("x".equals(j1)) || ("O".equals(j1)) || ("o".equals(j1))){
                if(("X".equals(j1)) || ("x".equals(j1)))
                    ej1 = true;
                cond = true;
            }
        }
        tentativas(ej1, a);
    }
}
