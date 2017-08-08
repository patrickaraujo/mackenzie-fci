/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aula4;

/**
 *
 * @author Patrick
 */
public class RetanguloTest {
    public static void main(String[] args) {
        Retangulo x = new Retangulo(20, 40);
        Retangulo y = new Retangulo(20, 40, 0, 10);
        System.out.println("Perímetro: "+x.perimetro());
        System.out.println("Área: "+x.area());
        System.out.println("Intersecção: "+x.interseccao(y));
    }
}
