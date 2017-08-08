/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrega1;

import java.util.Scanner;

/**
 *
 * @author 41318862
 */
public class TestPolinomio {
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        System.out.print("Entre com o polinômio\nSepare cada monômio com um conjunto de parenteses\nUm exemplo: P(x) = (4x6)(+3x5)(-6x3)(-8x2)(+3x)(+4)\nP(x) = ");
        String poli = entrada.next();       
        Polinomio pol = new Polinomio(poli);
        Polinomio pol2 = new Polinomio("(4x6)(+3x5)(-6x3)(-8x2)(+3x)(+4)");
        Polinomio pol3 = pol.soma(pol2);
        System.out.println("Soma: \n"+pol3.getPolinomios());
        int x = 2;
        System.out.println("Cálculo para valor x = "+x);
        System.out.println(pol.calcula(x));
    }
}
