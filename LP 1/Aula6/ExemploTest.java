package Aula6;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Aula4.Retangulo;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 31470203
 */
public class ExemploTest {
    
    
    @Test
    public void areaTest(){
        Retangulo r = new Retangulo(20, 30, 5, 10);
        Assert.assertEquals(600, r.area());
    }
    
    @Test
    public void trasladarTest(){
        Retangulo r = new Retangulo(20, 30, 5, 10);
        r.transladar(10, 10);
        Assert.assertEquals(15, r.getX());
    }
}
