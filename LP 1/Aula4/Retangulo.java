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
public class Retangulo {
    private int l, a, x , y;
    
    public Retangulo(){
        this.l = 0;
        this.a = 0;
        this.x = 0;
        this.y = 0;
    }
    
    public Retangulo(int a, int l){
        this.l = l;
        this.a = a;
        this.x = 0;
        this.y = 0;
    }
    
    public Retangulo(int a, int l, int x, int y){
        this.l = l;
        this.a = a;
        this.x = x;
        this.y = y;
    }
    
    public int perimetro(){
        return (int)((Math.pow((this.l), 2)) + (Math.pow((this.a), 2)));
    }
    
    public int area(){
        return (this.l*this.a);
    }
    
    public boolean interseccao(Retangulo novo){
        int fimX = this.x + this.l;
        int fimNovoX = novo.x + novo.l;
        int fimY = this.y + this.a;
        int fimNovoY = novo.y + novo.a;
        
        if(novo.x >= this.x && fimNovoX <= fimX){
            return true;
        }
        return novo.y >= this.y && fimNovoY <= fimY;
    }
    
    public void transladar(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public int getX(){
        return x;
    }
    
}
